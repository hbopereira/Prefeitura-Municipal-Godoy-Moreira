angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('ActivityController', function($http, $scope, $state) {
	$scope.activity = {};
	$scope.pageSize="10";
	$scope.currentPage="1";
	
	$scope.saveActivity = function() {
		$http.post('Activity', $scope.activity).success(function(res) {
			$scope.activity = null;
			$scope.description = null;
			$scope.dados.$setPristine();
		    alert("Atividade Registrada com Sucesso !");
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
	
	$scope.updateActivity = function(){
		$http.put('Activity', $scope.clickedActivity).success(function(res) {
			$scope.producer = null;
			//$scope.wife_name = null;
			//$scope.dados.$setPristine();
			//$scope.message = "Editado com Sucesso";
			getActivities();
		}).error(function(error) {
			$scope.message =error.message;
		});
	}
	
	$scope.deleteActivity = function(activity) {
		$http.delete('Activity/drop/'+activity.id).success(function(res) {
			$scope.deleteMessage ="Success!";
			getActivities();
		}).error(function(error) {
			alert("Erro ao excluir este Registro !");
		});
	}
	
	$scope.selectActivity = function(activity){
		$scope.clickedActivity = activity;
	}
	
	getActivities();
	
});