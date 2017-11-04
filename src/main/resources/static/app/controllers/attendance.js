angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('AttendanceController', function($http, $scope, $state) {
	$scope.clickedProducer = {};
	$scope.clickedAttendance = {};
	$scope.pageSize="10";
	$scope.currentPage="1";
	//$scope.attendance = {};
	
	$scope.saveAttendance = function() {
		$http.post('Attendance', $scope.attendance).success(function(res) {
			$scope.attendance = null;
			$scope.description = null;
			$scope.dados.$setPristine();
		    alert("Atendimento Registrado com Sucesso !");
		}).error(function(error) {
			$scope.message = error.message;
			alert("Erro ao salvar Atendimento !")
		});
	};
	
	var getAttendanciesActive = function(){
		$http.get('Attendance/getAttActive').success(function(res) {
			$scope.attendancies = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesActiveSport = function(){
		$http.get('Attendance/getAttActiveSport').success(function(res) {
			$scope.attendanciesProgress = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesFinally = function(){
		$http.get('Attendance/getAttFinally').success(function(res) {
			$scope.attendanciesFinally = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesFinallySport = function(){
		$http.get('Attendance/getAttFinallySport').success(function(res) {
			$scope.attendanciesFinallySport = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesHistoricFinallySport = function(){
		$http.get('Attendance/getAttFinallySport').success(function(res) {
			$scope.attendanciesHistoricFinallySport = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesHistoricFinally = function(){
		$http.get('Attendance/getAttFinally').success(function(res) {
			$scope.attendanciesHistoricFinally = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesNot = function(){
		$http.get('Attendance/getAttNot').success(function(res) {
			$scope.attendanciesNot = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesNotSport = function(){
		$http.get('Attendance/getAttNotSport').success(function(res) {
			$scope.attendanciesNotSport = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesActive = function(){
		$http.get('Attendance/totActive').success(function(res) {
			$scope.totActive = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesActiveSport = function(){
		$http.get('Attendance/totActiveSport').success(function(res) {
			$scope.totActiveSport = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesFinally = function(){
		$http.get('Attendance/totFinally').success(function(res) {
			$scope.totFinally = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesFinallySport = function(){
		$http.get('Attendance/totFinallySport').success(function(res) {
			$scope.totFinallySport = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	
	var getTotAttendanciesNot = function(){
		$http.get('Attendance/totNot').success(function(res) {
			$scope.totNot = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesNotSport = function(){
		$http.get('Attendance/totNotSport').success(function(res) {
			$scope.totNotSport = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	$scope.updateAttendance = function(){
		$http.put('Attendance', $scope.clickedAttendance).success(function(res) {
			$scope.attendance = null;
			//$scope.wife_name = null;
			//$scope.dados.$setPristine();
			//$scope.message = "Editado com Sucesso";
			//getAttendanciesActive();
			//getAttendanciesNot();
			//getAttendanciesFinally();
		}).error(function(error) {
			$scope.message =error.message;
		});
	}
	
	$scope.deleteAttendanceAgriculture = function(attendance) {
		$http.delete('Attendance/drop/'+attendance.id).success(function(res) {
			$scope.deleteMessage ="Success!";
			getAttendanciesFinally();
		}).error(function(error) {
			alert("Erro ao excluir este Registro !");
		});
	}
	
	$scope.deleteAttendanceSport = function(attendance) {
		$http.delete('Attendance/drop/'+attendance.id).success(function(res) {
			$scope.deleteMessage ="Success!";
			getAttendanciesFinallySport();
		}).error(function(error) {
			alert("Erro ao excluir este Registro !");
		});
	}
	
	var getProducers = function() {
		$http.get('Producer').success(function(res) {
			$scope.producers = res;
			//$scope.dados.$setPristine();
			$scope.message='';
			$scope.producer = null;
				
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getActivities = function() {
		$http.get('Activity/findActivities').success(function(res) {
			$scope.activities = res;
			//$scope.dados.$setPristine();
			$scope.message='';
			$scope.activity = null;
				
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAthletes = function() {
		$http.get('Athlete/findAthletes').success(function(res) {
			$scope.athletes = res;
			//$scope.dados.$setPristine();
			$scope.message='';
			$scope.activity = null;
				
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getPeoplesAgriculture = function() {
		$http.get('People/getPeopleFromAgriculture').success(function(res) {
			$scope.peoplesFromAgriculture = res;
			//$scope.dados.$setPristine();
			$scope.message='';
			$scope.people = null;
				
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getPeoplesSport = function() {
		$http.get('People/getPeopleFromSport').success(function(res) {
			$scope.peoplesFromSport = res;
			//$scope.dados.$setPristine();
			$scope.message='';
			$scope.people = null;
				
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	
	$scope.selectAttendance = function(attendance){
		$scope.clickedAttendance = attendance;
	}
	
	$scope.selectProducer = function(producer){
		$scope.clickedProducer = producer
	}
	
	$scope.selectPeople = function(people){
		console.log(people);
		$scope.clickedPeople = people;
	}
	
	$scope.selectAthlete = function(athlete){
		$scope.clickedAthlete = athlete;
	}
	
	getAttendanciesActive();
	getTotAttendanciesActive();
	getProducers();
	getActivities();
	getAttendanciesFinally();
	getTotAttendanciesFinally();
	getAttendanciesNot();
	getTotAttendanciesNot();
	getPeoplesAgriculture();
	getPeoplesSport();
	getAttendanciesHistoricFinally();
	getAthletes();
	getAttendanciesActiveSport();
	getAttendanciesFinallySport();
	getAttendanciesNotSport();
	getTotAttendanciesActiveSport();
	getTotAttendanciesFinallySport();
	getTotAttendanciesNotSport();
	getAttendanciesHistoricFinallySport();
	
	
});