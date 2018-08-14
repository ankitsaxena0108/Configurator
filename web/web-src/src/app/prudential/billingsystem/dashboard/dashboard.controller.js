(function() {
	'use strict';

	angular.module('app.prudential.billingsystem').controller(
			'DashboardController', DashboardController);

	console.log("DashboardController launched");

	/* @ngInject */
	function DashboardController($scope, $mdDialog, $mdToast, homeService,
			$state, billingSystemService, commonutilService) {
		var vm = this;
		var systemDetails = {};
		var templateUploadDetails = {};
		vm.sourceSystemName = [];
		vm.bankSystemName = [];
		vm.pagination = {};
		vm.clickSourceConfig = clickSourceConfig;
		vm.clickBankConfig = clickBankConfig;
		vm.deleteSourceConfig = deleteSourceConfig;
		vm.editSourceConfig = editSourceConfig;
		vm.editBankConfig = editBankConfig;

		vm.loadSourceSystem = loadSourceSystem;
		vm.listSourceSystem = listSourceSystem;
		vm.uploadFileTemplate = uploadFileTemplate;
		vm.downloadFile = downloadFile;
		//vm.getSystemDetails = getSystemDetails;

		vm.loadBank = loadBank;
		vm.listBank = listBank;
		vm.detail = {}
		//getSystemDetails();
		getTemplateDetails();

		vm.inputFeedSchedule={};
		vm.inputschedule={};
		vm.saveInputFeed=saveInputFeed;
		vm.getInputFeedSchedule=getInputFeedSchedule;
		
		vm.bankschedule={};
		vm.saveBankFeed=saveBankFeed;
		vm.getBankFeedSchedule=getBankFeedSchedule;
		
		vm.changeJobStatus=changeJobStatus;
		vm.jobstatus=false;
		getScheduleStatus();
		
		
		function clickSourceConfig() {
			$state.go('triangular.sourceSystem');
		}
		function deleteSourceConfig(detail) {
			commonutilService.set("sourceconfig", detail)
			commonutilService.set("mode", "Delete");
			$state.go('triangular.deleteSourceSystem');
		}

		function editSourceConfig(detail) {
			commonutilService.set("modeEdit", "Edit");

			commonutilService.set("selSourceName", detail);
			commonutilService.set("category", vm.category);

			commonutilService.set("sourceconfig", templateUploadDetails.sources);

			$state.go('triangular.editSourceSystem');
		}

		function editBankConfig(detail) {
			commonutilService.set("modeEdit", "Edit");

			commonutilService.set("selBankName", detail);
			commonutilService.set("category", vm.category);

			commonutilService.set("bankconfig", templateUploadDetails.banks);

			$state.go('triangular.editBankSystem');
		}

		function clickBankConfig() {

			$state.go('triangular.bankConfigSystem');
		}

		// added below

		function loadSourceSystem() {
	
			var sourceSysDetails = templateUploadDetails.sources, configTableRow = [];
			vm.sourceSystemName=[];
			angular.forEach(sourceSysDetails, function(sourceSysDetail) {

				configTableRow = sourceSysDetail.configTable.row;
				vm.sourceSystemName.push(configTableRow[0]);

			});
		}

		function listSourceSystem() {
			loadSourceSystem();
		}

		// For Bank

		function loadBank() {
			
			var bankDetails = templateUploadDetails.banks, configTableRow = [];
			vm.bankSystemName=[];

			angular.forEach(bankDetails, function(bankDetail) {

				configTableRow = bankDetail.configTable.row;
				vm.bankSystemName.push(configTableRow[0]);

			});

		}

		function listBank() {
			loadBank();
		}

		function uploadFileTemplate() {
			var uploadFile = undefined, fileTempl = undefined;
			angular.forEach($scope.fileName, function(obj) {
				if (!obj.isRemote) {
					// uploadFile['fileName'] = obj.lfFileName;
					// uploadFile['fileType'] = obj.lfFileType;
					fileTempl = obj.lfFile;
				}
			});

			billingSystemService.uploadFile(vm.category,fileTempl).then(
					function(data) {
						templateUploadDetails = data;
						loadSourceSystem();
						loadBank();
						$mdToast.show($mdToast.simple().toastClass(
								'md-toast-done').content(
								'Template Uploaded Successfully').position(
								'bottom right').hideDelay(2000));

					});

		}

		function downloadFile() {

			billingSystemService.downloadFile(vm.category).then(function(data) {
    			var file = new Blob([data], {type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"});
                var fileURL = window.URL.createObjectURL(file);

    			var anchor = angular.element('<a/>');
        		anchor.attr({
        		    href: fileURL,
        		    target: '_blank',
        		    download: vm.fileName
        		})[0].click();
    		});

		}

		/*function getSystemDetails() {
			if(!vm.category){
				vm.category='collections'
			}
			billingSystemService.getSystemDetails(vm.category).then(function(data) {
				systemDetails = data;
				vm.fileName = data.fileName;
				vm.category=data.category;

			});
		}*/
		$scope.getSelectedTemplateDetails = function(){
			billingSystemService.getTemplateDetails(vm.category).then(function(data) {
				templateUploadDetails = angular.fromJson(data.cbiConfigDetails);
				vm.fileName = data.fileName;
				vm.category=data.category;
				loadSourceSystem();
				loadBank();
				

			});
		};
		function getTemplateDetails() {
			if(!vm.category){
				vm.category="Collection"
			}
			billingSystemService.getTemplateDetails(vm.category).then(function(data) {
				templateUploadDetails = angular.fromJson(data.cbiConfigDetails);
				vm.fileName = data.fileName;
				vm.category=data.category;
				loadSourceSystem();
				loadBank();
				

			});
		}
		
		
		$scope.getSelectedInputSchedule = function(){
			getInputFeedSchedule();
		};	
		
		$scope.getSelectedBankSchedule = function(){
			getBankFeedSchedule();
		};	
			
		
	function saveBankFeed() {
		
				vm.bankschedule.category=vm.category;
				
				billingSystemService.saveBankFeedScheduleInfo(vm.bankschedule).then(function(data) {
					
					$mdToast.show($mdToast.simple().toastClass(
					'md-toast-done').content(
					'Input Feed Detail Saved Successfully').position(
					'bottom right').hideDelay(2000));
							
						//$state.go('triangular.dashboard');
						
				});
			
				
			}		
		
		
	function saveInputFeed() {
		vm.inputschedule.category=vm.category;			
			billingSystemService.saveInputFeedScheduleInfo(vm.inputschedule).then(function(data) {
				
				$mdToast.show($mdToast.simple().toastClass(
				'md-toast-done').content(
				'Input Feed Detail Saved Successfully').position(
				'bottom right').hideDelay(2000));
						
					//$state.go('triangular.dashboard');
					
			});
		
			
		}
	
	function getInputFeedSchedule(){		
				
		vm.inputschedule.category=vm.category;
		
		billingSystemService.getInputFeedScheduleInfo(vm.inputschedule).then(function(data) {
			console.log('vm.inputschedule----------->', data);
			vm.inputschedule.scheduleDetails = data;
			console.log('vm.inputschedule.recurrenceType.freqType----------->', vm.inputschedule.scheduleDetails.recurrenceType.freqType);
			
			if(vm.inputschedule.scheduleDetails.recurrenceType.freqType==='hourly')
				{
					vm.showHoulry=true;
					vm.showDaily=false;
					vm.showWeekly=false;
					vm.showMonthly=false;
				}
				else if (vm.inputschedule.scheduleDetails.recurrenceType.freqType==='daily')
				{
					vm.showHoulry=false;
					vm.showDaily=true;
					vm.showWeekly=false;
					vm.showMonthly=false;
				}
				else if (vm.inputschedule.scheduleDetails.recurrenceType.freqType==='weekly')
				{
					vm.showHoulry=false;
					vm.showDaily=false;
					vm.showWeekly=true;
					vm.showMonthly=false;
				}				
				else if (vm.inputschedule.scheduleDetails.recurrenceType.freqType==='monthly')
				{
					vm.showHoulry=false;
					vm.showDaily=false;
					vm.showWeekly=false;
					vm.showMonthly=true;
					if(vm.inputschedule.scheduleDetails.recurrenceType.monthly.monthlyFreType==='day')
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
	
	function getBankFeedSchedule(){	
		vm.bankschedule.category=vm.category;
		
		billingSystemService.getBankFeedScheduleInfo(vm.bankschedule).then(function(data) {
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
	
	function getScheduleStatus()
	{
		billingSystemService.getScheduleStatus().then(function(data) {
			vm.jobstatus = data;
			
		});
	}
	
	
	function changeJobStatus()
	{	
		billingSystemService.changeJobStatus(vm.jobstatus).then(function(data) {
			console.log('vm.changeJobStatus----------->', data);
			//vm.jobstatus = data;
			
		});
		
	}

	
	
		

	}
})();
