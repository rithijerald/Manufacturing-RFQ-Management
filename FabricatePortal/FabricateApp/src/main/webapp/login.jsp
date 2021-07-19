<html>
<head>
<link rel="stylesheet" href="/Styles/login.css" type="text/css">
<link rel="stylesheet" href="/Styles/footer.css" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">


</head>
<body>
	<section>
		<div class="container">



			<div class="row">
				<div class="offset-1 col-4 bg_login-1">
					<div class="card-body">
						<div>
							<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBwMesW4ejDrwDkwkgOUCa2eJ3XbsgMLs_cg&usqp=CAU"
								style="height: 263px; padding-left: 20px;">
						</div>
						<div class="login text-center">
							<h4 class="login-h4">Team Anonymous</h4>
							<p class="login-p" style="line-height: normal;">Potential suppliers on the way</p>
						</div>
					</div>
				</div>
				<div class="col-6 bg_login-2">
					<div class="reg text-center">
						<h4 class="reg-h4 col-8 offset-1">LOGIN</h4>
						
						<div class="row  mt-4 mb-3">
							<form action="auth" class="col-8 offset-1" method="get">
								<div class="form-group  mt-3 mb-3">
							
									<input type="text" class="form-control uicon"
										placeholder="&#61447; User Name" name="userid">
								</div>
								<div class="form-group  mt- mb-4">
									<input type="password" class="form-control uicon"
										placeholder="&#61475; Password" name="password">
								</div>

								<input type="submit" value="login" class="btn-login btn">
								<br><br><div class="in">
								${invalid}</div>
								
							</form>
							
							
						</div>
					</div>
				</div>
			</div>
		
	</section>
		
		

</body>
</html>