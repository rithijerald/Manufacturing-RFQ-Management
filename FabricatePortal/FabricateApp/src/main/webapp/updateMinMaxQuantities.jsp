<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="/Styles/supplierPage.css" type="text/css" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body class="bg-2">

	<div >
		<div class="container">
			<div class="row mt-3">
				<div class="col-12">
					<div class="row ">
						<div class="col-6">
							<h5 class="breadcrumb-item active mt-5">UPDATE MINIMUM AND
								MAXIMUM RULES</h5>
						</div>

					</div>
				</div>
				</div>
				<div class="h-line ml-1 mb-4 mt-2"></div>
			
			<c:forEach var="i" items="${Reorder}">
			<form:form modelAttribute = "reorderrules" action= "updateMinMaxQuantities" method="post">
				
				<div class="row mt-5">
					<div class="col">
					<label>Part Id</label>
						<input class="form-control"type="number" name="partid" value="${i.getPartId()}" readonly>
					</div>
					<div class="col">
					<label>Demand Id</label>
						<input class="form-control" type="number" name="demandid" value="${i.getDemandId()}" readonly>
					</div>
					<div class="col">
					<label>Min. Quantity</label>
						<input class="form-control" type="number" name="min" value="${i.getMinQuantity()}">
					</div>
					<div class="col">
					<label>Max. Quantity</label>
						<input class="form-control" type="number" name="max" value="${i.getMaxQuantity()}">
					</div>
					<div class="col">
					<label>Reorder Frequency</label>
						<input class="form-control" type="number" name="freq" value="${i.getReorderFrequency()}" readonly>
					</div>
					</div>
				<div class="col d-flex justify-content-center mt-5">
						<input  type="submit" class="btn" value="Update"/>

					</div>
			</form:form>
			</c:forEach>
		</div>
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>