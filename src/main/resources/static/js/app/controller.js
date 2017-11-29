var controllerModule = angular.module('usersAppControllers', []);

controllerModule.controller('UserController', function($scope, $http, UserService) {

    UserService.getUsers().then(function(users){
        $scope.users = users;
    });

    $scope.init = function () {
        console.log('AAA');
    	$scope.buttonLabel = "Start feed";
        $scope.users = [];
    }    
    
    $scope.controlFeed = function() {
        if ($scope.buttonLabel === 'Start feed') {
    	    console.log('Start feed');
            $scope.buttonLabel = 'Stop feed';
        } else if ($scope.buttonLabel === 'Stop feed'){
    	    console.log('Stop feed');
            $scope.buttonLabel = 'Start feed';
        } else {
            console.log('Not implemented');
        }
    }
    
});
