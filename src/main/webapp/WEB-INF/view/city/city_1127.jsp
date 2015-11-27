<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp">
<!-- html5 한국어 -->
<head>
<meta name="viewport" content="width=device-width, initail-scale=1.0">
<meta charset="UTF-8">

<%@ include file="/WEB-INF/view/common.jspf"%>

<title>city.jsp</title>

<c:url var="url_all" value="/city" />
<c:url var="url_page" value="/city/page/" />

<script type="text/javascript">
	var app = angular.module('employeeApp', []);
	app.controller('listController', function($scope, $http) {
		var url_all = "${url_all}";
		var url_page = "${url_page}";

		$http.get(url_all).success(function(data, status, headers, config) {
			console.dir(data);
			alert('success...');
		});

	});
</script>
</head>
<body data-ng-controller="listController" class="container">
	<h1>City list</h1>
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<table class="table table-striped">
				<thead>
					<th>ID</th>
					<th>NAME</th>
					<th>COUNTRY CODE</th>
					<th>DISTRICT</th>
					<th>POPULATION</th>
				</thead>
				<tbody>

				</tbody>
			</table>

		</div>
		<div class="col-sm-2"></div>
	</div>

	<div class="row">
		<div class="col-sm-12">
			<textarea rows="10">{{result}}</textarea>
		</div>
	</div>
</body>
</html>