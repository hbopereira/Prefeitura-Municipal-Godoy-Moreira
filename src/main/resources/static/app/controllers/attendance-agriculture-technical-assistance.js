angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('AttendanceAgricultureTechnicalController', function($http, $scope, $state) {
	$scope.clickedProducer = {};
	$scope.clickedAttendance = {};
	$scope.pageSize="10";
	$scope.currentPage="1";
	//$scope.attendance = {};
	
	$scope.saveAttendance = function() {
		$http.post('AttendanceAgricultureTechnical', $scope.attendance).success(function(res) {
			$scope.attendance = null;
			$scope.description = null;
			$scope.dados.$setPristine();
		    alert("Atendimento Registrado com Sucesso !");
		}).error(function(error) {
			$scope.message = error.message;
			alert("Erro ao salvar Atendimento !")
		});
	};
	
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
	
	var getAttendanciesActive = function(){
		$http.get('AttendanceAgricultureTechnical/getAttActive').success(function(res) {
			$scope.attendancies = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesAll = function(){
		$http.get('AttendanceAgricultureTechnical/getAttAll').success(function(res) {
			$scope.attendanciesAll = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesFinally = function(){
		$http.get('AttendanceAgricultureTechnical/getAttFinally').success(function(res) {
			$scope.attendanciesFinally = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	
	var getAttendanciesHistoricFinally = function(){
		$http.get('AttendanceAgricultureTechnical/getAttFinally').success(function(res) {
			$scope.attendanciesHistoricFinally = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesNot = function(){
		$http.get('AttendanceAgricultureTechnical/getAttNot').success(function(res) {
			$scope.attendanciesNot = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesActive = function(){
		$http.get('AttendanceAgricultureTechnical/totActive').success(function(res) {
			$scope.totActive = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesFinally = function(){
		$http.get('AttendanceAgricultureTechnical/totFinally').success(function(res) {
			$scope.totFinally = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesNot = function(){
		$http.get('AttendanceAgricultureTechnical/totNot').success(function(res) {
			$scope.totNot = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	$scope.updateAttendance = function(){
		$http.put('AttendanceAgricultureTechnical', $scope.clickedAttendance).success(function(res) {
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
		$http.delete('AttendanceAgricultureTechnical/drop/'+attendance.id).success(function(res) {
			$scope.deleteMessage ="Success!";
			getAttendanciesFinally();
		}).error(function(error) {
			alert("Erro ao excluir este Registro !");
		});
	}
		
	$scope.selectAttendance = function(attendance){
		$scope.clickedAttendance = attendance;
	}
	
	getPeoplesAgriculture();
	getProducers();
	getAttendanciesActive();
	getTotAttendanciesActive();
	getAttendanciesFinally();
	getTotAttendanciesFinally();
	getAttendanciesNot();
	getTotAttendanciesNot();
	getAttendanciesHistoricFinally();
	getAttendanciesAll();
})