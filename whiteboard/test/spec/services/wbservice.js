'use strict';

describe('Service: wbservice', function () {

  // load the service's module
  beforeEach(module('whiteboardApp'));

  // instantiate service
  var wbservice;
  beforeEach(inject(function (_wbservice_) {
    wbservice = _wbservice_;
  }));

  it('should do something', function () {
    expect(!!wbservice).toBe(true);
  });

});
