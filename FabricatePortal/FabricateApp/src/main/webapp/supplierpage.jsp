<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link rel="stylesheet" href="/Styles/supplierPage.css" type="text/css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manufacturing RFQ Management</title>

</head>
<body class="bg-2">


	<div id="layoutAuthentication ">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container ">
					<div class="row">
						<div class="col-12">
							<div class="row">
								<div class="col-6">
									<h5 class="breadcrumb-item active">LIST OF SUPPLIER</h5>
								</div>
								<div class="col-6 add-sup ">
									<a href="/addsupplier" class="btn">ADD NEW SUPPLIER</a>
								</div>
							</div>
						</div>

					</div>
					<div class="h-line ml-1 mb-4 mt-2"></div>


					<c:forEach var="i" items="${supplierList}">


						<form action="ep" method="get">




							<div class="d-flex justify-content-between  hdr-sup mb-4 mt-5">
								<div>
									<h5 class="breadcrumb-item active abc">SUPPLIER
										${i.getSupplierId()}</h5>
								</div>

								<div class=" add-sup ">
									<input type="submit" name="submit" value="Update Feedback"
										class="btn">
								</div>
								<div class=" add-sup ">
									<input type="submit" name="submit" value="Edit"
										class="btn">
								</div>

							</div>

							<div class="row mt-4">
								<div class="col">
									<label>Supplier ID</label> <input type="number" name="sid"
										class="form-control cool" value="${i.getSupplierId()}"
										readonly>
								</div>
								<div class="col">
									<label>Supplier Name</label> <input type="text" name="sname"
										class="form-control" value="${i.getName()}"
										readonly>
								</div>
								<div class="col">
									<label>E-mail</label> <input type="text" name="email"
										class="form-control" value="${i.getEmail()}"
										readonly>
								</div>
								<div class="col">
									<label>Phone No.</label> <input type="text" name="phone"
										class="form-control" value="${i.getPhone()}"
										readonly>
								</div>
								<div class="col">
									<label>Location</label> <input type="text"
										name="slocation" class="form-control"
										value="${i.getLocation()}" readonly>

								</div>
								<div class="col">
									<label>Feedback</label> <input type="number"
										name="sfeedback" class="form-control"
										value="${i.getFeedback()}" readonly>
								</div>
							</div>
						</form>
					</c:forEach>
				</div>
			</main>
		</div>
	</div>




</body>
</html>