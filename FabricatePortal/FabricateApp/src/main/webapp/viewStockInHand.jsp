<%@ include file="header.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link rel="stylesheet" href="/Styles/supplierPage.css" type="text/css" />
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
<!DOCTYPE html>
<html>

<body class="bg-2">




	<section>


		<div>
			<div class="container">
				<div class="row ">
					<div class="col-12">
						<div class="row">
							<div class="col-6">
								<h5 class="breadcrumb-item active mt-5">STOCK DETAILS</h5>
							</div>

						</div>
					</div>

				</div>
				<div class="h-line ml-1 mb-4 mt-2"></div>

				<div class="row mt-4">

					<div class="col">
						<label>Part id</label> <input type="number" name="sname"
							class="form-control" disabled="disabled"
							value="${stocks.getPartId()}">
					</div>
					<div class="col">
						<label>Part Description</label> <input type="text"
							name="slocation" class="form-control" disabled="disabled"
							value="${stocks.getPartDescription()}">
					</div>
					<div class="col"></div>

				</div>
				<div class="row mt-4">
					<div class="col">
						<label>Part
							Specification&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input
							type="text" name="partid" class="form-control"
							disabled="disabled" value="${stocks.getPartSpecification()}">
					</div>
					<div class="col">
						<label>Stock Count</label> <input type="text" name="partname"
							class="form-control" disabled="disabled"
							value="${stocks.getStockInHand()}">
					</div>
					<div class="col"></div>
					<div class="col"></div>


				</div>


			</div>

		</div>

	</section>

<%@ include file="footer.jsp" %>


</body>
</html>