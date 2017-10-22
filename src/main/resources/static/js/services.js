(function() {
    angular.module('uigrid')
        .service('BusinessModelsService', ['$http', BusinessModelsService]);

    function BusinessModelsService($http) {
        var self = this;
        var baseUrl = 'http://localhost:8080/businessmodel';

        self.readAll = function () {
            return $http({
                method: 'GET',
                url: baseUrl
            }).then(function (response) {
                return response;
            });
        };

        self.create = function (param) {
            return $http({
                method: 'POST',
                url: baseUrl,
                data: data
            }).then(function (response) {
                return response;
            });
        };

        self.readOne = function (id) {
            return $http({
                method: 'GET',
                url: baseUrl + '/' + id
            }).then(function (response) {
                return response;
            });
        };

        self.update = function (id, data) {
            return $http({
                method: 'PUT',
                url: baseUrl + '/' + id,
                data: data
            }).then(function (response) {
                return response;
            });
        };

        self.delete = function (id) {
            return $http({
                method: 'DELETE',
                url: baseUrl + '/' + id
            });
        };
    }
})();