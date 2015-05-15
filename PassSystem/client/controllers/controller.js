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
  	$scope.deselect = function(){
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
            	$scope.spot = "";
        });
	}
  	$scope.deleteSubject = function (itemid){
  		//console.log(itemid);
  		Subject.deleteById({id: itemid});
  		getSubjects();
  	}
  	$scope.addSubject = function (){
  		//console.log($scope.spot);
  		Subject.create($scope.spot);
        getSubjects();   
  	}
  	$scope.editSubject = function(itemid){
  		//console.log(itemid);
  		$scope.spot = Subject.findById({id: itemid});
  	}
  	$scope.updateSubject = function(){
  		//console.log($scope.spot.studentId);
  		Subject.upsert($scope.spot);
  		getSubjects();
  	}
  	$scope.deselect = function(){
  		$scope.spot = "";
  	}  



  	//////////Staff\\\\\\\\\\

 	Staff.find().$promise.then(function(results){
 		$scope.allStaff = results;
 		});
	function getStaff() {
    	Staff.find(
       		function (result) {
            	$scope.allStaff = result;
            	$scope.spot = "";
        });
	}
  	$scope.deleteStaff = function (itemid){
  		//console.log(itemid);
  		Staff.deleteById({id: itemid});
  		getStaff();
  	}
  	$scope.addStaff = function (){
  		//console.log($scope.spot);
  		Staff.create($scope.spot);
        getStaff();   
  	}
  	$scope.editStaff = function(itemid){
  		//console.log(itemid);
  		$scope.spot = Staff.findById({id: itemid});
  	}
  	$scope.updateStaff = function(){
  		//console.log($scope.spot.studentId);
  		Staff.upsert($scope.spot);
  		getStaff();
  	}
  	$scope.deselect = function(){
  		$scope.spot = "";
  	}  



  	//////////Campus\\\\\\\\\\

 	Campus.find().$promise.then(function(results){
 		$scope.allCampus = results;
 		});
	function getCampus() {
    	Campus.find(
       		function (result) {
            	$scope.allCampus = result;
            	$scope.spot = "";
        });
	}
  	$scope.deleteCampus = function (itemid){
  		//console.log(itemid);
  		Campus.deleteById({id: itemid});
  		getCampus();
  	}
  	$scope.addCampus = function (){
  		//console.log($scope.spot);
  		Campus.create($scope.spot);
        getCampus();   
  	}
  	$scope.editCampus = function(itemid){
  		//console.log(itemid);
  		$scope.spot = Campus.findById({id: itemid});
  	}
  	$scope.updateCampus = function(){
  		//console.log($scope.spot.studentId);
  		Campus.upsert($scope.spot);
  		getCampus();
  	}
  	$scope.deselect = function(){
  		$scope.spot = "";
  	}  



 	//////////Locations\\\\\\\\\\

 	Locations.find().$promise.then(function(results){
 		$scope.allLocations = results;
 		});
	function getLocations() {
    	Locations.find(
       		function (result) {
            	$scope.allLocations = result;
            	$scope.spot = "";
        });
	}
  	$scope.deleteLocations = function (itemid){
  		//console.log(itemid);
  		Locations.deleteById({id: itemid});
  		getLocations();
  	}
  	$scope.addLocations = function (){
  		//console.log($scope.spot);
  		Locations.create($scope.spot);
        getLocations();   
  	}
  	$scope.editLocations = function(itemid){
  		//console.log(itemid);
  		$scope.spot = Locations.findById({id: itemid});
  	}
  	$scope.updateLocations = function(){
  		//console.log($scope.spot.studentId);
  		Locations.upsert($scope.spot);
  		getLocations();
  	}
  	$scope.deselect = function(){
  		$scope.spot = "";
  	} 


 	//////////PassSessions\\\\\\\\\\

 	PassSession.find().$promise.then(function(results){
 		$scope.allPassSessions = results;
 		});
	function getPassSessions() {
    	PassSession.find(
       		function (result) {
            	$scope.allPassSessions = result;
            	$scope.spot = "";
        });
	}
  	$scope.deletePassSession = function (itemid){
  		//console.log(itemid);
  		PassSession.deleteById({id: itemid});
  		getPassSessions();
  	}
  	$scope.addPassSession = function (){
  		//console.log($scope.spot);
  		PassSession.create($scope.spot);
        getPassSessions();   
  	}
  	$scope.editPassSession = function(itemid){
  		//console.log(itemid);
  		$scope.spot = PassSession.findById({id: itemid});
  	}
  	$scope.updatePassSession = function(){
  		//console.log($scope.spot.studentId);
  		PassSession.upsert($scope.spot);
  		getPassSessions();
  	}
  	$scope.deselect = function(){
  		$scope.spot = "";
  	} 


 	//////////Weeks\\\\\\\\\\

 	Week.find().$promise.then(function(results){
 		$scope.allWeeks = results;
 		});
	function getWeeks() {
    	Week.find(
       		function (result) {
            	$scope.allWeeks = result;
            	$scope.spot = "";
        });
	}
  	$scope.deleteWeek = function (itemid){
  		//console.log(itemid);
  		Week.deleteById({id: itemid});
  		getWeeks();
  	}
  	$scope.addWeek = function (){
  		//console.log($scope.spot);
  		Week.create($scope.spot);
        getWeeks();   
  	}
  	$scope.editWeek = function(itemid){
  		//console.log(itemid);
  		$scope.spot = Week.findById({id: itemid});
  	}
  	$scope.updateWeek = function(){
  		//console.log($scope.spot.studentId);
  		Week.upsert($scope.spot);
  		getWeeks();
  	}
  	$scope.deselect = function(){
  		$scope.spot = "";
  	} 


	//////////Users\\\\\\\\\\

 	User.find().$promise.then(function(results){
 		$scope.allUsers = results;
 		});
	function getUsers() {
    	User.find(
       		function (result) {
            	$scope.allUsers = result;
            	$scope.spot = "";
        });
	}
  	$scope.deleteUser = function (itemid){
  		//console.log(itemid);
  		User.deleteById({id: itemid});
  		geUsers();
  	}
  	$scope.addUser = function (){
  		//console.log($scope.spot);
  		User.create($scope.spot);
        getUsers();   
  	}
  	$scope.editUser = function(itemid){
  		//console.log(itemid);
  		$scope.spot = User.findById({id: itemid});
  	}
  	$scope.updateUser = function(){
  		//console.log($scope.spot.studentId);
  		User.upsert($scope.spot);
  		getUsers();
  	}
  	$scope.deselect = function(){
  		$scope.spot = "";
  	} 

}]);