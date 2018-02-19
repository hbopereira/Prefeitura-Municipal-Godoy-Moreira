angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('MachineController', function($http, $scope, $state) {
	$scope.activity = {};
	$scope.pageSize="10";
	$scope.currentPage="1";
	
	$scope.saveMachine = function() {
		$http.post('Machine', $scope.machine).success(function(res) {
			$scope.machine = null;
			//$scope.description = null;
			$scope.dados.$setPristine();
		    alert("Maquinario Registrado com Sucesso !");
		}).error(function(error) {
			$scope.message = error.message;
			alert("Erro ao salvar Maquinario !")
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
	
	getMachines();
})