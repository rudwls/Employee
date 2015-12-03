<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<!-- html5 한국어 -->
<head>
<!-- <meta name="viewport" content="width=device-width, initail-scale=1.0"> -->
<!-- <meta charset="UTF-8"> -->

<%-- <%@ include file="/WEB-INF/view/common.jspf"%> --%>

<title>city.jsp</title>

<%-- <c:url var="url_all" value="/city" /> --%>
<%-- <c:url var="url_page" value="/city/page/" /> --%>
<script type="text/javascript" src="/Employee/js/city/listController.js"></script>

</head>
<body class="container">
	<div class="table-responsive">
		<ul class="pagination">
			<li><button data-ng-click="prevClick(paging.firstPage - 1)">Prev</button></li>
			<li data-ng-repeat="city in citys">
				<button data-ng-click="pageClick(paging.firstPage + $index)">{{paging.firstPage
					+ $index}}</button>
			</li>
			<li><button data-ng-click="nextClick(paging.lastPage + 1)">Next</button></li>

		</ul>
		<table class="table table-striped table-hover">
			<thead>
			<tr>
<a href="#/append" class="btn btn-primary">Append</a></tr>
			<tr>
				<th>NO</th>
				<th>ID</th>
				<th>NAME</th>
				<th>COUNTRY CODE</th>
				<th>DISTRICT</th>
				<th>POPULATION</th>
				<th>EDIT</th>
				<th>DELETE</th>
			</tr>
			</thead>
			<tbody>
				<tr data-ng-repeat="city in citys">
					<td>{{$index+1}}</td>
					<td><a href="#/detail">{{city.id}}</a></td>
					<td>{{city.name}}</td>
					<td>{{city.countryCode}}</td>
					<td>{{city.district}}</td>
					<td>{{city.population}}</td>
					<td>
<a href="#/modify" class="btn btn-info">Modify</a></td>
					<td>
<a href="#/delete" class="btn btn-">Delete</a></td>
				</tr>

			</tbody>
		</table>

	</div>
	<hr>
	<div class="form-group">
		<textarea rows="20" class="form-control">
			{{citys}}
			{{paging}}</textarea>
	</div>
</body>
</html>