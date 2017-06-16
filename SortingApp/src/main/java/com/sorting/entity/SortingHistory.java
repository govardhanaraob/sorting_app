/*
 * ****************************************************************************
  * Copyright 2016, Govardhan. All rights reserved. An
 * unpublished work of Govardhan may only be used in accordance
 * with a license agreement with Govardhan. Any unauthorized
 * use, duplication or disclosure is prohibited.
 * ****************************************************************************
 * */
package com.sorting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sort")
public class SortingHistory {

	private static final long serialVersionUID = -7049957706738879274L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String listOFItems;
	private String aftersortitems;	
	private int interchangespositions;

	/**
	 * @return the aftersortitems
	 */
	public String getAftersortitems() {
		return aftersortitems;
	}

	/**
	 * @param aftersortitems
	 *            the aftersortitems to set
	 */
	public void setAftersortitems(String aftersortitems) {
		this.aftersortitems = aftersortitems;
	}

	private long executionTime;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the listOFItems
	 */
	public String getListOFItems() {
		return listOFItems;
	}

	/**
	 * @param listOFItems
	 *            the listOFItems to set
	 */
	public void setListOFItems(String listOFItems) {
		this.listOFItems = listOFItems;
	}

	/**
	 * @return the executionTime
	 */
	public long getExecutionTime() {
		return executionTime;
	}

	/**
	 * @param executionTime
	 *            the executionTime to set
	 */
	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}
	
	public int getInterchangespositions() {
		return interchangespositions;
	}

	public void setInterchangespositions(int interchangespositions) {
		this.interchangespositions = interchangespositions;
	}

	public SortingHistory() {

	}

}
