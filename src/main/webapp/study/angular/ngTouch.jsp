<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp">
<!-- html5 한국어랭귀지 -->
<head>
<meta name="viewport" content="width=device-width, initail-scale=1.0">
<meta charset="UTF-8">
<%@ include file="/WEB-INF/view/common.jspf"%>

<style type="text/css">
.swipe-box {
	height: 200px;
	background-color: red;
	border: 1px solid black;
}
</style>


<title>ngTouch.jsp</title>
<script type="text/javascript">
	var deps = [ 'ngRoute', 'ngAnimate', 'ngTouch', 'angular-loading-bar' ];
	var app = angular.module("employeeApp", deps);

	app.controller("mainController", function($scope, $http) {
		console.log("mainController...");

		$scope.swipeLeft = function(e) {
			console.log("swipeLeft...");
			console.dir(e);
			$(e.target).css('border-radius', '0px');
			$scope.msg = "ng-swipe-left fired...";
		};
		$scope.swipeRight = function(e) {
			console.log("swipeRight...");
			console.dir(e);

			$(e.target).css('border-radius', '50px');

			$scope.msg = "ng-swipe-right fired...";

		};

		/* 		
			 img test
		 */

		$scope.imgURL = "http://www.placehold.it/400x400";
		

		$scope.imgSwipeLeft = function(e) {
			console.log("imgSwipeLeft...");
			console.dir(e);
			$scope.imgmsg = "ng-swipe-left fired...";

			$scope.imgURL = "http://www.placehold.it/400x400/ff0000/00ffff?text=SwipeLeft...";
			
		};
		$scope.imgSwipeRight = function(e) {
			console.log("imgSwipeRight...");
			console.dir(e);
			$scope.imgmsg = "ng-swipe-right fired...";
			
			$scope.imgURL = "http://www.placehold.it/400x400/0000ff/ffff00?text=SwipeRight...";

		};
		
		

		
	});
</script>
</head>
<body data-ng-controller="mainController" class="container">
	<h2>ngTouch.jsp</h2>

	<div data-ng-swipe-left="swipeLeft($event)"
		data-ng-swipe-right="swipeRight($event)" class="swipe-box"></div>
	<hr>
	<p>{{msg}}</p>
	<hr>
	
	<img data-ng-swipe-left="imgSwipeLeft($event)"
		data-ng-swipe-right="imgSwipeRight($event)"
	draggable="false" class="img-responsive" alt="{{imgURL}}" src="{{imgURL}}">
	
	<p>{{imgmsg}}
	</p>

</body>
</html>