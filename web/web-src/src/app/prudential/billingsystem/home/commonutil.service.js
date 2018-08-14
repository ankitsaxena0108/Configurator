(function() {
	'use strict';

	angular.module('app.prudential.billingsystem').factory('commonutilService',
			commonutilService);

	/* @ngInject */
	function commonutilService() {

		var factory = {
			set : set,
			get : get,
			remove : remove
		};

		var savedData = [];

		return factory;

		function set(moduleName, data) {

			var saveDataList = {
				'moduleName' : moduleName,
				'moduleData' : data
			};
			console.log("saveDataList---->",saveDataList);
			if(get(moduleName)){
				remove(moduleName);
				console.log("after removal saveDataList---->",saveDataList);
			}
			savedData.push(saveDataList);
			console.log("savedData---->",savedData);

		}

		function remove(moduleName) {
			for (var i = savedData.length - 1; i >= 0; i--) {
				if (savedData[i].moduleName == moduleName) {
					savedData.splice(i, 1);
				}
			}
		}

		function get(moduleName) {
			var data = {};
			for (var i = 0; i < savedData.length; i++) {

				if (savedData[i].moduleName === moduleName) {
					data = savedData[i].moduleData;
					break;
				}
			}

			return data;
		}

	}
})();
