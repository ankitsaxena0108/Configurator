(function() {
    'use strict';

    angular
        .module('triangular.components')
        .directive('triWizard', TriWizard);

    /* @ngInject */
    function TriWizard() {
        // Usage: <div tri-wizard> (put some forms in here) </div>
        //
        // Creates: Nothing
        //
        var directive = {
            bindToController: true,
            controller: WizardController,
            controllerAs: 'triWizard',
            restrict: 'A'
        };
        return directive;
    }

    /* @ngInject */
    function WizardController($scope, $timeout) {
        var vm = this;

        var forms = [];
        var totalRequiredFields = 0;

        vm.currentStep = 0;
        vm.getForm = getForm;
        vm.isFormValid = isFormValid;
        vm.nextStep = nextStep;
        vm.nextStepDisabled = nextStepDisabled;
        vm.prevStep = prevStep;
        vm.prevStepDisabled = prevStepDisabled;
        vm.progress = 0;
        vm.registerForm = registerForm;
        vm.updateProgress = updateProgress;

        ////////////////

        function getForm(index) {
            return forms[index];
        }

        function nextStep() {
            vm.currentStep = vm.currentStep + 1;
        }

        function nextStepDisabled() {
            // get current active form
            var form = $scope.triWizard.getForm(vm.currentStep);
            var formInvalid = true;
            if(angular.isDefined(form) && angular.isDefined(form.$invalid)) {
                formInvalid = form.$invalid;
            }
            
//            angular.forEach(form, function(field) {
//            	if(angular.isObject(field) && field.hasOwnProperty('$modelValue')) {
//            		if (field.$valid === false) {
//            			console.log('Found invalid field: '+field.$name);
//            		}
//            		else {
//            			console.log('Found valid field: '+field.$name);
//            		}
//            		
//            	}
//            });
            return formInvalid;
        }

        function isFormValid(step) {
            if(angular.isDefined(forms[step])) {
                return forms[step].$valid;
            }
        }

        function prevStep() {
            vm.currentStep = vm.currentStep - 1;
        }

        function prevStepDisabled() {
            return vm.currentStep === 0;
        }

        function registerForm(form) {
            forms.push(form);
        }

        function updateProgress() {
            var filledRequiredFields = calculateFilledFields();

            // calculate percentage process for completing the wizard
            vm.progress = Math.floor((filledRequiredFields / totalRequiredFields) * 100);
        }

        function calculateFilledFields() {
            var filledValidFields = 0;
            for (var form = forms.length - 1; form >= 0; form--) {
                angular.forEach(forms[form], function(field) {
                	var existsProperties = field && field.$name && $('input[name='+field.$name+']')[0];
                	var isRequired = existsProperties && 
                			$('input[name='+field.$name+']')[0].required;
                	var isDisabled =  existsProperties && 
                			$('input[name='+field.$name+']')[0].attributes['ng-disabled'] && 
                			$('input[name='+field.$name+']')[0].attributes['ng-disabled'].nodeValue === 'true';
                	
                    if(angular.isObject(field) && field.hasOwnProperty('$modelValue') && field.$valid === true && isRequired && !isDisabled){
                        filledValidFields = filledValidFields + 1;
                    }
                });
            }
            return filledValidFields;
        }

        // init

        // wait until this tri wizard is ready (all forms registered)
        // then calculate the total form fields
        $timeout(function() {
            for (var form = forms.length - 1; form >= 0; form--) {
                angular.forEach(forms[form], function(field) {
                	var existsProperties = field && field.$name && $('input[name='+field.$name+']')[0];
                	var isRequired = existsProperties && 
                			$('input[name='+field.$name+']')[0].required;
                	var isDisabled =  existsProperties && 
                			$('input[name='+field.$name+']')[0].attributes['ng-disabled'] && 
                			$('input[name='+field.$name+']')[0].attributes['ng-disabled'].nodeValue === 'true';
                    
                	if(angular.isObject(field) && field.hasOwnProperty('$modelValue') && isRequired && !isDisabled){
                        totalRequiredFields = totalRequiredFields + 1;
                    }
                });
            }
            updateProgress();
        });
    }
})();