'use strict';

/**
 * @ngdoc function
 * @name whiteboardApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the whiteboardApp
 */
angular.module('whiteboardApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
