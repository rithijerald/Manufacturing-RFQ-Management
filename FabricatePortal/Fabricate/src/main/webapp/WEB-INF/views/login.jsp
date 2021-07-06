<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:lavender">
	<h1><center>Manufacturing RFQ Management</center></h1>
	<form:form action="/home"  method="post" modelAttribute="staffList">
	<center>
			<table>
				<tr>
					<td>
						<form:label path="staffID">Staff ID</form:label>
					</td>
					<td>
						<form:input path="staffID" id="staffID" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="pwd">Password</form:label>
					</td>
					<td>
						<form:input path="pwd" id="pwd" name="pwd" />
					</td>
				</tr>
				
				<tr>
					<td>
						<form:input type="submit" name="login" value="login" path="home"/>
					</td>
					
				</tr>
			</table>
		</center>	
	</form:form>

</body>
</html>