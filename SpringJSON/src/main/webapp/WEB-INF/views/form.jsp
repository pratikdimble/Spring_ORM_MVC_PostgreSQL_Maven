<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/bootstrap.css"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<spring:url value="/save" var="saveURL"></spring:url>
				           User Form
				<form:form action="${saveURL}" method="POST"
					modelAttribute="userForm">
					<form:hidden path="id" />
					<table class="table  table-condensed table-bordered" style = "width:30%;">
						<tr>
							<td>FirstName:</td>
							<td align="center"><form:input path="name" /></td>

						</tr>
						<tr>
							<td>Gender:</td>
							<td align="center"><form:radiobutton path="gender" value="Male" />Male</td>
							<td align="center"><form:radiobutton path="gender" value="FeMale" />Female</td>
						</tr>
						<tr>
							<td></td>
							<td align="center"><button class="btn-lg btn-success" type="submit">Save</button></td>

						</tr>

					</table>
				</form:form>
			</div>
		</div>
	</div>
	</body>
</html>