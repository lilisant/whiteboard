'use strict';

/**
 * @ngdoc function
 * @name whiteboardApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the whiteboardApp
 */
angular.module('whiteboardApp')
	.controller('MainCtrl', function ($scope, wbservice) {
		$scope.tit = '';
		$scope.items = [];
		$scope.$watch('text', function () {});
		$scope.$on('ws-message', function (event, serverArray) {
			$scope.items = serverArray;
			$scope.$apply();
		});
		$scope.$on('ws-open', function () {
			console.log('open');
			wbservice.getAll();
		});
	});