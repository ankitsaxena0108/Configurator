(function() {
	'use strict';

	angular.module('app.prudential.billingsystem').controller(
			'SourceSystemController', SourceSystemController);
	

	/* @ngInject */
	function SourceSystemController($scope, $state , $mdDialog, $mdToast,
			billingSystemService , commonutilService) {
		
		var vm = this;
		vm.source = {};
		vm.clickOk = clickOk;
		vm.configTable={};
		vm.inComputeDetTable = {};

		vm.inComputeHdrTable = {};

		vm.inComputeFtrTable = {};
		
		vm.outComputeDetTable = {};

		vm.outComputeHdrTable = {};

		vm.outComputeFtrTable = {};
		
		vm.outTable={};
		vm.sourcesystem={};
		
		
		var name='';
		
		
		vm.mode = commonutilService.get("modeEdit");
		getSourceConfigDetails();
		function getSourceConfigDetails() {
			if (vm.mode == 'Edit') {
				var bn = commonutilService.get("selSourceName");
				console.log("Source name" + bn);

				var sourceDetails = commonutilService.get("sourceconfig");
				var configTableRow = [];

				angular.forEach(sourceDetails, function(sourceDetail) {

					configTableRow = sourceDetail.configTable.row;
					if (bn == configTableRow[0]) {

						vm.source = sourceDetail;
					}

				});

				vm.source.sourceName = bn;
				vm.configTable=vm.source.configTable;
				vm.inComputeDetTable = vm.source.inComputeDetTable;
				vm.inComputeHdrTable = vm.source.inComputeHdrTable;
				vm.inComputeFtrTable = vm.source.inComputeFtrTable;
				
				vm.outComputeDetTable = vm.source.outComputeDetTable;
				vm.outComputeHdrTable = vm.source.outComputeHdrTable;
				vm.outComputeFtrTable = vm.source.outComputeFtrTable;
				vm.outTable=vm.source.outTable;
				
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
				
				//vm.sourcesystem.recurrenceType.push(billingSystemService.getSourceSystemSchedule());
				
				//console.log('recurrenceType----->',billingSystemService.getSourceSystemSchedule().promise);
				
				//getSourceSystemSchedule();
				

			}
		}
		
		$scope.getSelectedSchedule = function(){
			getSourceSystemSchedule();
		};
		
		
	
		function clickOk() {			
						
			vm.sourcesystem.name='';
			vm.sourcesystem.name=commonutilService.get("selSourceName");
			vm.sourcesystem.category=commonutilService.get("category");
			billingSystemService.saveScheduleInfo(vm.sourcesystem).then(function(data) {
				
				$mdToast.show($mdToast.simple().toastClass(
				'md-toast-done').content(
				'Detail Saved Successfully').position(
				'bottom right').hideDelay(2000));
						
					$state.go('triangular.dashboard');
					
			});
		
			
		}
		
		function getSourceSystemSchedule(){						
			//vm.sourcesystem.name=commonutilService.get("selSourceName");
			console.log('vm.sourcesystem while reading ----->',vm.sourcesystem);
			vm.sourcesystem.name=commonutilService.get("selSourceName");
			
			billingSystemService.getSourceSystemSchedule(vm.sourcesystem).then(function(data) {
				console.log('vm.sourcesystem----------->', data);
				//vm.sourcesystem = data;
				vm.sourcesystem.scheduleDetails=data;
				console.log('vm.sourcesystem.scheduleDetails.recurrenceType.freqType----------->', vm.sourcesystem.scheduleDetails.recurrenceType.freqType);
				
				if(vm.sourcesystem.scheduleDetails.recurrenceType.freqType==='hourly')
					{
						vm.showHoulry=true;
						vm.showDaily=false;
						vm.showWeekly=false;
						vm.showMonthly=false;
					}
					else if (vm.sourcesystem.scheduleDetails.recurrenceType.freqType==='daily')
					{
						vm.showHoulry=false;
						vm.showDaily=true;
						vm.showWeekly=false;
						vm.showMonthly=false;
					}
					else if (vm.sourcesystem.scheduleDetails.recurrenceType.freqType==='weekly')
					{
						vm.showHoulry=false;
						vm.showDaily=false;
						vm.showWeekly=true;
						vm.showMonthly=false;
					}				
					else if (vm.sourcesystem.scheduleDetails.recurrenceType.freqType==='monthly')
					{
						vm.showHoulry=false;
						vm.showDaily=false;
						vm.showWeekly=false;
						vm.showMonthly=true;
						if(vm.sourcesystem.scheduleDetails.recurrenceType.monthly.monthlyFreType==='day')
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
