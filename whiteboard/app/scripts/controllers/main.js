'use strict';

/**
 * @ngdoc function
 * @name whiteboardApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the whiteboardApp
 */
angular.module('whiteboardApp')
	.controller('MainCtrl', function ($scope, $timeout, wbservice) {
		$scope.tit = '';
		$scope.items = [];
		//wbservice.getAll();
		$scope.$watch('text', function () {});
		$scope.$on('ws-message', function (event, serverArray) {
			$scope.items = serverArray;
			$scope.$apply();
			console.log('nuevo items');
			console.log($scope.items);
		});
		$timeout(function () {
			wbservice.getAll();
		}, 1000);

	});