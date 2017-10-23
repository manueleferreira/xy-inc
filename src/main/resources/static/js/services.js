(function() {
    angular.module('uigrid')
        .service('BusinessModelsService', ['$http', BusinessModelsService]);

    function BusinessModelsService($http) {
        var self = this;
        var baseUrl = 'http://localhost:8080/businessdomain';

        self.readAll = function () {
            return $http({
                method: 'GET',
                url: baseUrl,
                headers: {
                    'Content-Type': 'application/json; charset=utf-8'
                }
            }).then(function (response) {
                return response;
            });
        };

        self.create = function (param) {
            return $http({
                method: 'POST',
                url: baseUrl,
                headers: {
                    'Content-Type': 'application/json; charset=utf-8'
                },
                data: angular.toJson(param)
            }).then(function (response) {
                return response;
            });
        };

        self.delete = function (id) {
            return $http({
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json; charset=utf-8'
                },
                url: baseUrl + '/' + id
            });
        };
    }
})();