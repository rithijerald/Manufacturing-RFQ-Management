<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Supplier</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container" styple="margin-top: 20px">
		<h4>Enter Supplier Details</h4>
		<form action="/addsupplier">
			<div class="row">
				<div class="col-md-6">
					<label class="form-label">Supplier Name</label> <input type="text"
						name="name" class="form-control" id="name" required />
				</div>
				<div class="col-md-6">
					<label class="form-label">E-mail</label> <input type="email"
						name="email" class="form-control" id="name" required />
				</div>
			</div>
			<div class="row" style="margin-top: 20px">
				<div class="col-md-4">
					<label class="form-label">Mobile Number</label> <input type="text"
						name="phone" class="form-control" id="phone" required />

				</div>
				<div class="col-md-4">
					<label class="form-label">Location</label> <input type="text"
						name="location" class="form-control" id="location" required />
				</div>
				<div class="col-md-4">
					<label class="form-label">Feedback</label> <input type="text"
						name="feedback" class="form-control" id="feedback" required />
				</div>
			</div>
			<button style="margin-top: 20px" type="submit" class="btn btn-primary">Add Details</button>

		</form>



	</div>












	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>