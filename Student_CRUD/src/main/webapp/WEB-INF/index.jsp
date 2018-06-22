<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%--     <%@ page isELIgnored="true" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="mainApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
   <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
      <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular-route.min.js"></script>
<!-- <script  src = "resources/controller/mainapp.js"></script> -->
<!-- <script  src = "resources/js/angular.min.js"></script> -->
<script  src = "resources/controller/firstpagecontroller.js"></script>
<script src=""></script>
</head>
<body >
<%-- 		 <%response.sendRedirect("/springmodelAngular_JSON_Student_CRUD/src/main/webapp/WEB-INF/views/firstpage.jsp"); %>  --%>
<!-- 	   <div ng-controller="maincontroller"> -->
<!-- 	   <a href="#">Main Content</a>   -->
	<div ng-view>
	   	<div ng-include="/views/firstpage.html"></div>
		 </div>
</body>
</html>