angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('OrderController', function($http, $scope, $state) {
	$scope.activity = {};
	$scope.pageSize="10";
	$scope.currentPage="1";
	
	$scope.saveOrder = function() {
		$http.post('Order', $scope.order).success(function(res) {
			$scope.order = null;
			//$scope.description = null;
			$scope.dados.$setPristine();
		    alert("Pedido Registrado com Sucesso !");
		}).error(function(error) {
			$scope.message = error.message;
			alert("Registro já Existente, por favor tente novamente !");
		});
	};
	
	$scope.updateOrder = function(){
		$http.put('Order/updateOrder', $scope.clickedOrder).success(function(res) {
			$scope.order = null;
			//$scope.wife_name = null;
			//$scope.dados.$setPristine();
			//$scope.message = "Editado com Sucesso";
			getOrders();
		}).error(function(error) {
			$scope.message =error.message;
		});
	}
	
	
	$scope.deleteOrder = function(order) {
		$http.delete('Order/drop/'+order.id).success(function(res) {
			$scope.deleteMessage ="Success!";
			getOrders();
		}).error(function(error) {
			alert("Erro ao excluir este Registro !");
		});
	}
	
	var getOrders = function() {
		$http.get('Order').success(function(res) {
			$scope.orders = res;
			//$scope.dados.$setPristine();
			$scope.message='';
			$scope.producer = null;
				
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getMachines = function() {
		$http.get('Machine').success(function(res) {
			$scope.machines = res;
			//$scope.dados.$setPristine();
			$scope.message='';
			$scope.producer = null;
				
		}).error(function(error) {
			$scope.message = error.message;
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
	
	var getTotOrdersOK = function(){
		$http.get('Order/totOrdersOK').success(function(res) {
			$scope.totOK = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotOrdersLib = function(){
		$http.get('Order/totOrdersLib').success(function(res) {
			$scope.totLib = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotOrdersPend = function(){
		$http.get('Order/totOrdersPend').success(function(res) {
			$scope.totPend = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	$scope.selectProducer = function(producer){
		$scope.clickedProducer = producer
	}
	
	$scope.selectOrder = function(order){
		$scope.clickedOrder = order
	}
	
	$scope.selectPeople = function(people){
		console.log(people);
		$scope.clickedPeople = people;
	}
	
	getProducers();
	getActivities();
	getPeoplesAgriculture();
	getOrders();
	getMachines();
	getTotOrdersOK();
	getTotOrdersLib();
	getTotOrdersPend();
})