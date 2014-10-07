'use strict';

/**
 * @ngdoc directive
 * @name whiteboardApp.directive:wbcreate
 * @description
 * # wbcreate
 */
angular.module('whiteboardApp')
	.directive('wbcreate', function () {
		return {
			scope: {
				items: '='
			},
			template: '<div class="jumbotron"> ' +
				'<table style="width:100%"><tr><td>Title:</td>' +
				'<td><input ng-model="tit" class="form-control"/></td></tr></table>' +
				'<span class="input-group-btn">' +
				'<button class="btn btn-default dropdown-toggle" ng-click="addItem(tit)">Add Task</button>' +
				'</span>',
			restrict: 'E',
			controller: function ($scope, wbservice) {
				$scope.addItem = function (title) {
					var newItem = {
						title: title,
						description: '',
						name: '',
						color: '#fffb00',
						category: '',
						done: false,
						id: 0
					};
					wbservice.create(newItem);
					$scope.tit = '';

				};
			}
		};
	});