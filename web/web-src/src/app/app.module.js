(function() {
    'use strict';

    angular
        .module('app', [
        	'ngMaterialDatePicker',
            'ui.router',
            'triangular',
            'ngAnimate', 'ngCookies', 'ngSanitize', 'ngMessages', 'ngMaterial',
            'googlechart', 'chart.js', 'linkify', 
            'ui.calendar', 
            'angularMoment', 
            'textAngular', 
            'uiGmapgoogle-maps', 
            'hljs', 
            'md.data.table', 
            angularDragula(angular), 
            'lfNgMdFileInput', 
            'nvd3',

            'app.translate',
            'app.authentication',
            'app.permission',

            // 'app.prudential.dashboard' 
            'app.prudential.billingsystem'
        ])

        // set a constant for the API we are connecting to
        .constant('API_CONFIG', {
            'URL':  '/billingsystem/dynamic/'
        });
})();
