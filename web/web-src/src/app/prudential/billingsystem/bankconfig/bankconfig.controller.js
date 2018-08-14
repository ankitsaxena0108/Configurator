(function() {
	'use strict';

	angular.module('app.prudential.billingsystem').controller('BankController',
			BankController);

	/* @ngInject */
	function BankController($scope,$mdDialog,$state, $mdToast, billingSystemService,
			commonutilService) {
		var vm = this;
		vm.bank = {};
		vm.clickOk = clickOk;
		vm.saveAdditionalInfo=saveAdditionalInfo;
		//vm.getBankOtherInfo=getBankOtherInfo;
		vm.configTable={};
		vm.inComputeDetTable = {};

		vm.inComputeHdrTable = {};

		vm.inComputeFtrTable = {};
		
		vm.outComputeDetTable = {};

		vm.outComputeHdrTable = {};

		vm.outComputeFtrTable = {};
		
		vm.outTable={};
		
		vm.bankschedule={};
		vm.additionalInfo={};
		vm.additionalInfo.otherConfig={};
		


		vm.mode = commonutilService.get("modeEdit");
		getBankConfigDetails();
		function getBankConfigDetails() {
			if (vm.mode == 'Edit') {
				var bn = commonutilService.get("selBankName");
				console.log("bank name" + bn);

				var bankDetails = commonutilService.get("bankconfig");
				var configTableRow = [];

				angular.forEach(bankDetails, function(bankDetail) {

					configTableRow = bankDetail.configTable.row;
					if (bn == configTableRow[0]) {

						vm.bank = bankDetail;
					}

				});

				vm.bank.bankName = bn;
				vm.configTable=vm.bank.configTable;
				vm.inComputeDetTable = vm.bank.inComputeDetTable;
				vm.inComputeHdrTable = vm.bank.inComputeHdrTable;
				vm.inComputeFtrTable = vm.bank.inComputeFtrTable;
				
				vm.outComputeDetTable = vm.bank.outComputeDetTable;
				vm.outComputeHdrTable = vm.bank.outComputeHdrTable;
				vm.outComputeFtrTable = vm.bank.outComputeFtrTable;
				vm.outTable=vm.bank.outTable;
				
				console.log("Going TO Edit record===========>>");
				vm.configTable=billingSystemService
				.getTableFormatDetails(vm.configTable);
				vm.inComputeDetTable=billingSystemService
				.getTableFormatDetails(vm.inComputeDetTable);
				vm.inComputeHdrTable =billingSystemService
				.getTableFormatDetails(vm.inComputeHdrTable);
				vm.inComputeFtrTable =billingSystemService
				.getTableFormatDetails(vm.inComputeFtrTable);
				
				vm.outComputeDetTable = billingSystemService
				.getTableFormatDetails(vm.outComputeDetTable);

				vm.outComputeHdrTable = billingSystemService
				.getTableFormatDetails(vm.outComputeHdrTable);

				vm.outComputeFtrTable = billingSystemService
				.getTableFormatDetails(vm.outComputeFtrTable);
				
				vm.outTable=billingSystemService
				.getTableFormatDetails(vm.outTable);
				
								
				 getBankSchedule();
				 getAdditionalInfo();

			}
		}

		
		$scope.getSelectedSchedule = function(){
			getBankSchedule();
		};
		
	
		
		function clickOk() {
			vm.bankschedule.name='';
			vm.bankschedule.name=commonutilService.get("selBankName");
			vm.bankschedule.category=commonutilService.get("category");
			
			
			billingSystemService.saveBankScheduleInfo(vm.bankschedule).then(function(data) {
						
				$mdToast.show($mdToast.simple().toastClass(
				'md-toast-done').content(
				'Detail Saved Successfully').position(
				'bottom right').hideDelay(2000));
						
				$state.go('triangular.dashboard');
							
				
					
			});
		
			
		}	
		
		function saveAdditionalInfo() {
			vm.additionalInfo.name='';
			vm.additionalInfo.name=commonutilService.get("selBankName");
			vm.additionalInfo.category=commonutilService.get("category");
			billingSystemService.saveBankOtherInfo(vm.additionalInfo).then(function(data) {
						
				$mdToast.show($mdToast.simple().toastClass(
				'md-toast-done').content(
				'Detail Saved Successfully').position(
				'bottom right').hideDelay(2000));
						
				$state.go('triangular.dashboard');
							
				
					
			});
		
			
		}	
		
		function getAdditionalInfo() {
			vm.bankschedule.name=commonutilService.get("selBankName");
			
			billingSystemService.getBankOtherInfo(vm.bankschedule).then(function(data) {
				
				vm.additionalInfo.otherConfig.incomingDetails = data.incomingDetails;
				vm.additionalInfo.otherConfig.outgoingDetails = data.outgoingDetails;
				console.log('vm.additionalInfo----------->', data);
	
			});
		
			
		}	
		
		
	function getBankSchedule(){	
		
		    vm.bankschedule.name=commonutilService.get("selBankName");
			vm.bankschedule.category=commonutilService.get("category");
			
			billingSystemService.getBankSchedule(vm.bankschedule).then(function(data) {
				console.log('vm.bankschedule----------->', data);
				vm.bankschedule.scheduleDetails = data;
				
				console.log('vm.bankschedule.scheduleDetails.recurrenceType.freqType----------->', vm.bankschedule.scheduleDetails.recurrenceType.freqType);
				
				if(vm.bankschedule.scheduleDetails.recurrenceType.freqType==='hourly')
					{
						vm.showHoulry=true;
						vm.showDaily=false;
						vm.showWeekly=false;
						vm.showMonthly=false;
					}
					else if (vm.bankschedule.scheduleDetails.recurrenceType.freqType==='daily')
					{
						vm.showHoulry=false;
						vm.showDaily=true;
						vm.showWeekly=false;
						vm.showMonthly=false;
					}
					else if (vm.bankschedule.scheduleDetails.recurrenceType.freqType==='weekly')
					{
						vm.showHoulry=false;
						vm.showDaily=false;
						vm.showWeekly=true;
						vm.showMonthly=false;
					}				
					else if (vm.bankschedule.scheduleDetails.recurrenceType.freqType==='monthly')
					{
						vm.showHoulry=false;
						vm.showDaily=false;
						vm.showWeekly=false;
						vm.showMonthly=true;
						if(vm.bankschedule.scheduleDetails.recurrenceType.monthly.monthlyFreType==='day')
						{
							vm.day=true;
							vm.theDay=false;
						}
						else // for theDay 
						{
							vm.day=false;
							vm.theDay=true;
						}
					}
				
			});
			
		}
		

		

	}

})();
