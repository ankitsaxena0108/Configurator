(function() {
	'use strict';

	angular.module('app.prudential.billingsystem').factory('coreService', coreService);

	/* @ngInject */
	function coreService(homeService) {
		var CORE_COUNTRY = 'country'

		var factory = {
			getCountries : getCountries
		};

		return factory;

		function getCountries() {
			return homeService.getFromServer(CORE_COUNTRY);
		}

	}
})();