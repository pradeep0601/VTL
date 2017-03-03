var app = angular.module('vtrApp',['ngRoute']);

app.config(function($routeProvider){
	$routeProvider
	.when('/home',{
		templateUrl : '/views/home.html',
		controller : 'vtrCtrl'
	})
	.otherwise({
		redirectTo : '/home'
	});
});