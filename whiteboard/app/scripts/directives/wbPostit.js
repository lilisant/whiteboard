'use strict';

/**
 * @ngdoc directive
 * @name whiteboardApp.directive:wbcreateWindow
 * @description
 * # wbcreateWindow 
 name="username" ng-model="userinput" placeholder="username"
 */
angular.module('whiteboardApp')
	.directive('wbPostit', function () {
		return {
			scope: {
				postitItem: '='
			},
			template: '<li class="postit Field" style="background-color:{{postitItem.color}}" >' +
				'<b>Title: </b></br>' +
				'<input type="text" name="tit1" style="width:97%; background-color:{{postitItem.color}}; border: 2px solid {{postitItem.color}}" ng-model="postitItem.title"  value="{{postitItem.title}}" class="Field"/> </br>' +
				'<b>Description:</b> </br>' +
				'<textarea id="text1"rows="4" cols="35"  name="desc" ng-model="postitItem.description" class="Field" style="background-color:{{postitItem.color}}; border: 2px solid {{postitItem.color}}"></textarea></br>' +
				'<b>Name:</b> </br>' +
				'<textarea id="text2" rows="2" cols="35" name="nam" ng-model="postitItem.name" class="Field" style="background-color:{{postitItem.color}}; border: 2px solid {{postitItem.color}}"></textarea></br>' +
				'<b>Complete: <b>' +
				'<input type="checkbox" ng-model="postitItem.done"/> ' +
				'<input type="color" ng-model="postitItem.color">' +
				'</br>' +
				'</br>' +
				'<button class="btn btn-default" ng-click="delete(postitItem.id)" style="background-color: #FBEFF8;">' +
				'<i class = "glyphicon glyphicon-trash"></i></button>' +
				'<button class="btn btn-default" ng-click="up()" style="background-color: #FBEFF8;">' +
				'<i class = "glyphicon glyphicon-refresh"></i></button>' +

			'</li>',
			restrict: 'E',
			controller: function ($scope, wbservice) {
				$scope.delete = function (id) {
					var r = window.confirm('Press ok to delete.');
					if (r === true) {
						wbservice.delete(id);
					}
				};
				$scope.up = function () {
					wbservice.update($scope.postitItem);
				};
			}
		};
	});