'use strict';

/**
 * @ngdoc function
 * @name whiteboardApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the whiteboardApp
 */
angular.module('whiteboardApp')
	.controller('MainCtrl', function ($scope, $http) {
		$scope.tit = '';
		$scope.items = [];

		$scope.getAll = function () {
			$http.get('http://localhost:14782/floggit').success(function (response) {
				$scope.items = response;
			});
		};
		// console.log($scope.$parent);
		$scope.getAll();
	});