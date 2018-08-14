
(function() {
    'use strict';

    angular
        .module('app.prudential.billingsystem')
        .directive('errorMessage', errorMessage);


    /* @ngInject */
    function errorMessage() {
    	return {
    	    templateUrl: 'app/prudential/billingsystem/home/error.tmpl.html'
    	  };
    }
})();
