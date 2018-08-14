(function() {
    'use strict';

    angular
        .module('app.prudential.billingsystem')
        .factory('homeService', homeService);

    /* @ngInject */
    function homeService($rootScope, $http, $q, $state, $mdDialog, $mdToast, API_CONFIG) {
    	var vm=this;
    	vm.errorCode={};
    	vm.errorMsg={};
        var factory = {
        	clickCancel: clickCancel,
            getFromServer : getFromServer,
            getPagedRequestFromServer: getPagedRequestFromServer,
            getBlobFromServer: getBlobFromServer,
            postToServer : postToServer,
            putToServer : putToServer,
            deleteFromServer : deleteFromServer,
            uploadToServer: uploadToServer,
            uploadFileToServer: uploadFileToServer,
            uploadFilesToServer: uploadFilesToServer,
            showPreviousButton: showPreviousButton,
            showNextButton: showNextButton,
            showActionButton: showActionButton
        };

        return factory;

        function clickCancel() {
            $mdDialog.cancel();
        }

        function getFromServer(context, id, headers, searchObject) {
            var deferred = $q.defer();

            headers = headers ? headers : {};

            if (id) {
            	$http.get(serverURL(context, id), headers).success(function(data) {
                    deferred.resolve(data);
                }).error(function(response, statusCode) {
                	handleError(response, statusCode, context, deferred);
                });
            }
            else if (searchObject) {
            	$http.get(serverURL(context), {
            		headers: headers,
            		params: searchObject
            	}).success(function(data) {
                    deferred.resolve(data);
                }).error(function(response, statusCode) {
                	handleError(response, statusCode, context, deferred);
                });
            }
            else {
            	$http.get(serverURL(context), headers).success(function(data) {
                    deferred.resolve(data);
                }).error(function(response, statusCode) {
                	handleError(response, statusCode, context, deferred);
                });
            }


            return deferred.promise;
        }

        function getPagedRequestFromServer(context, pageNumber, pageSize) {
            var deferred = $q.defer();

            pageNumber = pageNumber ? pageNumber: 1;
            pageSize = pageSize ? pageSize : 10;
            var params = {'page' : pageNumber, 'size': pageSize};

            console.log('Paging Parameters: ');console.log(params);
            $http.get(serverURL(context), {params: params}).success(function(data) {
                deferred.resolve(data);
            }).error(function(response, statusCode) {
            		handleError(response, statusCode, context, deferred);
            });


            return deferred.promise;
        }

        function getBlobFromServer(context, id) {
            var deferred = $q.defer();

            $http.get(serverURL(context, id), {responseType: 'arraybuffer'}).success(function(data) {
                deferred.resolve(data);
            }).error(function(response, statusCode) {
            	handleError(response, statusCode, context, deferred);
            });

            return deferred.promise;
        }

        function postToServer(context, data, headers, vm) {
            var deferred = $q.defer();

            var jsonData = angular.toJson(data);
            $http.post(serverURL(context), jsonData, headers).success(function(data) {
                deferred.resolve(data);
            }).error(function(response, statusCode) {
            		handleError(response, statusCode, context, deferred, vm);
            });

            return deferred.promise;
        }

        function uploadToServer(context, file, data) {
        	var deferred = $q.defer();

        	var fd = new FormData();
    		fd.append('file', file);
    		angular.forEach(data, function(value, key) {
        		fd.append(key, angular.toJson(value));
        	});

    		$http.post(serverURL(context), fd, {
        		transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
        	}).success(function(data) {
        		deferred.resolve(data);
        	}).error(function(response, statusCode) {
        		handleError(response, statusCode, context, deferred);
        	});

        	return deferred.promise;
        }
        
        function uploadFileToServer(context, file) {
        	var deferred = $q.defer();

        	var fd = new FormData();
    		fd.append('file', file);

    		$http.post(serverURL(context), fd, {
        		transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
        	}).success(function(data) {
        		deferred.resolve(data);
        	}).error(function(response, statusCode) {
        		handleError(response, statusCode, context, deferred);
        	});

        	return deferred.promise;
        }
        
        function uploadFilesToServer(context, files, data) {
        	var deferred = $q.defer();

        	var fd = new FormData();
    		//fd.append('file', file);
    		for (var i in files) {
    			fd.append("files", files[i]);
            }
    		
    		angular.forEach(data, function(value, key) {
        		fd.append(key, angular.toJson(value));
        	});

    		$http.post(serverURL(context), fd, {
        		transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
        	}).success(function(data) {
        		deferred.resolve(data);
        	}).error(function(response, statusCode) {
        		handleError(response, statusCode, context, deferred);
        	});

        	return deferred.promise;
        }

        function putToServer(context, id, data) {
        	var deferred = $q.defer();

        	var jsonData = angular.toJson(data);
            $http.put(serverURL(context, id), jsonData).success(function(data) {
                deferred.resolve(data);
            }).error(function(response, statusCode) {
            	handleError(response, statusCode, context, deferred);
            });

            return deferred.promise;
        }

        function deleteFromServer(context, id, vm) {
            var deferred = $q.defer();

            $http['delete'](serverURL(context, id)).success(function(data) {
                deferred.resolve(data);
            }).error(function(response, statusCode) {
            	handleError(response, statusCode, context, deferred,vm);
            });

            return deferred.promise;
        }

        function handleError(response, statusCode, context, deferred, vm) {
        	console.log("Error ["+statusCode+"] gettting from : "+context);
        	if (statusCode === 401) {
        		delete $rootScope.authenticated;

        		if ($mdDialog) {
        			$mdDialog.hide();
        		}

            	$state.go('authentication.login');
        	}
        	else if (statusCode === 404) {
        		$mdToast.show(
        				$mdToast.simple()
                          .toastClass('md-toast-error')
                        	.content('ERROR ('+response.errorCode+', '+response.errorMessage+')')
                        	.position('bottom right')
        				);
        	}
        	else if (statusCode === 424) {
        		if(vm){
        			vm.errorCode = response.errorCode;
        			vm.errorMsg = response.errorMsg;
        		} else {
        			/*$mdToast.show(
            				$mdToast.simple()
                    .toastClass('md-toast-error')
                            	.content('ERROR ('+response.errorCode+', '+response.errorMsg+')')
                            	.position('bottom right')
                              .highlightAction(true)
                              .highlightClass('md-accent')
            				);*/
        			$mdDialog.show({
                        controller: 'HomeController',
                        controllerAs: 'vm',
                        templateUrl: 'app/prudential/billingsystem/home/error.tmpl.html',
                        locals: {
                            //mode: 'ViewError',
                            readOnly: true,
                            pageTitle: 'Errors',
                            errorCode : response.errorCode,
                            errorMsg : response.errorMsg
                        },
                        bindToController: true,
                        preserveScope: true
                    });

        		}
        	}
            deferred.reject(response);
        }

        function serverURL(context, id) {
        	var serverURL = API_CONFIG.URL;

        	if (!String.prototype.endsWith) {
	    		  String.prototype.endsWith = function(searchString, position) {
	    		      var subjectString = this.toString();
	    		      if (typeof position !== 'number' || !isFinite(position) || Math.floor(position) !== position || position > subjectString.length) {
	    		        position = subjectString.length;
	    		      }
	    		      position -= searchString.length;
	    		      var lastIndex = subjectString.indexOf(searchString, position);
	    		      return lastIndex !== -1 && lastIndex === position;
	    		  };
    		}


        	if (context) {
        		if (serverURL.endsWith("/")) {
        			serverURL += context;
                }
                else {
                	serverURL += "/" + context;
                }
        	}

        	if (id != undefined) {
        		if (serverURL.endsWith("/")) {
        			serverURL += id;
                }
                else {
                	serverURL += "/" + id;
                }
        	}

        	return serverURL;
        }

        function showPreviousButton(mode, currentStep) {
    		if (mode === 'Add' || mode === 'Save') {
    			if (currentStep === 0) {
    				return false;
    			}

    			return true;
    		}

    		return false;
    	}

        function showNextButton(mode, currentStep, lastStep) {
    		if (mode === 'Add' || mode === 'Save') {
    			if (currentStep === lastStep) {
    				return false;
    			}

    			return true;
    		}

    		return false;
    	}

        function showActionButton(mode, currentStep, lastStep) {
        	if (mode === 'Add' || mode === 'Save') {
    			if (currentStep === lastStep) {
    				return true;
    			}

    			return false;
    		}

    		return true;
    	}
     }
})();
