<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   
   <head>
      <title>Angular JS Views</title>
      <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
      <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular-route.min.js"></script>
   <script src = "resources/js/mainApp.js"></script>
     <script  src = "resources/js/studentController.js"></script>
     <script  src = "resources/js/studentUpdateController.js"></script>
     <script  src = "resources/js/angular-ui-router.min.js"></script>
     
   </head>
   
   <body>
      <h2>AngularJS Sample Application</h2>
      <div ng-app = "mainApp">
         <p><a href = "#addStudent">Add Student</a></p>
         <p><a href = "#viewStudents">View Students</a></p>
         <div ng-view>
         
         <script type = "text/ng-template" src = "resources/jsps/login.jsp">
            <h2> Add Student </h2>
            {{message}}
         </script>
         
         <script type = "text/ng-template" src = "resources/jsps/update.jsp">
            <h2> View Students </h2>
            {{message}}
         </script>
      </div>
</div>      
      <script>
         var mainApp = angular.module("mainApp", ['ngRoute']);
         mainApp.config(['$routeProvider', function($routeProvider) {
            $routeProvider.
            
            when('/addStudent', {
               templateUrl: 'resources/jsps/login.jsp',
               controller: 'studentController'
            }).
            
            when('/viewStudents', {
               templateUrl: 'resources/jsps/update.jsp',
               controller: 'studentsUpdateController'
            }).
            
            otherwise({
               redirectTo: '/route.jsp'
            });
         }]);
         
         mainApp.controller('AddStudentController', function($scope) {
            $scope.message = "This page will be used to display add student form";
         });
         
         mainApp.controller('ViewStudentsController', function($scope) {
            $scope.message = "This page will be used to display all the students";
         });
			
      </script>
      
   </body>
</html>