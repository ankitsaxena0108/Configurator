(function() {
    'use strict';

    angular
        .module('app.permission')
        .config(permissionConfig);

    /* @ngInject */
    function permissionConfig($stateProvider, triMenuProvider) {
        $stateProvider
        .state('triangular.permission-define', {
            url: '/permission/define',
            templateUrl: 'app/permission/pages/permission-define.tmpl.html',
            data: {
                layout: {
                    contentClass: 'layout-column'
                }
            }
        })
        .state('triangular.permission-routes', {
            url: '/permission/routes',
            templateUrl: 'app/permission/pages/permission-routes.tmpl.html',
            data: {
                layout: {
                    contentClass: 'layout-column'
                }
            }
        })
        .state('triangular.permission-views', {
            url: '/permission/views',
            templateUrl: 'app/permission/pages/permission-views.tmpl.html',
            data: {
                layout: {
                    contentClass: 'layout-column'
                }
            }
        });
    }
})();
