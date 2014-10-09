'use strict';

/**
 * @ngdoc service
 * @name whiteboardApp.wbservice
 * @description
 * # wbservice
 * Factory in the whiteboardApp.
 */

angular.module('whiteboardApp').factory('wbservice', ['$q', '$rootScope',
  function ($q, $rootScope) {

    // We return this object to anything injecting our service
    var Service = [];

    // Create our websocket object with the address to the websocket
    var ws = new WebSocket('ws://localhost:8080/whiteboard/whiteboard');
    var open = false;

    ws.onopen = function (message) {
      console.log('Socket has been opened!');
      console.log('connected' + message);
      open = true;
      $rootScope.$broadcast('ws-open');
    };

    ws.onmessage = function (message) {
      $rootScope.$broadcast('ws-message', JSON.parse(message.data));
    };

    function sendRequest(request) {
      console.log('Sending request', request);
      if (open) {
        ws.send(JSON.stringify(request));
      } else {
        console.log('no esta open');
      }
    }


    Service.delete = function (id) {
      var request = {
        'type': 'delete',
        'data': id
      };
      sendRequest(request);
    };

    Service.create = function (newItem) {
      var request = {
        'type': 'put',
        'data': newItem
      };
      sendRequest(request);
    };

    Service.getAll = function () {
      var request = {
        'type': 'getAll',
        'data': null
      };
      sendRequest(request);
    };

    Service.update = function (uItem) {
      var request = {
        'type': 'post',
        'data': uItem
      };
      sendRequest(request);
    };

    return Service;
  }
]);