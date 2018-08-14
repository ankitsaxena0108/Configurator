(function() {
    'use strict';

    angular
        .module('app.prudential.billingsystem')
        .config(moduleConfig);

    /* @ngInject */
    function moduleConfig($stateProvider, triMenuProvider) {
        $stateProvider
            .state('triangular.dashboard', {
                url: '/billingsystem/dashboard',
                templateUrl: 'app/prudential/billingsystem/dashboard/dashboard.tmpl.html',
                // set the controller to load for this page
                controller: 'DashboardController',
                controllerAs: 'vm',
                // layout-column class added to make footer move to
                // bottom of the page on short pages
                data: {
                    layout: {
                        contentClass: 'layout-column'
                    }
                }
            })

        $stateProvider
            .state('triangular.auditenquiry', {
                url: '/billingsystem/audit',
                templateUrl: 'app/prudential/billingsystem/audit/audit.tmpl.html',
                // set the controller to load for this page
                controller: 'AuditController',
                controllerAs: 'vm',
                // layout-column class added to make footer move to
                // bottom of the page on short pages
                data: {
                    layout: {
                        contentClass: 'layout-column'
                    }
                }
            })
             $stateProvider
            .state('triangular.sourceSystem', {
                url: '/billingsystem/sourcesystem',
                templateUrl: 'app/prudential/billingsystem/sourcesystem/sourcesystem.tmpl.html',
                // set the controller to load for this page
                controller: 'SourceSystemController',
                controllerAs: 'vm',
                // layout-column class added to make footer move to
                // bottom of the page on short pages
                data: {
                    layout: {
                        contentClass: 'layout-column'
                    }
                }
            })
             $stateProvider
            .state('triangular.editSourceSystem', {
                url: '/billingsystem/sourcesystem',
                templateUrl: 'app/prudential/billingsystem/sourcesystem/sourcesystem.tmpl.html',
                // set the controller to load for this page
                controller: 'SourceSystemController',
                controllerAs: 'vm',
                //mode: 'Edit',                
                readOnly: true,
                pageTitle: 'Delete Source System Configuration',
               // layout-column class added to make footer move to
                // bottom of the page on short pages
                data: {
                    layout: {
                        contentClass: 'layout-column'
                    }
                }
            }) 
             $stateProvider
            .state('triangular.deleteSourceSystem', {
                url: '/billingsystem/sourcesystem',
                templateUrl: 'app/prudential/billingsystem/sourcesystem/sourcesystem.tmpl.html',
                // set the controller to load for this page
                controller: 'SourceSystemController',
                controllerAs: 'vm',
                //mode: 'Delete',                
                readOnly: true,
                pageTitle: 'Delete Source System Configuration',
               // layout-column class added to make footer move to
                // bottom of the page on short pages
                data: {
                    layout: {
                        contentClass: 'layout-column'
                    }
                }
            }) 
             $stateProvider
            .state('triangular.bankConfigSystem', {
                url: '/billingsystem/bankconfig',
                templateUrl: 'app/prudential/billingsystem/bankconfig/bank.tmpl.html',
                // set the controller to load for this page
                controller: 'BankController',
                controllerAs: 'vm',
                // layout-column class added to make footer move to
                // bottom of the page on short pages
                data: {
                    layout: {
                        contentClass: 'layout-column'
                    }
                }
            })
             $stateProvider
            .state('triangular.editBankSystem', {
                url: '/billingsystem/bankconfig',
                templateUrl: 'app/prudential/billingsystem/bankconfig/bank.tmpl.html',
                // set the controller to load for this page
                controller: 'BankController',
                controllerAs: 'vm',
                //mode: 'Edit',                
                readOnly: true,
                pageTitle: 'Edit Bank System Configuration',
               // layout-column class added to make footer move to
                // bottom of the page on short pages
                data: {
                    layout: {
                        contentClass: 'layout-column'
                    }
                }
            }) ;
        
        
        $stateProvider
        .state('triangular.reconreport', {
            url: '/billingsystem/reconreport',
            templateUrl: 'app/prudential/billingsystem/reconreport/recon.tmpl.html',
            // set the controller to load for this page
            controller: 'ReconController',
            controllerAs: 'vm',
            // layout-column class added to make footer move to
            // bottom of the page on short pages
            data: {
                layout: {
                    contentClass: 'layout-column'
                }
            }
        })
        
        $stateProvider
        .state('triangular.rejectreport', {
            url: '/billingsystem/rejectreport',
            templateUrl: 'app/prudential/billingsystem/rejectreport/reject.tmpl.html',
            // set the controller to load for this page
            controller: 'RejectController',
            controllerAs: 'vm',
            // layout-column class added to make footer move to
            // bottom of the page on short pages
            data: {
                layout: {
                    contentClass: 'layout-column'
                }
            }
        })
        
         $stateProvider
        .state('triangular.adhocprocess', {
            url: '/billingsystem/adhocprocess',
            templateUrl: 'app/prudential/billingsystem/adhocprocess/adhoc.tmpl.html',
            // set the controller to load for this page
            controller: 'AdhocProcessController',
            controllerAs: 'vm',
            // layout-column class added to make footer move to
            // bottom of the page on short pages
            data: {
                layout: {
                    contentClass: 'layout-column'
                }
            }
        })
        
    }
})();
