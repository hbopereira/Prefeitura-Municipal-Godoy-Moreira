angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('AthleteController', function($http, $scope, $state) {
	$scope.pageSize="10";
	$scope.currentPage="1";
	
	$scope.saveAthlete = function() {
		$http.post('Athlete', $scope.athlete).success(function(res) {
			$scope.athlete = null;
			$scope.name = null;
			$scope.dados.$setPristine();
		    alert("Atleta Registrado com Sucesso !");
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getAthletes = function() {
		$http.get('Athlete/findAthletes').success(function(res) {
			$scope.athletes = res;
			//$scope.dados.$setPristine();
			$scope.message='';
			$scope.athlete = null;
				
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	var getTotAthletes = function(){
		$http.get('Athlete/tot').success(function(res) {
			$scope.tot = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	
	$scope.updateAthlete = function(){
		$http.put('Athlete', $scope.clickedAthlete).success(function(res) {
			$scope.athlete = null;
			//$scope.wife_name = null;
			//$scope.dados.$setPristine();
			//$scope.message = "Editado com Sucesso";
			getAthletes();
		}).error(function(error) {
			$scope.message =error.message;
		});
	}
	
	$scope.deleteAthlete = function(athlete) {
		$http.delete('Athlete/drop/'+athlete.id).success(function(res) {
			$scope.deleteMessage ="Success!";
			getAthletes();
		}).error(function(error) {
			alert("Erro ao excluir este Registro !");
		});
	}
	
	$scope.selectAthlete = function(athlete){
		$scope.clickedAthlete = athlete;
	}
	
	$scope.selectAthlete
	
	getAthletes();
	getTotAthletes();
	
});