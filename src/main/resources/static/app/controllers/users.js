angular.module('JWTDemoApp')
// Creating the Angular Controller
.controller('UsersController', function($http, $scope, AuthService) {
	//var edit = false;
	//$scope.buttonText = 'Salvar';
	$scope.pageSize = "5";
	$scope.currentPage = "1";
	$scope.addUser = function(){
		$http.post('api/users', $scope.appUser).success(function(res) {
			$scope.appUser = null;
			$scope.confirmPassword = null;
			$scope.userForm.$setPristine();
			alert("Usuario Salvo com Sucesso!");
			init();
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	var init = function() {
		$http.get('api/users').success(function(res) {
			$scope.users = res;
			$scope.message='';
			$scope.appUser = null;
			//$scope.buttonText = 'Salvar';
			
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	$scope.selectUser = function(appUser) {
		$scope.clickedUser = appUser;
	};
	$scope.deleteUser = function(appUser) {
		$http.delete('api/users/'+appUser.id).success(function(res) {
			$scope.deleteMessage ="Success!";
			init();
		}).error(function(error) {
			$scope.deleteMessage = error.message;
		});
	};
	 $scope.editUser = function(){
		$http.put('api/users', $scope.clickedUser).success(function(res) {
			$scope.appUser = null;
			$scope.confirmPassword = null;
			//$scope.message = "Editting Success";
			init();
		}).error(function(error) {
			$scope.message =error.message;
		});
	};
	var getTotUsers = function(){
		$http.get('api/tot').success(function(res) {
			$scope.tot = res;
			console.log($scope.tot);
			//$scope.dados.$setPristine();
			$scope.message='';		
		}).error(function(error) {
			$scope.message = error.message;
		});
	};
	init();
	getTotUsers(); 

});
