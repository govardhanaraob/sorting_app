/*
 * ****************************************************************************
  * Copyright 2016, Govardhan. All rights reserved. An
 * unpublished work of Govardhan may only be used in accordance
 * with a license agreement with Govardhan. Any unauthorized
 * use, duplication or disclosure is prohibited.
 * ****************************************************************************
 * */
package com.sorting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sorting.business.SortingBusiness;
import com.sorting.entity.SortingHistory;
import com.sorting.entity.SortingList;

/**
 * This class contains the  methods to perform 
 *  sorting related operations.
 * 
 * @author GOVARDHAN
 */
@RestController
public class SortingController {

	/*
	 * @Autowired for SortingBusiness
	 */
	@Autowired
	SortingBusiness sortingBusiness;

	/*
	 * service for sorting list of values
	 */
	@RequestMapping(value = "/sorting/", method = RequestMethod.POST)
	public SortingList getSortedList(@RequestBody SortingList sortingList) throws Exception{
		return sortingBusiness.getSortedList(sortingList) ;
	}

	/*
	 * service for sorting history
	 */
	@RequestMapping(value = "/sortinghistory/", method = RequestMethod.GET)
	public List<SortingHistory> getSortedHistoryList() throws Exception {
		return sortingBusiness.getSortedSortedList();
	}

}
