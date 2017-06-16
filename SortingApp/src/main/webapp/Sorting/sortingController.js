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
	/**
	 * This class contains the  methods to perform 
	 *  sorting related operations.
	 * 
	 * @author GOVARDHAN
	 */
	angular.module('sortingApp').controller('createSortingController',createSortingController);
	createSortingController.$inject = ['$scope','$rootScope','SortingService'];
	function createSortingController($scope,$rootScope,SortingService) {
		var vm=this;

		vm.sortingObject= [''];
	 
        $scope.sort= function(){
    	var SortingList={"listOFItems":vm.sortingObject};
		SortingService.getListBySorting(SortingList)
		.then(function(result) {
			var aftersort=[];
			vm.aftersort=result.listOFItems;
			vm.executionTime=result.executionTime;
			vm.interchangespositions=result.interchangespositions;
			$scope.getSortedHistory();
		});
		};
		
		$scope.addEntry = function(){
			vm.sortingObject.push('');
		}
		
		$scope.removeEntry =function(index){
			vm.sortingObject.splice(index,1);
		}
		$scope.reload=function(){
			location.reload();
		}
		
		 $scope.getSortedHistory= function(){
				SortingService.getSortedHistory()
				.then(function(result) {
					$scope.sortHistory=result;
				});
				};
		
	};
})();