app.controller('appLinkController', ['$scope', '$http', '$window', function($scope, $http, $window) {
    /* initialize & clear scope arrays for app links */
    $scope.appLinks = [];
    /* initialize table of app links based on defaults or previous session */
    initTable();

    function initTable() {
        $http.get('/getAllAppLinks')
        .success(function(data) {
            // expects array of all app links in program
            $scope.appLinks = data;
        })
        .error(function() {
            console.log('Failure to initialize table of app links');
        });
    }

    /* function for removing app link */
    $scope.removeAppLink = function(name) {
        $http.get('/removeAppLink?name=' + name)
        .success(function(data) {
            // expects array of all app links... 
            // ...including app link of given name, which should now be closed
            $scope.appLinks = data;
        })
        .error(function() {
            console.log('Failure to close ' + name + 'app link');
        });
    }

    /* function for adding app link */
    $scope.addAppLink = function(name) {
        $http.get('/addAppLink?name=' + name)
        .success(function(data) {
            // expects array of all app links... 
            // ...including app link of given name, which should now be open
            $scope.appLinks = data;
        })
        .error(function() {
            console.log('Failure to open ' + name + 'app link');
        });
    }

}]);