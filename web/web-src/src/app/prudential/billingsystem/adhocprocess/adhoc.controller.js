(function() {
	'use strict';

	angular.module('app.prudential.billingsystem').controller(
			'AdhocProcessController', AdhocProcessController);

	console.log("AdhocProcessController launched");

	/* @ngInject */
	function AdhocProcessController($scope, $mdDialog, $mdToast, homeService,
			$state, billingSystemService, commonutilService) {
		var vm = this;
		var systemDetails = {};
		var templateUploadDetails = {};
		vm.sourceSystemName = [];
		vm.bankSystemName = [];
		vm.pagination = {};
	
		vm.loadSourceSystem = loadSourceSystem;
		vm.listSourceSystem = listSourceSystem;
	
		vm.loadBank = loadBank;
		vm.listBank = listBank;
		vm.detail = {}
		//getSystemDetails();
		getTemplateDetails();

		
		vm.startNode=startNode;
		
		
		
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
		
	
	

	
	function startNode(systemName)
	{	
		console.log('systemName----------->'+systemName);
		console.log('vm.category----------->'+vm.category);
		vm.detail.category=vm.category;
		vm.detail.systemName=systemName
		billingSystemService.startNode(vm.detail).then(function(data) {
					
			$mdToast.show($mdToast.simple().toastClass(
					'md-toast-done').content(systemName+' Node Started Successfully').position(
					'bottom right').hideDelay(2000));
			
			
		});
		
	}
	

	}
})();
