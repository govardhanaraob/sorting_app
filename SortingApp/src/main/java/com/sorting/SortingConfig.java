/*
 * ****************************************************************************
  * Copyright 2016, Govardhan. All rights reserved. An
 * unpublished work of Govardhan may only be used in accordance
 * with a license agreement with Govardhan. Any unauthorized
 * use, duplication or disclosure is prohibited.
 * ****************************************************************************
 * */
package com.sorting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication

/**
 * This class contains the  methods to perform 
 *  sorting related operations.
 * 
 * @author GOVARDHAN
 */
public class SortingConfig extends SpringBootServletInitializer {

	private static Class<SortingConfig> applicationClass = SortingConfig.class;

	public static void main(String[] args) {
		SpringApplication.run(SortingConfig.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(applicationClass);
	}
}
