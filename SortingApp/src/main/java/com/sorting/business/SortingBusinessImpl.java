/*
 * ****************************************************************************
  * Copyright 2016, Govardhan. All rights reserved. An
 * unpublished work of Govardhan may only be used in accordance
 * with a license agreement with Govardhan. Any unauthorized
 * use, duplication or disclosure is prohibited.
 * ****************************************************************************
 * */
package com.sorting.business;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.sorting.dao.SortingDao;
import com.sorting.entity.SortingHistory;
import com.sorting.entity.SortingList;


/**
 * This class contains the  methods to perform 
 *  sorting related operations.
 * 
 * @author GOVARDHAN
 */

@Component
public class SortingBusinessImpl implements SortingBusiness {

	/*
	 * @Autowired for SortingDao
	 */
	@Autowired
	private SortingDao sortingDao;

	/**
	 * Below method is used to sort the given list.
	 * 
	 * @param sortingList.
	 * @return sorted list.
	 * @throws Exception 
	 */
	@Override
	public SortingList getSortedList(SortingList sortingList) throws Exception {

		/*
		 * sorting values for list and calculating execution time
		 */
		SortingHistory sortingHistory=new SortingHistory() ;
		String beforesortinglistofitems = sortingList.getListOFItems().toString();		
		System.out.println("Before Soritng List of Items");
		sortingList.getListOFItems().forEach(n -> System.out.println(n));
		/* commenting API provided sorting */
		//Collections.sort(sortingList.getListOFItems());
		SortingList  aftersortedList=sortingOrder(sortingList);		
		System.out.println("After Soritng List of Items");
		aftersortedList.getListOFItems().forEach(n -> System.out.println(n));
		/* persisting data into sort table */
		sortingHistory.setListOFItems(beforesortinglistofitems);
		sortingHistory.setAftersortitems(aftersortedList.getListOFItems().toString());
		sortingHistory.setExecutionTime(aftersortedList.getExecutionTime());
		sortingHistory.setInterchangespositions(aftersortedList.getInterchangespositions());
		
		try{
		sortingDao.save(sortingHistory);
		}catch(DataAccessException dae){
			throw new Exception("Error while saving into databse",dae);
		}
		return aftersortedList;
	}
	
	/**
	 *  logic for custom sorting implementation 
	 *  
	 *  @Param SortingList,
	 *  @return SortingList
	 */
	private static SortingList sortingOrder(SortingList sortingList) {  
		int[] inputlist = sortingList.getListOFItems().stream().mapToInt(i->i).toArray();
		long startTime = System.nanoTime();
        int n = inputlist.length;  
        int swapItem = 0; 
        int swappedpostions=0;
         for(int i=0; i < n; i++){  
             for(int j=1; j < (n-i); j++){                 	  
                  if(inputlist[j-1] > inputlist[j]){  
                         //swap elements 
                	     swappedpostions++;
                	     swapItem = inputlist[j-1];  
                         inputlist[j-1] = inputlist[j];  
                         inputlist[j] = swapItem;
                        }  
               }  
         } 
         long endTime = System.nanoTime();
         long diff = (endTime - startTime) / 1000;
         List<Integer> outputlist = IntStream.of(inputlist).boxed().collect(Collectors.toList());
         sortingList.setListOFItems(outputlist);
         sortingList.setInterchangespositions(swappedpostions);
         sortingList.setExecutionTime(diff);
         return sortingList;
    }
	
	/**
	 * Below method is used to fetch the sorted list.
	 * 
	 * @return sorted list.
	 */
	@Override
	public List<SortingHistory> getSortedSortedList() throws Exception {
		/* retrieving history */
		List<SortingHistory>  sortingHistory;
		try{
		sortingHistory=sortingDao.findAll();
		}catch(DataAccessException dae){
			throw new Exception("Error while saving into databse",dae);	
		}
		return sortingHistory;
	}

}
