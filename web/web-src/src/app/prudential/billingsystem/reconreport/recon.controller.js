(function() {
	'use strict';

	angular.module('app.prudential.billingsystem').controller(
			'ReconController', ReconController);

	/* @ngInject */
	function ReconController($mdDialog, $mdToast, billingSystemService) {
		var vm = this;
		vm.recon = {}, vm.audit = {};
		vm.pagination = {};
		vm.getReconDetails = getReconDetails;

		vm.searchReconDetails = searchReconDetails;	
		

		function findReconReportDetails() {
			var policyStartRange = vm.recon.policyStartRange ? vm.recon.policyStartRange : '',policyEndRange = vm.recon.policyEndRange ? vm.recon.policyEndRange : '',
					 fromDate = vm.recon.fromDate ? vm.recon.fromDate : '', toDate = vm.recon.toDate ? vm.recon.toDate	: '';

			if (policyStartRange.length > 0 || policyEndRange.length > 0
					|| fromDate.length > 0 || toDate.length > 0
					) {
				var reconDetails = {
					params : {
						'policyStartRange' : policyStartRange,	
						'policyEndRange' : policyEndRange,
						'fromDate' : fromDate,
						'toDate' : toDate
					},
					'page' : vm.pagination.pageNumber,
					'size' : 10
				};

				billingSystemService.searchReconDetails(reconDetails).then(
						function(data) {
							
						
							vm.reconSummaryDetails = data.content;
							vm.pagination.totalRecords = data.totalElements;
							vm.pagination.pageNumber = data.number + 1;
							vm.pagination.pageSize = data.size;
						});
			}
		}

		function searchReconDetails() {
			vm.pagination.pageNumber = 1;
			findReconReportDetails();
		}
		
		function getReconDetails() {
			findReconReportDetails();
		}

		
		

	}

})();