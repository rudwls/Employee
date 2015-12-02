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

<c:url value="/city/" var="URL_GET_LIST"/>
<c:url value="/city/page/" var="URL_GET_PAGE_BASE"/>
<c:url value="/city/" var= "URL_GET_ITEM_BASE"/>

<c:url value="/city/" var="URL_POST_ITEM_APPEND"/>
<c:url value="/city/" var="URL_POST_LIST_APPEND"/>


<c:url value="/city/" var="URL_PUT_LIST_MODIFY"/>
<c:url value="/city/" var="URL_PUT_ITEM_MODIFY_BASE"/>


<c:url value="/city/" var="URL_DELETE_ITEM_DELETE_BASE"/>

<title>template.jsp</title>
<script type="text/javascript">
	
	var urls ={
			GET_LIST:				"${URL_GET_LIST}",
			GET_PAGE_BASE: 			"${URL_GET_PAGE_BASE}",
			GET_ITEM_BASE:			"${URL_GET_ITEM_BASE}",
			
			POST_ITEM_APPEND:		"${URL_POST_ITEM_APPEND}",
			POST_LIST_APPEND: 		"${URL_POST_LIST_APPEND}",
			
			PUT_LIST_MODIFY:		"${URL_PUT_LIST_MODIFY}",
			PUT_ITEM_MODIFY_BASE: 	"${URL_PUT_ITEM_MODIFY_BASE}",
			
			DELETE_ITEM_DELETE_BASE:"${URL_DELETE_ITEM_DELETE_BASE}"
			
			
	};

	var deps = [ 'ngRoute', 'ngAnimate', 'ngTouch', 'angular-loading-bar' ];
	var app = angular.module("employeeApp", deps);
	
	app.constant("URL", urls);

	

	app.controller("mainController", function($scope, $http, $location) {
		console.log("mainController...");
		
		$location.path("/list");

	});
</script>
</head>
<c:url var="listController" value="/js/city/listController.js"/>
<c:url var="detailController" value="/js/city/detailController.js"/>
<c:url var="appendController" value="/js/city/appendController.js"/>
<c:url var="deleteController" value="/js/city/deleteController.js"/>
<c:url var="modifyController" value="/js/city/modifyController.js"/>

<script type="text/javascript" src=${listController }></script>
<script type="text/javascript" src=${detailController }></script>
<script type="text/javascript" src=${appendController }></script>
<script type="text/javascript" src=${deleteController }></script>
<script type="text/javascript" src=${modifyController }></script>
<body data-ng-controller="mainController" class="container">
test
<h2>{{title}}</h2>
<div data-ng-view></div>

</body>
</html>