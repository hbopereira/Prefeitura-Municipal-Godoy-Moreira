angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('ProducerController', function($http, $scope, $state) {
	var edit = false;
	$scope.pageSize="10";
	$scope.currentPage="1";
	$scope.buttonText = 'Salvar';
	$scope.clickedProducer = {};
	$scope.selectedActivities = [];
//	$scope.elegido = {};
	
	$scope.saveProducer = function() {
		$http.post('Producer', $scope.producer).success(function(res) {
			$scope.producer = null;
			$scope.cpf = null;
			$scope.dados.$setPristine();
		    alert("Produtor Registrado com Sucesso !");
		}).error(function(error) {
			alert("Erro ao Salvar Produtor !")
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
	
	var getProducersWithAgriFamily = function() {
		$http.get('Producer/familyAgr').success(function(res) {
			$scope.producersFamily = res;
			//$scope.dados.$setPristine();
			$scope.message='';
			$scope.producer = null;
				
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getProducersNotAgriFamily = function() {
		$http.get('Producer/familyNotAgr').success(function(res) {
			$scope.producersNotAgriFamily = res;
			//$scope.dados.$setPristine();
			$scope.message='';
			$scope.producer = null;
				
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
        var getAllActivities = function() {
		$http.get('Activity/findActivities').success(function(res) {
			$scope.activities = res;
			$scope.dados.$setPristine();
			$scope.message='';
			$scope.activity = null;
				
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotProducers = function(){
		$http.get('Producer/tot').success(function(res) {
			$scope.tot = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotProducersWithAgriFamily = function(){
		$http.get('Producer/totProdFamily').success(function(res) {
			$scope.totProdFamily = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotProducersNotAgriFamily = function(){
		$http.get('Producer/totProdNotFamily').success(function(res) {
			$scope.totProdNotFamily = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotProducersExpiredDap = function(){
		$http.get('Producer/totProdExpiredDAP').success(function(res) {
			$scope.totProdExpiredDap = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotProducersAtiveDap = function(){
		$http.get('Producer/totProdAtiveDAP').success(function(res) {
			$scope.totProdAtiveDap = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotProducersCanceledDap = function(){
		$http.get('Producer/totProdCanceledDAP').success(function(res) {
			$scope.totProdCanceledDap = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotActFromProducer = function(){
		$http.get('Producer/totProdAct').success(function(res) {
			$scope.totProdAct = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	$scope.selectProducer = function(producer){
		console.log(producer);
		//edit = true;
		$scope.clickedProducer = producer;
	}
	
	$scope.updateProducer = function(){
		$http.put('Producer/updateProd', $scope.clickedProducer).success(function(res) {
			$scope.producer = null;
			//$scope.wife_name = null;
			//$scope.dados.$setPristine();
			//$scope.message = "Editado com Sucesso";
			getProducers();
		}).error(function(error) {
			$scope.message =error.message;
		});
	}
	
	$scope.deleteProducer = function(producer) {
		$http.delete('Producer/drop/'+producer.id).success(function(res) {
			$scope.deleteMessage ="Success!";
			getProducers();
		}).error(function(error) {
			alert("Erro ao excluir este Registro !");
		});
	}
	
	getProducers();
	getAllActivities();
	getTotProducers();
	getProducersWithAgriFamily();
	getProducersNotAgriFamily();
	getTotProducersWithAgriFamily();
	getTotProducersNotAgriFamily();
	getTotProducersExpiredDap();
	getTotProducersAtiveDap();
	getTotProducersCanceledDap();
	getTotActFromProducer();
	
});