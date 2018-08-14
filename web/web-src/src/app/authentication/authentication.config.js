(function() {
    'use strict';

    angular
        .module('app.authentication')
        .config(moduleConfig);

    /* @ngInject */
    function moduleConfig($stateProvider, triMenuProvider) {

        $stateProvider
        .state('authentication', {
            abstract: true,
            views: {
                'root': {
                    templateUrl: 'app/authentication/layouts/authentication.tmpl.html'
                }
            },
            data: {
                permissions: {
                    only: ['viewAuthentication']
                }
            }
        })
        .state('authentication.login', {
            url: '/login',
            templateUrl: 'app/authentication/login/login.tmpl.html',
            controller: 'LoginController',
            controllerAs: 'vm'
        })
        .state('triangular.profile', {
            url: '/profile',
            templateUrl: 'app/authentication/profile/profile.tmpl.html',
            controller: 'ProfileController',
            controllerAs: 'vm'
        });
    }
})();
