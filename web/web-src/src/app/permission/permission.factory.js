(function() {
	'use strict';

	angular.module('app.permission').factory('PermissionService',
			PermissionService);

	/* @ngInject */
	function PermissionService($q, $http, $cookieStore, RoleStore,
			PermissionStore, $rootScope, $state, homeService) {
		var currentUser;

		var service = {
			getCurrentUser : getCurrentUser,
			hasPermission : hasPermission,
			authenticate : authenticate,
			relogin : relogin
		};

		return service;

		///////////////

		function getCurrentUser() {
			console.log("getCurrentUser() Authenticated: "
					+ $rootScope.authenticated);

			//        	if (!$rootScope.authenticated) {
			//        		console.log('Getting current user fails, NOT authenticated any more; Redirecting to login');
			//        		relogin();
			//        	}

			if ($cookieStore.get('billingsystem.displayName')
					&& $cookieStore.get('billingsystem.userName')) {
				console.log('Refresh of Page');
				currentUser = {
					displayName : $cookieStore.get('billingsystem.displayName'),
					username : $cookieStore.get('billingsystem.userName'),
					avatar : 'assets/images/avatars/avatar-1.png',
				};
			}

			if (!$rootScope.authenticated) {
				$state.go('triangular.home');
			}
			return currentUser;
		}

		function getUsers() {
			return $http.get('app/permission/data/users.json');
		}

		function hasPermission(permission) {
			var deferred = $q.defer();
			var hasPermission = false;

			// check if user has permission via its roles
			angular.forEach(currentUser.roles, function(role) {
				// check role exists
				if (RoleStore.hasRoleDefinition(role)) {
					// get the role
					var roles = RoleStore.getStore();

					if (angular.isDefined(roles[role])) {
						// check if the permission we are validating is in this role's permissions
						if (-1 !== roles[role].validationFunction
								.indexOf(permission)) {
							hasPermission = true;
						}
					}
				}
			});

			// if we have permission resolve otherwise reject the promise
			console.log("hasPermission: [" + hasPermission + "] for ["
					+ permission + "]");
			if (hasPermission) {
				deferred.resolve();
			} else {
				deferred.reject();
			}

			// return promise
			return deferred.promise;
		}

		function authenticate(credentials, callback) {
			var headers = credentials ? {
				authorization : "Basic "
						+ btoa(credentials.username + ":"
								+ credentials.password)
			} : {};

			/* Local Testing
			$rootScope.authenticated = true;
			callback && callback();
			 */
			homeService
					.getFromServer('authenticate', undefined, {
						headers : headers
					})
					.then(
							function(data) {
								if (data.principal) {
									var authorities = {};
									var loggedUserName = "";
									if (data.principal.principal && data.principal.principal.authorities) {
										authorities = data.principal.principal.authorities;
										loggedUserName = data.principal.principal.username;

									} else {
										authorities = data.principal.authorities
										loggedUserName = data.principal.username;
									}

									var roles = [];

									for (var i = 0; i < authorities.length; i++) {
										roles.push(authorities[i].authority);
									}

									currentUser = {
										displayName : data.principal.name,
										username : loggedUserName,
										avatar : 'assets/images/avatars/avatar-1.png',
										roles : roles
									};

									$cookieStore.put('billingsystem.displayName',
											currentUser.displayName);
									$cookieStore.put('billingsystem.userName',
											currentUser.username);

									var manyRoles = {}, allPermissions = [];
									angular
											.forEach(
													data.rolePermissions,
													function(rolePermission,
															role) {
														manyRoles[role] = [];
														angular
																.forEach(
																		rolePermission,
																		function(
																				permission) {
																			manyRoles[role]
																					.push(permission);
																			if (allPermissions
																					.indexOf(permission) === -1) {
																				allPermissions
																						.push(permission);
																			}
																		});

													});
									RoleStore.defineManyRoles(manyRoles);

									PermissionStore
											.defineManyPermissions(
													allPermissions,
													function(permissionName) {
														return hasPermission(permissionName);
													});

									$rootScope.authenticated = true;
									console
											.log("authenticate().if Authenticated: "
													+ $rootScope.authenticated);
								} else {
									$rootScope.authenticated = false;
									console
											.log("authenticate().else Authenticated: "
													+ $rootScope.authenticated);
								}
								callback && callback();
							},
							function(error) {
								$rootScope.authenticated = false;
								console
										.log("authenticate().error Authenticated: "
												+ $rootScope.authenticated);
								callback && callback();
							});
		}

		function relogin() {
			delete $rootScope.authenticated;
			console.log("relogin() Authenticated: " + $rootScope.authenticated);
			$state.go('authentication.login');
		}
	}
})();
