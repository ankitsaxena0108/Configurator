(function() {
	'use strict';

	angular.module('app.prudential.billingsystem').controller(
			'AuditController', AuditController)
			.controller('AuditDetailController', AuditDetailController);

	/* @ngInject */
	function AuditController($mdDialog, $mdToast, billingSystemService) {
		var vm = this;
		vm.fileAudit = {}, vm.audit = {};
		vm.pagination = {};

		vm.searchAudit = searchAudit;
		vm.getFileAudit = getFileAudit;
		vm.viewFileAuditDetails =  viewFileAuditDetails;

		function findAuditDetails() {
			var name = vm.audit.name ? vm.audit.name : '', fileDirection = vm.audit.fileDirection ? vm.audit.fileDirection
					: '', category = vm.audit.category ? vm.audit.category : '', status = vm.audit.status ? vm.audit.status
					: '', paymentType = vm.audit.paymentType ? vm.audit.paymentType
					: '', fromDate = vm.audit.fromDate ? vm.audit.fromDate : '', toDate = vm.audit.toDate ? vm.audit.toDate
					: '';

			if (name.length > 0 || fileDirection.length > 0
					|| category.length > 0 || paymentType.length > 0
					|| status.length > 0) {
				var fileAudit = {
					params : {
						'name' : name,
						'fileDirection' : fileDirection,
						'category' : category,
						'status' : status,
						'paymentType' : paymentType,
						'fromDate' : fromDate,
						'toDate' : toDate
					},
					'page' : vm.pagination.pageNumber,
					'size' : 10
				};

				billingSystemService.searchFileAudit(fileAudit).then(
						function(data) {
							
							/*for(var i=0; i<data.content.length ; i++ ){
								var startDate = new Date(data.content[i].startDateTime);
								data.content[i].startDateTime=startDate;
								var endDate = new Date(data.content[i].endDateTime)
								data.content[i].endDateTime=endDate;
							}*/
							vm.auditSummaryDetails = data.content;
							vm.pagination.totalRecords = data.totalElements;
							vm.pagination.pageNumber = data.number + 1;
							vm.pagination.pageSize = data.size;
						});
			}
		}

		function searchAudit() {
			vm.pagination.pageNumber = 1;
			findAuditDetails();
		}

		function getFileAudit() {
			findAuditDetails();
		}
		function viewFileAuditDetails(detail) {
			
			var fileAuditDetails = [];
        	if (vm.auditSummaryDetails) {
        		for (var i = 0; i < vm.auditSummaryDetails.length; i++) {
        			if(vm.auditSummaryDetails[i].systemId==detail.systemId){
        				fileAuditDetails=vm.auditSummaryDetails[i].auditDetails;
        			}
        			
        		}
        	}

			$mdDialog
					.show({
						controller : 'AuditDetailController',
						controllerAs : 'vm',
						templateUrl : 'app/prudential/billingsystem/audit/auditdetail.tmpl.html',
						locals : {
							mode : 'View',
							readOnly : true,
							pageTitle : 'File Audit Details',
							fileAuditDetails:fileAuditDetails
						},
						bindToController : true,
						preserveScope : true
					}).then(function() {
						console.log('AuditetailController Mode  Dialog window');
				    });
		}

	}
	
	function AuditDetailController($mdDialog, billingSystemService, homeService) {
		var vm = this;
		vm.clickCancel = homeService.clickCancel;
		console.log('AuditetailController Mode  Dialog window');
		
	}
})();