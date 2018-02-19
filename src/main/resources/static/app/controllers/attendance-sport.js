angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('AttendanceSportController', function($http, $scope, $state) {
	//$scope.clickedProducer = {};
	$scope.clickedAttendance = {};
	$scope.pageSize="10";
	$scope.currentPage="1";
	//$scope.attendance = {};
	
	$scope.saveAttendance = function() {
		$http.post('AttendanceSport', $scope.attendance).success(function(res) {
			$scope.attendance = null;
			$scope.description = null;
			$scope.dados.$setPristine();
		    alert("Atendimento Registrado com Sucesso !");
		}).error(function(error) {
			$scope.message = error.message;
			alert("Erro ao salvar Atendimento !")
		});
	};
	
	var getAttendanciesAll = function(){
		$http.get('AttendanceSport/getAttAll').success(function(res) {
			$scope.attendanciesAll = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesActiveSport = function(){
		$http.get('AttendanceSport/getAttActiveSport').success(function(res) {
			$scope.attendanciesProgress = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesFinallySport = function(){
		$http.get('AttendanceSport/getAttFinallySport').success(function(res) {
			$scope.attendanciesFinallySport = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesHistoricFinallySport = function(){
		$http.get('AttendanceSport/getAttFinallySport').success(function(res) {
			$scope.attendanciesHistoricFinallySport = res;
			$scope.dados.$setPristine();
			$scope.message='';		
	    }).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesNotSport = function(){
		$http.get('AttendanceSport/getAttNotSport').success(function(res) {
			$scope.attendanciesNotSport = res;
			$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesActiveSport = function(){
		$http.get('AttendanceSport/totActiveSport').success(function(res) {
			$scope.totActiveSport = res;
			console.log($scope.tot);
			$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesFinallySport = function(){
		$http.get('AttendanceSport/totFinallySport').success(function(res) {
			$scope.totFinallySport = res;
			console.log($scope.tot);
			$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesNotSport = function(){
		$http.get('AttendanceSport/totNotSport').success(function(res) {
			$scope.totNotSport = res;
			console.log($scope.tot);
			$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	$scope.updateAttendance = function(){
		$http.put('AttendanceSport', $scope.clickedAttendance).success(function(res) {
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
	
	$scope.deleteAttendanceSport = function(attendance) {
		$http.delete('AttendanceSport/drop/'+attendance.id).success(function(res) {
			$scope.deleteMessage ="Success!";
			getAttendanciesFinallySport();
		}).error(function(error) {
			alert("Erro ao excluir este Registro !");
		});
	}
	
	var getAthletes = function() {
		$http.get('Athlete/findAthletes').success(function(res) {
			$scope.athletes = res;
			$scope.dados.$setPristine();
			$scope.message='';
			$scope.activity = null;
				
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getPeoplesSport = function() {
		$http.get('People/getPeopleFromSport').success(function(res) {
			$scope.peoplesFromSport = res;
			$scope.dados.$setPristine();
			$scope.message='';
			$scope.people = null;
				
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	$scope.selectAttendance = function(attendance){
		$scope.clickedAttendance = attendance;
	}
	
	$scope.selectPeople = function(people){
		console.log(people);
		$scope.clickedPeople = people;
	}
	
	$scope.selectAthlete = function(athlete){
		$scope.clickedAthlete = athlete;
	}
	
	
	
	getPeoplesSport();
	getAthletes();
	getAttendanciesActiveSport();
	getAttendanciesFinallySport();
	getAttendanciesNotSport();
	getTotAttendanciesActiveSport();
	getTotAttendanciesFinallySport();
	getTotAttendanciesNotSport();
	getAttendanciesHistoricFinallySport();
	getAttendanciesAll();
	
});