var app = angular.module('app', ['ngDragDrop']);



app.factory('LoginService', function($rootScope) {

	// service definition

	return {

		GetAppLinks: function(login, password) {

			$rootScope.$broadcast('getAppLinks', {

                login: login,

                password: password

            });

		}

	}

});