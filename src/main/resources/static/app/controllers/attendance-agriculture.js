angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('AttendanceAgricultureController', function($http, $scope, $state) {
	$scope.clickedProducer = {};
	$scope.clickedAttendance = {};
	$scope.pageSize="10";
	$scope.currentPage="1";
	//$scope.attendance = {};
	
	$scope.saveAttendance = function() {
		$http.post('AttendanceAgriculture', $scope.attendance).success(function(res) {
			$scope.attendance = null;
			$scope.description = null;
			$scope.dados.$setPristine();
		    alert("Atendimento Registrado com Sucesso !");
		}).error(function(error) {
			$scope.message = error.message;
			alert("Erro ao salvar Atendimento !")
		});
	};
	
	var getOrderStatusOK = function(){
		$http.get('Order/ordersOK').success(function(res) {
			$scope.orderStatusOK = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesActive = function(){
		$http.get('AttendanceAgriculture/getAttActive').success(function(res) {
			$scope.attendancies = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesAll = function(){
		$http.get('AttendanceAgriculture/getAttAll').success(function(res) {
			$scope.attendanciesAll = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesFinally = function(){
		$http.get('AttendanceAgriculture/getAttFinally').success(function(res) {
			$scope.attendanciesFinally = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	
	var getAttendanciesHistoricFinally = function(){
		$http.get('AttendanceAgriculture/getAttFinally').success(function(res) {
			$scope.attendanciesHistoricFinally = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAttendanciesNot = function(){
		$http.get('AttendanceAgriculture/getAttNot').success(function(res) {
			$scope.attendanciesNot = res;
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesActive = function(){
		$http.get('AttendanceAgriculture/totActive').success(function(res) {
			$scope.totActive = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesFinally = function(){
		$http.get('AttendanceAgriculture/totFinally').success(function(res) {
			$scope.totFinally = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAttendanciesNot = function(){
		$http.get('AttendanceAgriculture/totNot').success(function(res) {
			$scope.totNot = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	$scope.updateAttendance = function(){
		$http.put('AttendanceAgriculture', $scope.clickedAttendance).success(function(res) {
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
		$http.delete('AttendanceAgriculture/drop/'+attendance.id).success(function(res) {
			$scope.deleteMessage ="Success!";
			getAttendanciesFinally();
		}).error(function(error) {
			alert("Erro ao excluir este Registro !");
		});
	}
		
	$scope.selectAttendance = function(attendance){
		$scope.clickedAttendance = attendance;
	}
	
	$scope.selectOrder = function(order){
		$scope.clickedOrder = order
	}

	
	//$scope.selectAthlete = function(athlete){
	//	$scope.clickedAthlete = athlete;
	//}
	
	getAttendanciesActive();
	getTotAttendanciesActive();
	getAttendanciesFinally();
	getTotAttendanciesFinally();
	getAttendanciesNot();
	getTotAttendanciesNot();
	getAttendanciesHistoricFinally();
	getOrderStatusOK();
	getAttendanciesAll();
	
	
});