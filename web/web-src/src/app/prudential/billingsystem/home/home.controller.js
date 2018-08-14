(function() {
	'use strict';

	angular.module('app.prudential.billingsystem').controller('HomeController',
			HomeController);

	console.log("HomeController launched");

	/* @ngInject */
	 function HomeController($rootScope, triMenu, $http, PermissionService, homeService) {
        var vm = this;
        var CONTEXT_APPLICATION_MENU = 'menu/application';
        //var vm.errorCode=vm.errorCode;
    	//var vm.errorMsg=vm.errorMsg;
    	vm.clickCancel = homeService.clickCancel;
        console.log("Triggering Authenticate");
        PermissionService.authenticate();
        console.log("Fetching Application Menu");
        applicationMenus();

        function applicationMenus() {
            homeService.getFromServer(CONTEXT_APPLICATION_MENU).then(
                function (data) {
                    console.log("Got menus");
                    triMenu.removeAllMenu();
                    var menus = data;
                    
                    var triMenuArray = parseTriMenu(menus);
                    for (var i = 0; i < triMenuArray.length; i++) {
                        triMenu.addMenu(triMenuArray[i]);
                    }
                });
        };

        function parseTriMenu(menus) {
            var triMenu = {}, triMenuArray = [];

            for (var i = 0; i < menus.length; i++) {
                triMenu = {};

                triMenu['name'] = menus[i].name;
                triMenu['icon'] = menus[i].icon;
                triMenu['priority'] = menus[i].priority;
                triMenu['state'] = menus[i].target;
                triMenu['permission'] = menus[i].roles;

                if (menus[i].subMenu && menus[i].subMenu.length > 0) {
                    triMenu['type'] = 'dropdown';
                    triMenu['children'] = parseTriMenu(menus[i].subMenu);
                }
                else {
                    triMenu['type'] = 'link';
                }
                triMenuArray.push(triMenu);
            }

            return triMenuArray;
        }
    }
})();
