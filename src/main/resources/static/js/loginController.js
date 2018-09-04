app.controller('loginController', ['$scope', '$http', '$window', 'LoginService', function($scope, $http, $window, LoginService) {
	// initializes by logging in to default user
	beginLoginAttempt('default', 'glbrcpass');
	
	$scope.attemptLogin = function() {
		var login = $scope.loginInput;
		var password = $scope.passwordInput;
		beginLoginAttempt(login, password);
	}
	
	function beginLoginAttempt(login, password) {
		$http.get('/getUser?login=' + login)
		.success(function(data) {
			// expects to return user object with password
			var user = data;
			if (user != null) {
				if (password == user.password) {
					LoginService.GetAppLinks(login);
				}
				else {
					alert('Wrong password');
				}
			}
		})
		.error(function() {
			alert('Login failed');
		});
	}
}]);