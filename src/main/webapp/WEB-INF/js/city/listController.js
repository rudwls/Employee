// 	var app = angular.module('employeeApp', []);

app.config(function($routeProvider) {
	console.log("route config...");

	$routeProvider.when("/list", {
		templateUrl : "list.html",
		controller : "listController"
	});
});

app.controller('listController', function($scope, $http, URL) {
	console.log("listController....");
	console.log("GET_PAGE_BASE...." + URL.GET_PAGE_BASE);

	$scope.$parent.title = "List City View"

	// var url_all = URL.GET_LIST;
	// var url_page = URL.GET_PAGE_BASE;

	$scope.citys = [];
	$scope.pageNo = 1;
	$scope.paging = {};

	/*
	 * $http.get(url_page + $scope.pageNo).success( function(data, status,
	 * headers, config) { console.dir(data); $scope.citys = data.citys;
	 * $scope.paging = data.paging; // alert('success...'); });
	 */
	$scope.selectPage = function() {
		$http.get(URL.GET_PAGE_BASE + $scope.pageNo).success(
				function(data, status, headers, config) {
					console.dir(data);
					$scope.citys = data.citys;
					$scope.paging = data.paging;
					// alert('success...');
				});
	};

	$scope.selectPage();

	$scope.prevClick = function(pageNo) {
		// console.dir("prevCilck pageNo = " + pageNo);
		$scope.pageNo = pageNo
		$scope.selectPage();

	};
	$scope.pageClick = function(pageNo) {
		// console.dir("pageCilck pageNo = " + pageNo);
		$scope.pageNo = pageNo
		$scope.selectPage();

	};
	$scope.nextClick = function(pageNo) {
		// console.dir("nextCilck pageNo = " + pageNo);
		$scope.pageNo = pageNo
		$scope.selectPage();

	};

});