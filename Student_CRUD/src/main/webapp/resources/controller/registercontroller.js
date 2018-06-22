//var regApp=angular.module("regApp", []);
mainApp.controller("registercontroller",[
	'$scope','$window','$http',
		function($scope,$window,$http){
		
		
			$scope.add=function(){
			
				$http({
					url:"http://localhost:1010/springmodel/add",
					method:"POST",
					data:$scope.student
					
				}).then(
						function (result){
							$scope.jsontasklist=result.data;
						},function (result){
							$window.alert("JSON Failed");
						});//then and $http close
			}//taskList function close
		/*$scope.listTask=function(){
			$http({
				url:"http://localhost:1010/springmodel/listtask",
				method:"GET",
				data:$scope.form1
				
			}).then(
					function (result){
						$scope.jsontasklist=result.data;
					},function (result){
						$window.alert("JSON Failed");
					});//then and $http close
		}//taskList function close
*/	}//function close
]);//controller close
      
