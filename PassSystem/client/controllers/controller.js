var myApp = angular.module('myApp', []);
myApp.controller('AppCtrl', ['$scope', '$http', function($scope, $http) {
    angular.module('my-app-module',
  ['ngRoute' /* etc */, 'lbServices', 'my-app.controllers']);
}]);