(function() {
    'use strict';

    angular
        .module('app')
        .config(translateConfig);

    /* @ngInject */
    function translateConfig(triSettingsProvider, triRouteProvider) {
        var now = new Date();
        // set app name & logo (used in loader, sidemenu, footer, login pages, etc)
        triSettingsProvider.setName('prudential');
        triSettingsProvider.setCopyright('&copy;' + now.getFullYear() + '  Prudential Billing System');
        triSettingsProvider.setLogo('assets/images/logo.png');
        // set current version of app (shown in footer)
        triSettingsProvider.setVersion('1.0');
        // set the document title that appears on the browser tab
        triSettingsProvider.setTitle('');// Removed the title value here. it gets displayed at bottom left of the card
        triRouteProvider.setTitle('Billing System');
        triRouteProvider.setSeparator('|');
    }
})();
