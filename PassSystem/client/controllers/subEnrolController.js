/**
 * Created by Stuart on 30/08/2015.
 */
var app = angular.module('myApp',
  ['lbServices']).controller('Controller', ['$scope', 'Student', 'Staff', 'Subject', 'Campus', 'Location', 'Attendences', 'Week', 'User',
    function($scope, Student, Subject, Attendences, Week,) {

      $scope.allAttendences = [];

    }]);

