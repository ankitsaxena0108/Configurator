(function() {
    'use strict';

    angular
        .module('app.authentication')
        .controller('LoginController', LoginController);

    /* @ngInject */
    function LoginController($state, $http, $rootScope, triSettings, PermissionService) {
        var vm = this,
            self = this;
        vm.loginClick = loginClick;
        vm.triSettings = triSettings;

        // create blank user variable for login form
        vm.user = {
//            username: 'superit',
//            password: 'superit'
        };

        ////////////////



        // UserService.authenticate();

        function loginClick() {
        		PermissionService.authenticate(self.user, function() {
                if ($rootScope.authenticated) {
                    // $location.path("/home");
                    self.error = true;

                    $rootScope.$emit('rootScope:loggedIn', self.user.username);
                    console.log("rootScope:loggedIn emitting: ");console.log(self.user.username);
                    $state.go('triangular.home');
                } else {
                    // $location.path("/login");
                    self.error = {valid : true};
                    $state.go('authentication.login');
                    //$state.go('triangular.home');
                }
            });
        }
    }
})();
