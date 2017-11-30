var controllerModule = angular.module('usersAppControllers', []);

controllerModule.controller('UserController', function($scope, $http, UserService) {

    $scope.init = function () {
        console.log('AAA');
    	$scope.buttonLabel = "Start feed";
        $scope.users = [];
    }    
    
    $scope.controlFeed = function() {
        if ($scope.buttonLabel === 'Start feed') {
    	    console.log('Start feed');
            UserService.startFeed();
            $scope.buttonLabel = 'Stop feed';
                
            UserService.getUsers().then(function(users){
                $scope.users = users;
            });

        } else if ($scope.buttonLabel === 'Stop feed'){
    	    console.log('Stop feed');
            UserService.stopFeed();
            $scope.buttonLabel = 'Start feed';
        } else {
            console.log('Not implemented');
        }
    }
    
});
