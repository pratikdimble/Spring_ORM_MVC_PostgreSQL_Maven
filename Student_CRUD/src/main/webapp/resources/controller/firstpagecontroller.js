  var mainApp = angular.module("mainApp", ['ngRoute','ui.router']);
  	
  	mainApp.config(function($stateProvider, $urlRouterProvider)
			{
				$urlRouterProvider.otherwise('/')
				$stateProvider
						.state('/',
							{
								url : '/',
								templateUrl: 'resources/jsps/firstpage.jsp',
					            controller: 'firstpagecontroller'
							})
							.state('/add',
							{
								url : '/add',
								templateUrl: 'resources/jsps/register.jsp',
					               controller: 'registercontroller',
							})
							.state('/login',
							{
								url : '/login',
								templateUrl: 'resources/jsps/login.jsp',
					               controller: 'logincontroller',
							})
							.state('/delete',
							{
								url : '/delete',
								templateUrl: 'resources/jsps/delete.jsp',
					               controller: 'deletecontroller',
							})
							});//url router close
  	
         mainApp.config(['$routeProvider', function($routeProvider) {
            $routeProvider.
            
            when('/add', {
               templateUrl: 'resources/jsps/register.jsp',
               controller: 'registercontroller'
            }).
            
            when('/login', {
               templateUrl: 'resources/jsps/login_form.jsp',
               controller: 'logincontroller'
            }).
            when('/delete', {
                templateUrl: 'resources/jsps/delete.jsp',
                controller: 'deletecontroller'
             }).
            
            otherwise({
               redirectTo: '/firstpage.jsp'
            });
         }]);
         
         mainApp.service('genericService', [ '$http','$rootScope', function($http,$rootScope) {
        		this.serviceAction = function(httpVerb, url, obj) {
        			var httpObject = {
        				method : httpVerb,
        				url : url,
        				data : obj
        			};

        			var promise = $http(httpObject).then(function(response) {
        				return response.data;
        			},function(){
        				 // alert("Service Call Error");
        			  });
        			return promise;
        			};
        		}]);
         
  mainApp.controller("registercontroller",[
	'$scope','$window','$http','genericService','$state',
	function($scope,$window,$http,genericService,$state){
	
    $scope.message = "This page will be used to display add student form";
		$scope.add=function(){
			var msg="";
			var URI = "http://localhost:1010/springmodel/add";
				genericService.serviceAction("POST", URI, $scope.form1).then(
						function(response)
							{
							$scope.msg=response.status;
							if (response.status == 'success')
								{
									$state.go('/login');
								//window.location.href = 'http://localhost:1010/springmodel/#/firstpage.jsp';
								console.log("$scope.msg after add", JSON.stringify($scope.msg));
								}
							else{
								console.log("$scope.msg after add", JSON.stringify($scope.msg));
							}
					},function (data){
						$window.alert("JSON Failed");
					});//then and $http close
		}//login function close
	}//function close
]);//controller close
            		//Login controller
            mainApp.controller("logincontroller",[
            	'$scope','$window','$http','genericService','$state',
            		function($scope,$window,$http,genericService,$state){
            		
            	    $scope.message = "This page will be used to display login student form";
            			$scope.login=function(){
            				var msg="";
            				var URI = "http://localhost:1010/springmodel/login";
								genericService.serviceAction("POST", URI, $scope.form1).then(
										function(response)
											{
											$scope.msg=response.status;
											if (response.status == 'success')
												{
													$state.go('/add');
												//window.location.href = 'http://localhost:1010/springmodel/#/firstpage.jsp';
												console.log("$scope.msg after login", JSON.stringify($scope.msg));
												}
											else{
												console.log("$scope.msg after login", JSON.stringify($scope.msg));
											}
            						},function (data){
            							$window.alert("JSON Failed");
            						});//then and $http close
            			}//login function close
            		}//function close
            ]);//controller close
            
            mainApp.controller("deletecontroller",[
            	'$scope','$window','$http','genericService','$state',
            		function($scope,$window,$http,genericService,$state){
            		
            	    $scope.message = "This page will be used to display delete student form";
            			$scope.deleteStud=function(){
            				var msg="";
            				var URI = "http://localhost:1010/springmodel/delete";
								genericService.serviceAction("POST", URI, $scope.form1).then(
										function(response)
											{
											$scope.msg=response.status;
											if (response.status == 'success')
												{
													$state.go('/');
												//window.location.href = 'http://localhost:1010/springmodel/#/firstpage.jsp';
												console.log("$scope.msg after delete", JSON.stringify($scope.msg));
												}
											else{
												console.log("$scope.msg after delete", JSON.stringify($scope.msg));
											}
											
												
												
            						},function (data){
            							$window.alert("JSON Failed");
            						});//then and $http close
            			}//login function close
            		}//function close
            ]);//controller close
        /* mainApp.controller('ViewStudentsController', function($scope) {
            $scope.message = "This page will be used to display all the students";
         });*/
            /*	.then(
			function (data){
				$scope.msg=data;
			//	$scope.status=response.status;*/
            
            
            
            
            /*mainApp.controller("registercontroller",[
        	'$scope','$window','$http',
        		function($scope,$window,$http){
        		
        	    $scope.message = "This page will be used to display add student form";
        			$scope.add=function(){
        				$http({
        					url:"http://localhost:1010/springmodel/add",
        					method:"POST",
        					data:$scope.form1
        				}).then(
        						function (result){
        							$scope.jsontasklist=result.data;
        						},function (result){
        							$window.alert("JSON Failed");
        						});//then and $http close
        			}//add function close
        		}//function close
        ]);//controller close
*/ 