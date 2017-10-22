var app = angular.module('uigrid', ['ngTouch', 'ui.grid']);
app.controller('RunController', ['BusinessModelsService', '$scope', function (BusinessModelsService, $scope) {
    $scope.gridOptions = {
        excludeProperties: '__metadata',
    };

    $scope.load = function () {
        BusinessModelsService.readAll().then(function (response) {
            $scope.gridOptions.data = response.data;
        });
    }

    $scope.addData = function() {
          BusinessModelsService.create($scope.name).then(function (response) {
              $scope.gridOptions.data = response.data;
              $scope.name = '';
          });
    };

    $scope.load();
}]);