/*
 * ****************************************************************************
  * Copyright 2016, Govardhan. All rights reserved. An
 * unpublished work of Govardhan may only be used in accordance
 * with a license agreement with Govardhan. Any unauthorized
 * use, duplication or disclosure is prohibited.
 * ****************************************************************************
 * */
package com.sorting.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sorting.entity.SortingHistory;

/**
 * This class contains the  methods to perform 
 *  sorting related operations.
 * 
 * @author GOVARDHAN
 */
@Repository
public interface SortingDao extends JpaRepository<SortingHistory, Long> {

	@Override
	SortingHistory save(SortingHistory sortingHistory);

}
