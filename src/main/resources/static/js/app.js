var app = angular.module('app', []);

app.factory('LoginService', function($rootScope) {
	// service definition
	return {
		GetAppLinks: function(login) {
			$rootScope.$broadcast('getAppLinks', {
                login: login
            });
		}
	}
});

/*app.run(function ($rootScope, $state, loginModal) {

	$rootScope.$on('$stateChangeStart', function (event, toState, toParams) {
	    var requireLogin = toState.data.requireLogin;

	    if (requireLogin && typeof $rootScope.currentUser === 'undefined') {
	      event.preventDefault();

	      loginModal()
	        .then(function () {
	          return $state.go(toState.name, toParams);
	        })
	        .catch(function () {
	          return $state.go('welcome');
	        });
	    }
	});

});

app.config(function ($httpProvider) {

	$httpProvider.interceptors.push(function ($timeout, $q, $injector) {
	    var loginModal, $http, $state;

	    // this trick must be done so that we don't receive
	    // `Uncaught Error: [$injector:cdep] Circular dependency found`
	    $timeout(function () {
	      loginModal = $injector.get('loginModal');
	      $http = $injector.get('$http');
	      $state = $injector.get('$state');
	    });

	    return {
	      responseError: function (rejection) {
	        if (rejection.status !== 401) {
	          return rejection;
	        }

	        var deferred = $q.defer();

	        loginModal()
	          .then(function () {
	            deferred.resolve( $http(rejection.config) );
	          })
	          .catch(function () {
	            $state.go('welcome');
	            deferred.reject(rejection);
	          });

	        return deferred.promise;
	      }
	    };
	  });

});*/
