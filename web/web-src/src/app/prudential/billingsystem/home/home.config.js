(function() {
    'use strict';

    angular
        .module('app.prudential.billingsystem')
        .config(moduleConfig);

    /* @ngInject */
    function moduleConfig($stateProvider) {

        $stateProvider
        .state('triangular.home', {
            url: '/home',
            templateUrl: 'app/prudential/billingsystem/home/home.tmpl.html',
            controller: 'HomeController',
            controllerAs: 'hm',
        });
    }
})();
