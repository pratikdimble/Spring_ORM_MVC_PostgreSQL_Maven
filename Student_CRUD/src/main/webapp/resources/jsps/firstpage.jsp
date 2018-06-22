
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app = "mainApp">
   
   <head>
      <title>Angular JS Views</title>
      <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
          <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular-route.min.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/1.0.18/angular-ui-router.min.js"></script>
         <script  src="//angular-ui.github.io/ui-router/release/angular-ui-router.js"></script>
   <script  src = "resources/controller/firstpagecontroller.js"></script>
<!--    	<script  src = "resources/service/genericservice.js"></script> -->
<!--      <script  src = "resources/js/angular-ui-router.min.js"></script> -->
   </head>
   
   <body>
      <h2>AngularJS Sample Application</h2>
      	<div >
<!--       	<ul >
        <li ng-class="{ active: $state.includes('register') }"><a ui-sref="register">Register</a>
        </li>
        <li ng-class="{ active: $state.includes('login') }"><a ui-sref="login">Login</a>
        </li>
      </ul> -->
    		<a href = "#add"><button name="register">Register</button></a>
	  		<a href = "#login"><button name="login">Login</button></a>
		<!--   	<!-- <a href = "#delete"><button ng-click="" name="delete">Delete</button></a>
			<a href = "#view"><button ng-click="" name="view">View Details</button></a>
			<a href = "#update"><button ng-click="" name="update">Update</button></a> -->
      <!--    <p><a href = "#addStudent">Add Student</a></p>
         <p><a href = "#viewStudents">View Students</a></p> -->
         					
         <div ng-view>
         
         <script type = "text/ng-template" src = "resources/jsps/register.jsp">
            <h2> Add Student </h2>
            {{message}}
         </script>
         <script type = "text/ng-template" src = "resources/jsps/login_form.jsp"> 
            <h2> Add Student </h2>
            {{message}}
         </script>
  <!--          <script type = "text/ng-template" src = "resources/jsps/delete.jsp">
            <h2> Add Student </h2>
            {{message}}
         </script>
          <script type = "text/ng-template" src = "resources/jsps/view.jsp">
            <h2> Add Student </h2>
            {{message}}
         </script>
          <script type = "text/ng-template" src = "resources/jsps/update.jsp">
            <h2> Add Student </h2>
            {{message}}
         </script>-->
         
      </div>
</div>      
      
   </body>
</html>

