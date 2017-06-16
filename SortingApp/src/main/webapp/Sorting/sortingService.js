/*
 * ****************************************************************************
  * Copyright 2016, Govardhan. All rights reserved. An
 * unpublished work of Govardhan may only be used in accordance
 * with a license agreement with Govardhan. Any unauthorized
 * use, duplication or disclosure is prohibited.
 * ****************************************************************************
 * */
(function() {
	'use strict';
	angular.module('sortingApp').factory('SortingService', SortingService);
	SortingService.$inject = ['Restangular', '$http'];
	function SortingService(Restangular,$http,ngDailoge) {
		var soringService = {
				getListBySorting:getListBySorting,
				getSortedHistory:getSortedHistory,
		};
		return soringService;
		/*
         * This method is used to create patient details
        */
		 function getListBySorting(sortingObject){
            //need to change this call once integrated with service
			 return Restangular.all('SortingApp/sorting/').post(sortingObject).then(function(response){  
					return response;    			
			}, function(error) {    		   		
				return false;    		   	
			});
		};
		
		 function getSortedHistory(){
				return Restangular.one('SortingApp/sortinghistory/').get().then(function(response){					
					return response;
				}, function(error) {			   		
			   		return false;
			   	});
			};
	}
	})();