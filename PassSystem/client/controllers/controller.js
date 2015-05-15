angular.module('myApp',
  ['lbServices']).controller('Controller', ['$scope', 'Student', 'Staff', 'Subject', function($scope, Student, Staff, Subject) {
 	$scope.allStudents = [];
 	$scope.allSubjects = [];
 	
 	//$scope.deleteID = Student.deleteById().$promise.then(function(id){
 	//	console.log(id);
 	//});
  	$scope.deleteID = function (itemid){
  		console.log(itemid);
  		
  		Student.deleteById({id: itemid});
  	}

  	


 	Student.find().$promise.then(function(results){
 		$scope.allStudents = results;
 	});




 	Subject.find().$promise.then(function(results){
 		$scope.allSubjects = results;
 		//console.log(results);
 	});


}]);