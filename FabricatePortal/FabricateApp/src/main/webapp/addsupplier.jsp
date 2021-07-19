<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<link rel="stylesheet" href="/Styles/supplierPage.css" type="text/css" />
	

	
<body class="bg-2">
<div id="layoutAuthentication ">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
				<div class="row mt-5 mb-5">
				<div class="col-12">
							<div class="row ">
								<div class="col-6">
									<h5 class="breadcrumb-item active">ADD NEW SUPPLIER</h5>
								</div>
								
							</div>
						</div>
				<div class="h-line ml-1"></div>
			</div>
			<form:form modelAttribute = "supplierAndParts" action= "addSupplier" method="post">
				
				<div class="row mt-5">
					<div class="col">
					<label>SupplierName</label>
						<input class="form-control"type="text" name="name" required>
					</div>
					<div class="col">
					<label>E-mail</label>
						<input class="form-control" type="email" name="email" required>
					</div>
					<div class="col">
					<label>Phone No.</label>
						<input class="form-control" type="text" name="phone" required>
					</div>
					<div class="col">
					<label>Location</label>
						<input class="form-control" type="text"   name="location" required>
					</div>
					<div class="col">
					<label>Feedback</label>
						<input class="form-control" type="number" name="feedback" required>
					</div>
					</div>
				<div class="col d-flex justify-content-center mt-5">
						<input  type="submit" class="btn" value="Add supplier"/>

					</div>
			</form:form>
		
				</div>
				
				</main>
		</div>
		
	</div>
				

</body>
