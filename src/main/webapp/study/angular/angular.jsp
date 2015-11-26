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
.red {
	background-color: red;
	color: white;
}
</style>
<script type="text/javascript">
	var app = angular.module("employeeApp", []);
	app.controller("examController", function($scope, $http) {
		$scope.title = "Angular 기본구조 연습";
		$scope.titleClick = function() {
			$scope.title += "+";
		};
		$scope.name = "홍길동";

		$scope.depts = [ {
			deptno : 10,
			dname : '총무부1',
			loc : 'seoul1'
		}, {
			deptno : 20,
			dname : '총무부2',
			loc : 'seoul2'
		}, {
			deptno : 30,
			dname : '총무부3',
			loc : 'seoul3'
		}, {
			deptno : 40,
			dname : '총무부4',
			loc : 'seoul4'
		}, {
			deptno : 50,
			dname : '총무부5',
			loc : 'seoul5'
		} ];

		$scope.deleteDept = function(index) {
			var id = $scope.dept[index].deptno;
			alert("index: " + id);

			$scope.depts.splice(index, 1);

		};
		$scope.imgs = [ {
			alt : '100',
			src : 'http://www.placehold.it/100x100/ff0000/00ffff?text=cat1'
		}, {
			alt : '200',
			src : 'http://www.placehold.it/200x100/00ff00/ff00ff?text=cat2'
		}, {
			alt : '300',
			src : 'http://www.placehold.it/300x100/0000ff/ffff00?text=dog1'
		}, {
			alt : '400',
			src : 'http://www.placehold.it/400x100/ff00ff/00ff00?text=dog2'
		}, {
			alt : '500',
			src : 'http://www.placehold.it/500x100/ffff00/0000ff?text=rabbit'
		} ];
	});
</script>
<title>angular.jsp</title>
</head>
<body data-ng-controller="examController">
	<h1 data-ng-click="titleClick()">{{title}}</h1>
	<!-- 모델에 있는 변수 -->
	<p>3 + 4 = {{3 + 4}}</p>
	<hr>
	<!-- 모델을 동시에 설정해부림  -->
	<input type="text" data-ng-model="name">
	<h3>{{name}}</h3>
	<!-- 양방형 바인딩 -->
	<hr>
	<div class="table-responsive">
		<!-- 화면의 크기에 따라 스크롤이 생긴다  -->
		<table class="table table-condensed">
			<thead class="red">
				<tr>
					<th>No</th>
					<th>deptno</th>
					<th>dname</th>
					<th>loc</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr data-ng-repeat="dept in depts">
					<td>{{$index}}</td>
					<td>{{dept.deptno}}</td>
					<td>{{dept.dname}}</td>
					<td>{{dept.loc}}</td>
					<td><a href="#" class="btn btn-primary"
						data-ng-click="deleteDept($index)">삭제</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<hr>
	<div class="table-responsive">
		<!-- 화면의 크기에 따라 스크롤이 생긴다  -->
		<table class="table table-condensed">
			<thead class="red">
				<tr>
					<td>deptno</td>
					<td>dname</td>
					<td>loc</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>{{depts[0].deptno}}</td>
					<td>{{depts[0].dname}}</td>
					<td>{{depts[0].loc}}</td>
				</tr>
				<tr>
					<td>{{depts[1].deptno}}</td>
					<td>{{depts[1].dname}}</td>
					<td>{{depts[1].loc}}</td>
				</tr>
				<tr>
					<td>{{depts[2].deptno}}</td>
					<td>{{depts[2].dname}}</td>
					<td>{{depts[2].loc}}</td>
				</tr>
				<tr>
					<td>{{depts[3].deptno}}</td>
					<td>{{depts[3].dname}}</td>
					<td>{{depts[3].loc}}</td>
				</tr>
			</tbody>
		</table>
	</div>
	<ul >
		<li data-ng-repeat="img in imgs">
		<img class="img-circle img-responsive" alt="{{img.alt}}" src="{{img.src}}"></li>
	</ul>
</body>
</html>