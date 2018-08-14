(function() {
	'use strict';

	angular.module('app.prudential.billingsystem').factory(
			'billingSystemService', billingSystemService);

	/* @ngInject */
	function billingSystemService($http, $q, homeService) {
		var SAVE_SOURCE_SYSTEM = '/billingsystem/sourcesystem/';
		var SAVE_SOURCE_SYSTEM_FILES = '/billingsystem/sourcesystem/files';
		var SAVE_BANK_CONFIG = '/billingsystem/bankconfig/';
		var AUDIT_ENQUIRY = '/billingsystem/auditsearch/';
		var DASHBOARD_SOURCE_SYSTEM_CONFIG = '/billingsystem/listsourcesystem';
		var UPLOAD_FILE = '/billingsystem/uploadFile';
		var GET_TEMPLATE_INFO = '/billingsystem/getTemplate';
		//var GET_FILE_NAME = '/billingsystem/getSystemDetails';
		var DOWNLOAD_FILE='/billingsystem/fileDownload';
		var SAVE_SCHEDULE_INFO='/billingsystem/savescheduleinfo';
		var GET_SRC_SCHEDULE_INFO='/billingsystem/getSourceSystemSchedule';
		
		var SAVE_BANK_SCHEDULE_INFO='/billingsystem/saveBankScheduleInfo';
		var GET_BANK_SCHEDULE_INFO='/billingsystem/getBankSchedule';
		
		var SAVE_BANK_OTHER_INFO='/billingsystem/saveBankOtherInf';
		var GET_BANK_OTHER_INFO='/billingsystem/getBankOtherInfo';
		
		var SAVE_INPUT_FEED_SCHEDULE_INFO='/billingsystem/saveInputFeedScheduleInfo';
		var GET_INPUT_FEED_SCHEDULE_INFO='/billingsystem/getInputFeedScheduleInfo';
		
		var SAVE_BANK_FEED_SCHEDULE_INFO='/billingsystem/saveBankFeedScheduleInfo';
		var GET_BANK_FEED_SCHEDULE_INFO='/billingsystem/getBankFeedScheduleInfo';
		
		var CHANGE_JOB_STATUS='/billingsystem/changeJobStatus';
		
		var GET_JOB_STATUS='/billingsystem/getScheduleStatus';
		
		var RECON_REPORT_SEARCH = '/billingsystem/reconReportSearch';
		
		var REJECT_REPORT_SEARCH = '/billingsystem/rejectReportSearch';
		
		var ADHOC_START_NODE = '/billingsystem/startNode';

		var factory = {
			saveSourceSystemConfig : saveSourceSystemConfig,
			saveBankConfig : saveBankConfig,
			searchFileAudit : searchFileAudit,
			listSourceSystem : listSourceSystem,
			uploadFile : uploadFile,
			getTemplateDetails: getTemplateDetails,
			//getSystemDetails: getSystemDetails,
			getTableFormatDetails:getTableFormatDetails,
			downloadFile:downloadFile,
			saveScheduleInfo:saveScheduleInfo,
			getSourceSystemSchedule:getSourceSystemSchedule,
			saveBankScheduleInfo:saveBankScheduleInfo,
			getBankSchedule:getBankSchedule,
			saveBankOtherInfo:saveBankOtherInfo,
			getBankOtherInfo:getBankOtherInfo,
			saveInputFeedScheduleInfo:saveInputFeedScheduleInfo,
			getInputFeedScheduleInfo:getInputFeedScheduleInfo,
			saveBankFeedScheduleInfo:saveBankFeedScheduleInfo,
			getBankFeedScheduleInfo:getBankFeedScheduleInfo,
			changeJobStatus:changeJobStatus,
			getScheduleStatus:getScheduleStatus,
			searchReconDetails : searchReconDetails,
			searchRejectDetails:searchRejectDetails,
			startNode:startNode
			
		};

		return factory;
		
		function startNode(data) {
			return homeService.postToServer(ADHOC_START_NODE, data);
		}
		
		
		function searchRejectDetails(rejectDetails) {
			return homeService.postToServer(REJECT_REPORT_SEARCH, rejectDetails);
		}
		

		function searchReconDetails(reconDetails) {
			return homeService.postToServer(RECON_REPORT_SEARCH, reconDetails);
		}
		

		function getScheduleStatus() {

			return homeService.getFromServer(GET_JOB_STATUS);

		}
		
		
		function changeJobStatus(data) {
			return homeService.postToServer(CHANGE_JOB_STATUS, data);

		}
		
		
		function saveBankFeedScheduleInfo(data) {
			return homeService.postToServer(SAVE_BANK_FEED_SCHEDULE_INFO, data);

		}
		
		
		function getBankFeedScheduleInfo(data) {
			return homeService.postToServer(GET_BANK_FEED_SCHEDULE_INFO, data);

		}
		
		
		function saveInputFeedScheduleInfo(data) {
			return homeService.postToServer(SAVE_INPUT_FEED_SCHEDULE_INFO, data);

		}
		
		
		function getInputFeedScheduleInfo(data) {
			return homeService.postToServer(GET_INPUT_FEED_SCHEDULE_INFO, data);

		}
		
		function saveBankScheduleInfo(data) {
			return homeService.postToServer(SAVE_BANK_SCHEDULE_INFO, data);

		}
		
		function getBankSchedule(data) {
			return homeService.postToServer(GET_BANK_SCHEDULE_INFO,data);

		}
		
		
		
		function saveScheduleInfo(data) {
			return homeService.postToServer(SAVE_SCHEDULE_INFO, data);

		}
		

		function getBankOtherInfo(data) {
			return homeService.postToServer(GET_BANK_OTHER_INFO,data);

		}
		
		
		
		function saveBankOtherInfo(data) {
			return homeService.postToServer(SAVE_BANK_OTHER_INFO, data);

		}

		
		function getSourceSystemSchedule(data) {			
			return homeService.postToServer(GET_SRC_SCHEDULE_INFO,data);

		}
		

		function saveSourceSystemConfig(files, data) {
			if (files) {
				var jsonData = data;

				var data = {
					'srcSystemConfigObj' : jsonData

				}

				return homeService.uploadFilesToServer(
						SAVE_SOURCE_SYSTEM_FILES, files, data);
			} else {
				return homeService.postToServer(SAVE_SOURCE_SYSTEM, data);
			}

		}
		function saveBankConfig(data) {
			return homeService.postToServer(SAVE_BANK_CONFIG, data);

		}

		function searchFileAudit(fileaudit) {
			return homeService.postToServer(AUDIT_ENQUIRY, fileaudit);
		}

		function listSourceSystem(pageNumber, pageSize) {
			return homeService.getPagedRequestFromServer(
					DASHBOARD_SOURCE_SYSTEM_CONFIG, pageNumber, pageSize);
		}

		function uploadFile(category,file) {
			if (file) {
				var jsonObjects = {
            			'category': category
            	};
				return homeService.uploadToServer(UPLOAD_FILE, file,jsonObjects);
			}
		}
		function getTemplateDetails(category){
			
			return homeService.getFromServer(GET_TEMPLATE_INFO,category);
			
		}
		
		/*function getSystemDetails(category){
			
			return homeService.getFromServer(GET_FILE_NAME,category);
			
		}*/
		
		function getTableFormatDetails(jsontabledata) {

			var tableValues = [];
			
			var tablecolumns = jsontabledata.columns;
			var tablerows=jsontabledata.row;
			
			for (var i = 0; i < tablecolumns.length; i++) {
				var tableValue={};
				tableValue.row=tablerows[i];
				tableValue.column=tablecolumns[i];
				tableValues.push(tableValue);

			}
			return tableValues;

		}
		function downloadFile(category){
			return homeService.getBlobFromServer(DOWNLOAD_FILE, category);
		}

	}

})();