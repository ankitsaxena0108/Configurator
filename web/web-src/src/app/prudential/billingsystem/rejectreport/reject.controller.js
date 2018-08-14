(function() {
	'use strict';

	angular.module('app.prudential.billingsystem').controller(
			'RejectController', RejectController);

	/* @ngInject */
	function RejectController($mdDialog, $mdToast, billingSystemService) {
		var vm = this;
		vm.reject = {};
		vm.pagination = {};
		vm.getRejectDetails=getRejectDetails;

		vm.searchRejectDetails = searchRejectDetails;

		function findRejectReportDetails() {
			var policyStartRange = vm.reject.policyStartRange ? vm.reject.policyStartRange : '',policyEndRange = vm.reject.policyEndRange ? vm.reject.policyEndRange : '',
					 fromDate = vm.reject.fromDate ? vm.reject.fromDate : '', toDate = vm.reject.toDate ? vm.reject.toDate	: '';

			if (policyStartRange.length > 0 || policyEndRange.length > 0
					|| fromDate.length > 0 || toDate.length > 0
					) {
				var rejectDetails = {
					params : {
						'policyStartRange' : policyStartRange,	
						'policyEndRange' : policyEndRange,
						'fromDate' : fromDate,
						'toDate' : toDate
					},
					'page' : vm.pagination.pageNumber,
					'size' : 10
				};

				billingSystemService.searchRejectDetails(rejectDetails).then(
						function(data) {
							
						
							vm.rejectSummaryDetails = data.content;
							vm.pagination.totalRecords = data.totalElements;
							vm.pagination.pageNumber = data.number + 1;
							vm.pagination.pageSize = data.size;
						});
			}
		}

		function searchRejectDetails() {
			vm.pagination.pageNumber = 1;
			findRejectReportDetails();
		}
		
		function getRejectDetails() {
			findRejectReportDetails();
		}

		
		

	}

})();