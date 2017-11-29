var servicesModule = angular.module('usersAppServices', []);

servicesModule.service('UserService', function($http) {
    this.getUsers = function() {
        return $http.get('http://localhost:8080/spring-angular-feed-0.0.1-SNAPSHOT/api/users').then(function(response){
            return response.data;
        }).catch(function(err) {
            return [];
        });
    }

});