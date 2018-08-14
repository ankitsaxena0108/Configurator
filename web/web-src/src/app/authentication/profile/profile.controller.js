(function() {
    'use strict';

    angular
        .module('app.authentication')
        .controller('ProfileController', ProfileController);

    /* @ngInject */
    function ProfileController(UserService) {
        var vm = this;
        vm.currentUser = PermissionService.getCurrentUser();

        vm.settingsGroups = [{
            name: 'Account Settings',
            settings: [{
                title: 'Show my location',
                icon: 'zmdi zmdi-pin',
                enabled: true
            },{
                title: 'Show my avatar',
                icon: 'zmdi zmdi-face',
                enabled: false
            }, {
                title: 'Show my username',
                icon: 'zmdi zmdi-account',
                enabled: true
            }]
        }];

        if (vm.currentUser.username === 'superit') {
            vm.user = {
                name: 'superit',
                email: 'superit@irdsoft.com',
                location: 'Bangalore, India',
                website: 'http://www.irdsoft.com',
                current: '',
                password: '',
                confirm: ''
            };
        }
        else {
            vm.user = {
                name: 'brad',
                email: 'brad@irdsoft.com',
                location: 'Bangalore, India',
                website: 'http://www.irdsoft.com',
                current: '',
                password: '',
                confirm: ''
            };
        }

    }
})();