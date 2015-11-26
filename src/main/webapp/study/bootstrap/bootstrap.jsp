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
<title>index.jsp</title>

<style type="text/css">
img{
	width: 100%;
	height: 100%;
}
</style>

<script type="text/javascript">
	var app = angular.module("employeeApp", []);
	app.controller("examController", function($scope) {

	});
</script>

</head>
<body data-ng-controller="examController">
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<img alt="xxx"
					src="http://www.placehold.it/100x100/ff0000/0000ff?text=50%">
			</div>
			<div class="col-sm-6">
				<img alt="xxx"
					src="http://www.placehold.it/100x100/ff00ff/0000ff?text=50%">
			</div>

		</div>
		<div class="row">
			<div class="col-sm-12">
				<img alt="xxx"
					src="http://www.placehold.it/100x100/0000ff/ffff00?text=100%"></div>
		
	</div></div>
	
	<body data-ng-controller="examController">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<img alt="xxx"
					src="http://www.placehold.it/100x100/ff0000/0000ff?text=50%">
			</div>
			<div class="col-md-6">
				<img alt="xxx"
					src="http://www.placehold.it/100x100/ff00ff/0000ff?text=50%">
			</div>

		</div>
		<div class="row">
			<div class="col-md-12">
				<img alt="xxx"
					src="http://www.placehold.it/100x100/0000ff/ffff00?text=100%"></div>
		</div>
	</div>


<div class="container">
		<img width="100%" class="img-responsive" alt=""
			src="http://www.placehold.it/500x200/ff0000/0000ff?text=container">
	</div>
	<div class="container-fluid">
		<img width="100%" class="img-responsive" alt=""
			src="http://www.placehold.it/500x200/ff00ff/00ff00?text=container">
	</div>
</body>
</html>