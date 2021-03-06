angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('PeopleController', function($http, $scope, $state) {
	$scope.pageSize="10";
	$scope.currentPage="1";
	
	$scope.savePeople = function() {
		$http.post('People', $scope.people).success(function(res) {
			$scope.people = null;
			$scope.cpf = null;
			$scope.dados.$setPristine();
		    alert("Pessoa Registrada com Sucesso !");
		}).error(function(error) {
			alert("Registro já Existente, por favor tente novamente !");
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
	
	
	
	$scope.selectPeople = function(people){
		console.log(people);
		$scope.clickedPeople = people;
	}
	
	getPeoplesSport();
	getPeoplesAgriculture();
	
})