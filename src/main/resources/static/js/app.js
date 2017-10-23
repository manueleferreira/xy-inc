var app = angular.module('uigrid', ['ngTouch', 'ui.grid']);
app.controller('RunController', ['BusinessModelsService', '$scope',
    function (BusinessModelsService, $scope) {
        $scope.attributes = [{key: 'choice1'}];

        $scope.addNewChoice = function() {
            var newItemNo = $scope.attributes.length+1;
            $scope.attributes.push({'key' : 'choice'+newItemNo});
        };

        $scope.removeChoice = function() {
            var lastItem = $scope.attributes.length-1;
            $scope.attributes.splice(lastItem);
        };

        $scope.gridOptions = {
            excludeProperties: '__metadata',
            columnDefs: [{ field: 'id', displayName: 'ID', width: 50 },
                        { field: 'name', displayName: 'Name', width: 100 },
                        { field: 'attributes', displayName: 'Atributos', width: 350 }],
        };

        $scope.load = function () {
            BusinessModelsService.readAll().then(function (response) {
                $scope.gridOptions.data = response.data;
            });
        }

        $scope.addData = function() {
            $scope.form.attributes = $scope.attributes;
            BusinessModelsService.create($scope.form).then(function (response) {
                $scope.form = '';
                $scope.attributes = [{key: 'choice1'}];
                $scope.load();
            });
        };

        $scope.load();
}]);