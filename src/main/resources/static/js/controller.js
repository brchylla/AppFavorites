app.controller('appLinkController', ['$scope', '$http', '$window', function($scope, $http, $window) {
    // initialize table of open app links based on defaults or previous session
    initTable();

    // get all open app links from server to initialize table
    function initTable() {
        $scope.table = [[]];
        $http.get('/getOpenAppLinks')
        .success(function(data) {
            // expects array of all opened app links
            // use array to create matrix-like table
            createTable(data);
            // once table is created, update list of closed app links from server
            getClosedAppLinks();
        })
        .error(function() {
            console.log('Failure to initialize open app links for table');
        });
    }

    // function creates a matrix-like table using array passed into it
    // each element of the array will correspond to a cell of the table
    function createTable(items) {
        // the count of items
        var itemCount = items.length;
        // set number of rows in table to rounded integer of square root of item count
        var rowCount = Math.round(Math.sqrt(itemCount));
        // set number of columns in table to ceiling integer of item count divided by row count
        var colCount = Math.ceil(itemCount / rowCount);
        // allocate all rows in table based on column count
        for (var row = 0; row < rowCount; row++) {
            $scope.table[row] = Array(colCount);
        }
        // assign items to all table cells (using row count and column count)
        // i serves as the index of app links
        for (var i = 0; i < itemCount; i++) {
            // the index of the row
            var rowIndex = Math.floor(i / colCount);
            // the index of the column
            var colIndex = i % colCount;
            // assign app link with current index to table cell with current row & column indices
            $scope.table[rowIndex][colIndex] = items[i];
        }
        // BUG FIX: fill any undefined items in final row with blank links
        for (var j = 0; j < colCount; j++) {
            if (typeof $scope.table[rowCount-1][j] == 'undefined') {
                $scope.table[rowCount-1][j] = { name: 'Do Not Open' };
            }
        }
        console.log('table done');
    }

    // updates list of closed app links
    function getClosedAppLinks() {
        $http.get('/getClosedAppLinks')
        .success(function(data) {
            // expects array of all closed app links
            $scope.closedAppLinks = data;
        })
        .error(function() {
            console.log('Failed to get closed app links');
        });
    }

    // function for removing app link
    $scope.removeAppLink = function(name) {
        // update app links on server side by ordering link with given name to be closed
        $http.get('/removeAppLink?name=' + name)
        .success(function(data) {
            // expects app link of given name to be closed on server side
            // repopulate table after updating information
            initTable();
        })
        .error(function() {
            console.log('Failure to close ' + name + 'app link');
        });
    }

    // function for adding app link
    $scope.addAppLink = function(name) {
        // update app links on server side by ordering link with given name to be opened
        $http.get('/addAppLink?name=' + name)
        .success(function(data) {
            // expects app link of given name to be opened
            // repopulate table after updating information
            initTable();
        })
        .error(function() {
            console.log('Failure to open ' + name + 'app link');
        });
    }

}]);