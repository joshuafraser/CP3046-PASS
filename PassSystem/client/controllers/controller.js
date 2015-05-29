angular.module('myApp',
  ['lbServices']).controller('Controller', ['$scope', 'Student', 'Staff', 'Subject', 'Campus', 'Location', 'PassSession', 'Week', 'User', 
  function($scope, Student, Staff, Subject, Campus, Locations, PassSession, Week, User) {
 	$scope.allStudents = [];
 	$scope.allSubjects = [];
 	$scope.allStaff = [];
 	$scope.allCampus = [];
 	$scope.allLocations = [];
 	$scope.allPassSessions = [];
 	$scope.allWeeks = [];
 	$scope.allUsers = [];

 	




 	
  //make 
  $scope.makeSelectVisible = function(){
      if ($scope.subjectSelect != null){
        document.getElementById("weekSelectID").style.visibility = "visible";
      } else {
        document.getElementById("weekSelectID").style.visibility = "hidden";
      }   
  }
      

  $scope.submit = function() {

    //$scope.username1 = Student.find();
    $scope.password1 = this.password;   
    $scope.username1 = "Hasn't been changed";
    var x;
    var count = 0;
    // for (x in $scope.allStudents){
    //    count ++;
    //    $scope.username1 = count; 
    // }

    for (i=0;i<$scope.allStudents.length;i++){
      //count++;
      if (this.username == $scope.allStudents[i]["firstName"] 
        && this.password == $scope.allStudents[i]["lastName"]){
        $scope.username1 = "It Worked";
      }
    }
    //$scope.username1 = $scope.allStudents;   
    $scope.username = '';
    $scope.password = '';  
  }




  //////////Student\\\\\\\\\\

 	Student.find().$promise.then(function(results){
 		$scope.allStudents = results;
 		});
	function getStudents() {
    	Student.find(
       		function (result) {
            	$scope.allStudents = result;
            	$scope.spot = "";
        });
	}

    $scope.getStudentById = function (itemid){
      //console.log(itemid);
      Student.findById({id: itemid});
      getStudents();
    }

  	$scope.deleteStudent = function (itemid){
  		//console.log(itemid);
  		Student.deleteById({id: itemid});
  		getStudents();
  	}
  	$scope.addStudent = function (){
  		//console.log($scope.spot);
  		Student.create($scope.spot);
        getStudents();   
  	}
  	$scope.editStudent = function(itemid){
  		//console.log(itemid);
  		$scope.spot = Student.findById({id: itemid});
  	}
  	$scope.updateStudent = function(){
  		//console.log($scope.spot.studentId);
  		Student.upsert($scope.spot);
  		getStudents();
  	}
  	$scope.deselectStudent = function(){
  		$scope.spot = "";
  	}  


  	//////////Subject\\\\\\\\\\

 	Subject.find().$promise.then(function(results){
 		$scope.allSubjects = results;
 		});
	function getSubjects() {
    	Subject.find(
       		function (result) {
            	$scope.allSubjects = result;
            	$scope.subject = "";
        });
	}
  	$scope.deleteSubject = function (itemid){
  		//console.log(itemid);
  		Subject.deleteById({id: itemid});
  		getSubjects();
  	}
  	$scope.addSubject = function (){
  		//console.log($scope.spot);
  		Subject.create($scope.subject);
        getSubjects();   
  	}
  	$scope.editSubject = function(itemid){
  		//console.log(itemid);
  		$scope.subject = Subject.findById({id: itemid});
  	}
  	$scope.updateSubject = function(){
  		//console.log($scope.spot.studentId);
  		Subject.upsert($scope.subject);
  		getSubjects();
  	}
  	$scope.deselectSubject = function(){
  		$scope.subject = "";
  	}  



  	//////////Staff\\\\\\\\\\

 	Staff.find().$promise.then(function(results){
 		$scope.allStaff = results;
 		});
	function getStaff() {
    	Staff.find(
       		function (result) {
            	$scope.allStaff = result;
            	$scope.staff = "";
        });
	}
  	$scope.deleteStaff = function (itemid){
  		//console.log(itemid);
  		Staff.deleteById({id: itemid});
  		getStaff();
  	}
  	$scope.addStaff = function (){
  		//console.log($scope.spot);
  		Staff.create($scope.staff);
        getStaff();   
  	}
  	$scope.editStaff = function(itemid){
  		//console.log(itemid);
  		$scope.staff = Staff.findById({id: itemid});
  	}
  	$scope.updateStaff = function(){
  		//console.log($scope.spot.studentId);
  		Staff.upsert($scope.staff);
  		getStaff();
  	}
  	$scope.deselectStaff = function(){
  		$scope.staff = "";
  	}  



  	//////////Campus\\\\\\\\\\

 	Campus.find().$promise.then(function(results){
 		$scope.allCampus = results;
 		});
	function getCampus() {
    	Campus.find(
       		function (result) {
            	$scope.allCampus = result;
            	$scope.campus = "";
        });
	}
  	$scope.deleteCampus = function (itemid){
  		//console.log(itemid);
  		Campus.deleteById({id: itemid});
  		getCampus();
  	}
  	$scope.addCampus = function (){
  		//console.log($scope.spot);
  		Campus.create($scope.campus);
        getCampus();   
  	}
  	$scope.editCampus = function(itemid){
  		//console.log(itemid);
  		$scope.campus = Campus.findById({id: itemid});
  	}
  	$scope.updateCampus = function(){
  		//console.log($scope.spot.studentId);
  		Campus.upsert($scope.campus);
  		getCampus();
  	}
  	$scope.deselectCampus = function(){
  		$scope.campus = "";
  	}  



 	//////////Locations\\\\\\\\\\

 	Locations.find().$promise.then(function(results){
 		$scope.allLocations = results;
 		});
	function getLocations() {
    	Locations.find(
       		function (result) {
            	$scope.allLocations = result;
            	$scope.locations = "";
        });
	}
  	$scope.deleteLocations = function (itemid){
  		//console.log(itemid);
  		Locations.deleteById({id: itemid});
  		getLocations();
  	}
  	$scope.addLocations = function (){
  		//console.log($scope.spot);
  		Locations.create($scope.locations);
        getLocations();   
  	}
  	$scope.editLocations = function(itemid){
  		//console.log(itemid);
  		$scope.locations = Locations.findById({id: itemid});
  	}
  	$scope.updateLocations = function(){
  		//console.log($scope.spot.studentId);
  		Locations.upsert($scope.locations);
  		getLocations();
  	}
  	$scope.deselectLocations = function(){
  		$scope.locations = "";
  	} 


 	//////////PassSessions\\\\\\\\\\

 	PassSession.find().$promise.then(function(results){
 		$scope.allPassSessions = results;
 		});
	function getPassSessions() {
    	PassSession.find(
       		function (result) {
            	$scope.allPassSessions = result;
            	$scope.passSession = "";
        });
	}
  	$scope.deletePassSession = function (itemid){
  		//console.log(itemid);
  		PassSession.deleteById({id: itemid});
  		getPassSessions();
  	}
  	$scope.addPassSession = function (){
  		//console.log($scope.spot);
  		PassSession.create($scope.passSession);
        getPassSessions();   
  	}
  	$scope.editPassSession = function(itemid){
  		//console.log(itemid);
  		$scope.passSession = PassSession.findById({id: itemid});
  	}
  	$scope.updatePassSession = function(){
  		//console.log($scope.spot.studentId);
  		PassSession.upsert($scope.passSession);
  		getPassSessions();
  	}
  	$scope.deselectPassSessions = function(){
  		$scope.passSession = "";
  	} 


 	//////////Weeks\\\\\\\\\\

 	Week.find().$promise.then(function(results){
 		$scope.allWeeks = results;
 		});
	function getWeeks() {
    	Week.find(
       		function (result) {
            	$scope.allWeeks = result;
            	$scope.week = "";
        });
	}
  	$scope.deleteWeek = function (itemid){
  		//console.log(itemid);
  		Week.deleteById({id: itemid});
  		getWeeks();
  	}
  	$scope.addWeek = function (){
  		//console.log($scope.spot);
  		Week.create($scope.week);
        getWeeks();   
  	}
  	$scope.editWeek = function(itemid){
  		//console.log(itemid);
  		$scope.week = Week.findById({id: itemid});
  	}
  	$scope.updateWeek = function(){
  		//console.log($scope.spot.studentId);
  		Week.upsert($scope.week);
  		getWeeks();
  	}
  	$scope.deselectWeek = function(){
  		$scope.week = "";
  	} 


	//////////Users\\\\\\\\\\

 // 	User.find().$promise.then(function(results){
 // 		$scope.allUsers = results;
 // 		});
	// function getUsers() {
 //    	User.find(
 //       		function (result) {
 //            	$scope.allUsers = result;
 //            	$scope.spot = "";
 //        });
	// }
 //  	$scope.deleteUser = function (itemid){
 //  		//console.log(itemid);
 //  		User.deleteById({id: itemid});
 //  		geUsers();
 //  	}
 //  	$scope.addUser = function (){
 //  		//console.log($scope.spot);
 //  		User.create($scope.spot);
 //        getUsers();   
 //  	}
 //  	$scope.editUser = function(itemid){
 //  		//console.log(itemid);
 //  		$scope.spot = User.findById({id: itemid});
 //  	}
 //  	$scope.updateUser = function(){
 //  		//console.log($scope.spot.studentId);
 //  		User.upsert($scope.spot);
 //  		getUsers();
 //  	}
 //  	$scope.deselectUser = function(){
 //  		$scope.spot = "";
 //  	} 

}]);