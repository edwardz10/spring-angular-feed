var controllerModule = angular.module('usersAppControllers', []);

controllerModule.controller('UserController', function($scope, $http, $interval, UserService) {

    $scope.init = function () {
        console.log('AAA');
        $scope.buttonLabel = "Start feed";
        $scope.users = [];
    }

    feedUsersAtInterval = function() {
        UserService.getUsers().then(function(users){
            $scope.users = users;
        });
    }

    $scope.controlFeed = function() {
        if ($scope.buttonLabel === 'Start feed') {
            console.log('Start feed');
            UserService.startFeed();
            $scope.buttonLabel = 'Stop feed';

            $interval(callAtInterval, 2000);

        } else if ($scope.buttonLabel === 'Stop feed'){
            console.log('Stop feed');
            UserService.stopFeed();
            $scope.buttonLabel = 'Start feed';
        } else {
            console.log('Not implemented');
        }
    }

});
