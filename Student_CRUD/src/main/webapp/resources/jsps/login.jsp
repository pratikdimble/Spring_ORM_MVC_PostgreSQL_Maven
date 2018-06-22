<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
      <html ng-app = "mainApp">
   <head>
      <title>Login Page</title>
     <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<!--      <script src = "resources/js/mainApp.js"></script> -->
<!--      <script  src = "resources/controller/registercontroller.js"></script> -->
        <script  src = "resources/controller/firstpagecontroller.js"></script>
      
      <style>
         table, th , td {
            border: 1px solid grey;
            border-collapse: collapse;
            padding: 5px;
         }
         
         table tr:nth-child(odd) {
            background-color: #f2f2f2;
         }
         
         table tr:nth-child(even) {
            background-color: #ffffff;
         }
      </style>
      
   </head>
   
   <body>
      <h2>Login Page</h2>
      <div  ng-controller = "logincontroller" ng-form="mvcForm">
        	
         <table border = "0">
            <tr>
               <td>Enter username: </td>
               <td><input type = "text" ng-model = "student.username" ></td>
            </tr>
                <tr>
               <td>Enter Password: </td>
               <td><input type = "password" ng-model = "student.password" ></td>
            </tr>
         </table><br/>
        <button ng-click="login()">Login</button>
      </div>
   </body>
</html>
