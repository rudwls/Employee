app.config(function($routeProvider) {
	console.log("/detail config...");

	$routeProvider.when("/detail", {
		templateUrl : "detail.html",
		controller : "detailController"
	});
});

app.controller("detailController", function($scope, $http, URL) {
	console.log("detailController...");

	$scope.$parent.title = "Detail City View";

});