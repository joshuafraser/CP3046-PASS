(function() {
  var app = angular.module('csv', []);
  app.controller("csvController", ['$scope', function($scope) {
    $scope.MyFiles = [];
    $scope.data = [];

    $scope.showCSV = function() {
      var message = "Do you want to import: \n";
      for(var i = 0; i < $scope.data.length; i++) {
        message += " - " + $scope.data[i] + "\n";
      }
      message += "to the database?";
      var confirm = window.confirm(message);
      if(confirm) {
        window.alert("added to database");
      } else {
        window.alert("not added");
      }
    };

    $scope.handler = function(event, files) {
      if(document.getElementById("fileInput").value.split(".")[1] == "csv") {
        $scope.data = [];
        var reader = new FileReader();
        reader.onload = function (event) {
          var contents = reader.result;
          contents = contents.trim();
          var contentsArray = contents.split("\n");
          for (var i = 1; i < contentsArray.length; i++) {
            $scope.$apply($scope.data.push(contentsArray[i].trim()));
          }
          console.log($scope.data);
        };
        reader.readAsText(files[0]);
      } else {
        window.alert("That's not a csv!");
      }
    };
  }]);

  app.directive("fileChange", ['$parse', function($parse) {
    return {
      require: "ngModel",
      restrict: "A",
      link: function($scope, element, attrs, ngModel) {
        var attrHandler = $parse(attrs['fileChange']);
        var handler = function(e) {
          $scope.$apply(function() {
            attrHandler($scope, {$event: e, files: e.target.files})
          });
        };
        element[0].addEventListener('change', handler, false);
      }
    }
  }]);
})();
