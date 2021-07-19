<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link rel="stylesheet" href="/Styles/rfq.css" type="text/css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body class="bg-img">


	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-6">

							<div class="card shadow-sm border-0 rounded-lg mt-5">
								<div class="card-body">
									<form action="getRFQOfPlant" method="get">
										<div class="form-group row gap">
											<label class="col-5  fsize">Enter the Plant Id :</label>
											<div class="col-6 ">
												<input type="number" name="plantid" class="form-control"
													required>
											</div>
										</div>

										<div class="col d-flex justify-content-center mt-5">
											<input type="submit" class="btn" value="Get RFQ of Plant" />

										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="col-6">
							<div class="card shadow-sm border-0 rounded-lg mt-5">
								<div class="card-body">
									<form action="getPotentialVendorsOfRFQ" method="get">
										<div class="form-group row gap">
											<label class="col-sm-6 control-label style fsize">Enter the
												RFQ Id :</label>
											<div class="col-sm-6 ">
												<input type="number" name="rfqid" class="form-control"
													required>
											</div>
										</div>

										<div class="col d-flex justify-content-center mt-5">
											<input type="submit" value="Get Potential vendors of RFQ"
												class="btn" />

										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</main>
		</div>
	</div>





</body>
</html>