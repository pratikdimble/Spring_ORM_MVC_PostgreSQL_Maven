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
			
		/*	var promise = $http(httpObject).then(function(response) {
				//console.log(response);
				//return response.data.result;
				 if(response.data._status_Code === 200){
					 if(httpVerb == 'POST' || httpVerb == 'post' || httpVerb == 'PUT' || httpVerb == 'put'){
						 //$rootScope.showNotification(response.data._status_Code,response.data._status,response.data._error_message);
					 }
					    return (response.data.result);
				}else{
					if($rootScope.isConfiguration != true)
					 $rootScope.showNotification(response.data._status_Code,response.data.result,response.data._error_message);
				}
			},function(){
				   $rootScope.showNotification(0,"",$rootScope.connectionError);
			  });*/
		};
	}]);