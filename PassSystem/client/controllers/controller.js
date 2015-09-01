angular.module('myApp',
  ['lbServices']).controller('Controller', ['$scope', 'Student', 'Staff', 'Subject', 'Campus', 'Location', 'Attendences', 'Week', 'User',
  function($scope, Student, Staff, Subject, Campus, Locations, Attendences, Week, User) {
    $scope.allStudents = [];
    $scope.allSubjects = [];
    $scope.allStaff = [];
    $scope.allCampus = [];
    $scope.allLocations = [];
    $scope.allAttendences = [];
    $scope.allWeeks = [];
    $scope.allUsers = [];

    $scope.attendancesToSubmit = [];

  	$scope.subjectSelect="";
    $scope.weekSelect="";


    $scope.subjectForMarking=[];


    $scope.printItem = function(){
      console.log($scope.subjectSelect.code + $scope.weekSelect.name);
    }

    //Used to modify a table for marking attendance.
    $scope.findSubjectForMarking = function(){
      //$scope.printItem()
      if($scope.subjectSelect == ""){
        //console.log("No subject selected")
      }else{
        //console.log("Selected" + $scope.subjectSelect.subjectId);

        //Assign selected subject to new var to use statically
        $scope.subjectForMarking = $scope.subjectSelect;

        //Create new array to manage the student objects
        $scope.enrolledStudents = $scope.subjectForMarking.enrolled;
        //console.log("marking" + $scope.subjectSelect + "For: " + $scope.enrolledStudents);


        //$scope.enrolledStudents.forEach(function (arrayElem){
        //  console.log(arrayElem.studentId);
      }

    }

    //Gets the student object from the table and creates an array containing a studentId, subjectId and weekId to be used
    //when creating an attendance object
    $scope.addToAttendances = function(student){
      console.log("selected add to attendances")
      $scope.newAttendance = [];

      $scope.newAttendance.push(student.studentId,$scope.subjectForMarking.subjectId,$scope.weekSelect.weekId)

      //console.log($scope.newAttendance )

      $scope.attendancesToSubmit.push($scope.newAttendance)
      //console.log($scope.attendancesToSubmit)

    }
    //Handles the binding of the vars to the Attendance object for adding to db
    $scope.submitAttendancesToDb = function(){
      console.log("Submitting to db")

      //Pulling vars from arrays to bind to Attendence object
      angular.forEach($scope.attendancesToSubmit, function(arrayElem){
        console.log("Array contains:")
        console.log(arrayElem[0]) //stuId
        console.log(arrayElem[1]) //subId
        console.log(arrayElem[2]) //weekId

        //persist Attendance object to db, <--DOESNT bind vars, fails on undefined student
        //Attendences.create(Attendences.student.arrayElem[0], Attendences.subject.arrayElem[1], Attendences.week.arrayElem[2])
      });

    }


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
    console.log("Called Students.find")
 		$scope.allStudents = results;
 		});
	function getStudents() {
    console.log("Called getStudents")
    	Student.find(
       		function (result) {
            	$scope.allStudents = result;
            	$scope.spot = "";
        });
	}

    $scope.getStudentById = function (itemid){
      //console.log(itemid);
      return Student.findById({id: itemid});
      //getStudents();
    //
    }

  	$scope.deleteStudent = function (itemid){
  		//console.log(itemid);
  		Student.deleteById({id: itemid});
  		getStudents();
  	}
  	$scope.addStudent = function (){
  		console.log("Called" + $scope.spot);
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


 	//////////Attendences\\\\\\\\\\

 	Attendences.find().$promise.then(function(results){
 		$scope.allAttendences = results;
 		});
	function getAttendences() {
    	Attendences.find(
       		function (result) {
            	$scope.allAttendences = result;
            	$scope.attendences = "";
        });
	}
  	$scope.deleteAttendences = function (itemid){
  		//console.log(itemid);
  		Attendences.deleteById({id: itemid});
  		getAttendences();
  	}
  	$scope.addAttendences = function (){
    console.log("Called add")
  		Attendences.create($scope.Attendences);
        getAttendences();
  	}

  	$scope.editAttendences = function(itemid){
  		//console.log(itemid);
  		$scope.attendences = Attendences.findById({id: itemid});
  	}
  	$scope.updateAttendences = function(){
  		//console.log($scope.spot.studentId);
  		Attendences.upsert($scope.attendences);
  		getAttendences();
  	}
  	$scope.deselectAttendences = function(){
  		$scope.attendences = "";
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
   	$scope.deselectUser = function(){
   		$scope.spot = "";
   	}

}]);
