<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
    <link rel="stylesheet" href="/Styles/plantPage.css" type="text/css"/>
   

<body class="bg_home-2">
	
	<!-- 
	<form><input type="submit" value="Plant" /></form>
	<form action="supplier" method="get"><input type="submit" value="Supplier" /></form>
	<form><input type="submit" value="Rfq" /></form> -->
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
	
	<section>
	<div class="row margin">
	

		<div class="col-12">
		
        <div class="container ">
            <div class="row mt-4">
                <div class="col-4">
                    <div class="shadow-lg">
                          
                        <div class="card-body d-flex justify-content-center">
                           
                            <form action="viewStockInHand"> 
                            <label class="label">Enter PartId to View Stocks</label>
                            <div class="row mt-4">
                            <input type="number" name="partid" class="form-control" required >
                           	</div>
                           	<div class="row mt-4">
                            <button type="submit" class="btn">View Stocks</button>
                            </div>
                            </form>
                            
                        </div>

                    </div>
                </div>
         
                <div class="col-4">
                    <div class="shadow-lg">
                        <div class="card-body d-flex justify-content-center">
                            <a href="/viewPartsReOrder" class="btn" >View Parts Reorder</a>
                        </div>

                    </div>
                </div>
                <div class="col-4">
                    <div class="shadow-lg">
                        <div class="card-body d-flex justify-content-center">
                            <a href="/updateMinMaxQuantities" class="btn" >Update Minimum and Maximum Quantities</a>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        </div>
        </div>
    </section>
    </div>
    </div>
    
</body>
