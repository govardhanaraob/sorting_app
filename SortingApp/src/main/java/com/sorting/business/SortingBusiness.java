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

import com.sorting.entity.SortingHistory;
import com.sorting.entity.SortingList;

/**
 * This interface contains the  methods to perform 
 *  sorting related operations.
 * 
 * @author GOVARDHAN
 */
public interface SortingBusiness {

	/*
	 * interface for sorting list
	 */
	public SortingList getSortedList(SortingList sortingList) throws Exception;

	/*
	 * sorting history
	 */
	public List<SortingHistory> getSortedSortedList() throws Exception;

}
