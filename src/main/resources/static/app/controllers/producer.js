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
			alert("Registro já Existente, por favor tente novamente !");
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
	
	var getTotActFromProducer1 = function(){
		$http.get('Producer/totProdAct1').success(function(res) {
			$scope.totProdAct1 = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	
	var getTotActFromProducer2 = function(){
		$http.get('Producer/totProdAct2').success(function(res) {
			$scope.totProdAct2 = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotActFromProducer3 = function(){
		$http.get('Producer/totProdAct3').success(function(res) {
			$scope.totProdAct3 = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotActFromProducer4 = function(){
		$http.get('Producer/totProdAct4').success(function(res) {
			$scope.totProdAct4 = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotActFromProducer5 = function(){
		$http.get('Producer/totProdAct5').success(function(res) {
			$scope.totProdAct5 = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotActFromProducer6 = function(){
		$http.get('Producer/totProdAct6').success(function(res) {
			$scope.totProdAct6 = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	
	
	
	
	getProducers();
	getAllActivities();
	getProducersWithAgriFamily();
	getProducersNotAgriFamily();
	getTotProducersWithAgriFamily();
	getTotProducersNotAgriFamily();
	getTotProducersExpiredDap();
	getTotProducersAtiveDap();
	getTotProducersCanceledDap();
	getTotActFromProducer1();
	getTotActFromProducer2();
	getTotActFromProducer3();
	getTotActFromProducer4();
	getTotActFromProducer5();
	getTotActFromProducer6();
	
});