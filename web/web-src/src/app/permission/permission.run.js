(function() {
    'use strict';

    angular
        .module('app.permission')
        .run(permissionRun);

    /* @ngInject */
    function permissionRun($rootScope, $cookies, $state, PermissionStore, RoleStore, PermissionService) {
        if(!$rootScope.authenticated) {
        	PermissionService.relogin();
        }


        // create roles for app


        ///////////////////////

        // default redirect if access is denied
        function accessDenied() {
            $state.go('401');
        }

        // watches

        // redirect all denied permissions to 401
        var deniedHandle = $rootScope.$on('$stateChangePermissionDenied', accessDenied);

        // remove watch on destroy
        $rootScope.$on('$destroy', function() {
            deniedHandle();
        });
    }
})();
