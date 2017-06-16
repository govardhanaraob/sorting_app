/*
 * ****************************************************************************
  * Copyright 2016, Govardhan. All rights reserved. An
 * unpublished work of Govardhan may only be used in accordance
 * with a license agreement with Govardhan. Any unauthorized
 * use, duplication or disclosure is prohibited.
 * ****************************************************************************
 * */
package com.sorting.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SortingList {

	private List<Integer> listOFItems;

	private long executionTime;
	
	private int interchangespositions;

	public int getInterchangespositions() {
		return interchangespositions;
	}

	public void setInterchangespositions(int interchangespositions) {
		this.interchangespositions = interchangespositions;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}

	public List<Integer> getListOFItems() {
		return listOFItems;
	}

	public void setListOFItems(List<Integer> listOFItems) {
		this.listOFItems = listOFItems;
	}

}
