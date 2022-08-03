<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@ page import="aisybestari.dao.SlotDAO"%>
<%@ page import="aisybestari.model.*"%>
<%@ page import="aisybestari.connection.ConnectionManager"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("confirmSlot");
	List<Cart> cartProduct = null;
	if (cart_list != null) {
		SlotDAO slots = new SlotDAO(ConnectionManager.getConnection());
		cartProduct = slots.getCartSlots(cart_list);
		request.setAttribute("cart_list", cart_list);
	}
%>
<!DOCTYPE html>
<html>
<head>
	<title>Aisy Bestari - Student</title>
	
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="description" content="">
	<meta name="keywords" content="">
	<meta name="author" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/aos.css">
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">
	<link rel="stylesheet" type="text/css" href="css/try.css">
	<link rel="stylesheet" type="text/css" href="css/table.css">
	
	<link href="css/font-face.css" rel="stylesheet" media="all">
	<link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
	<link href="vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
	<link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
	
	<!-- Bootstrap CSS-->
	<link href="vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">
	
	<!-- Vendor CSS-->
	<link href="vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
	<link href="vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
	<link href="vendor/wow/animate.css" rel="stylesheet" media="all">
	<link href="vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
	<link href="vendor/slick/slick.css" rel="stylesheet" media="all">
	<link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
	<link href="vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">
	
	<!-- Main CSS-->
	<link href="css/theme.css" rel="stylesheet" media="all">
	
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="css/templatemo-digital-trend.css">
</head>
<style>
	.table {
		counter-reset: serial-number; /* Set the serial number counter to 0 */
	}
	.table td:first-child:before {
        counter-increment: serial-number; /* Increment the serial number counter */
        content: counter(serial-number); /* Display the counter */
    }
</style>
<body>

      <nav class="navbar navbar-expand-lg position-absolute">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"> <i
				class="fa fa-line-chart"></i> Aisy Bestari Tuition Center
			</a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="StudentController/MY_ACC"
						class="nav-link smoothScroll">Home</a></li>
					<li class="nav-item"><a href="LogoutController"
						class="nav-link contact">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
      
      <section class="project-detail section-padding-half">
		<div class="container">
			<div class="row">
				<div class="col-lg-9 mx-auto col-md-10 col-12 mt-lg-5 text-center">
					<h1><br>Enroll classes</h1>
				</div>
			</div>
		</div>
	</section>
	
      <section>
		<div class="card-body p-5">
			<div class="table-responsive">
			<div class="d-flex py-3"><h3>Total Price: RM ${(total>0)?dcf.format(total):0} </h3> <a class="mx-3 btn btn-primary" href="cart-check-out">Enroll all Classes</a></div>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">No.</th>
							<th scope="col">Subject</th>
							<th scope="col">Day</th>
							<th scope="col">Time</th>
							<th scope="col">Level</th>
							<th scope="col">Fee</th>
							<th scope="col">Cancel</th>
						</tr>
					</thead>
					<tbody>
						<%
						if (cart_list != null) {
							for (Cart c : cartProduct) {
						%>
						<tr>
							<td></td>
							<td><%=c.getSubjectName()%></td>
							<td><%=c.getSlotDay()%></td>
							<td><%=c.getSlotTime()%></td>
							<td><%=c.getLvl()%></td>
							<td><%=c.getFee()%></td>
							<td>Remove</td>
						</tr>
						<%
						}}%>
					</tbody>
				</table>
			</div>	
      	</div>
      </section>

	
    <script src="js/jquery.min.js"></script>
     <script src="js/bootstrap.min.js"></script>
     <script src="js/aos.js"></script>
     <script src="js/owl.carousel.min.js"></script>
     <script src="js/custom.js"></script>


</body>
</html>
