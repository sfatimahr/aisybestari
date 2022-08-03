<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<html lang="en">
<head>


<!--

DIGITAL TREND

https://templatemo.com/tm-538-digital-trend

-->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/aos.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" type="text/css" href="css/try.css">

<!-- MAIN CSS -->
<link rel="stylesheet" href="css/templatemo-digital-trend.css">

</head>
<body>

	<!-- MENU BAR -->
	<nav class="navbar navbar-expand-lg position-relative">
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
					<li class="nav-item"><a href="index.jsp" class="nav-link smoothScroll">Home</a></li>
					<li class="nav-item"><a href="/AisyBestari/SubjectController?action=listSubject" class="nav-link">Subjects</a></li>
					<li class="nav-item"><a href="/AisyBestari/StudentController?action=listStudent" class="nav-link">Students</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>


	<!-- PROJECT DETAIL -->
	<section class="project-detail section-padding-half">
		<div class="container">
			<div class="row">

				<div class="col-lg-9 mx-auto col-md-10 col-12 mt-lg-5 text-center">

					<h1>
						<strong>List of Staffs</strong>
					</h1>

				</div>

			</div>
		</div>
	</section>

	<section>
		<div class="card-body p-5">

			<!--  Bootstrap table-->
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
						<th>ID</th>
							<th>Username</th>
							<th>Password</th>
							<th>Role</th>
							<th>Manager ID</th>
							<th>Status </th>
							<th>Edit</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${staffs}" var="staff">
							<tr>
							<td><c:out value="${staff.staffId}" /></td>
								<td><c:out value="${staff.staffUser}" /></td>
								<td><c:out value="${staff.staffPassword}" /></td>
								<td><c:out value="${staff.staffRole}" /></td>
								<td><c:out value="${staff.managerId}" /></td>
								<td><c:out value="${staff.status}" /></td>
								<td>
				                	<a href="/AisyBestari/StaffController?action=viewStaff&id=<c:out value="${staff.staffId}" />"align="center" class="form-control"> view</a>
				                	</td>
				                	<td>
				                <a href="/AisyBestari/StaffController?action=deleteStaff&id=<c:out value="${staff.staffId}" />" align="center" class="form-control" onclick="return confirm('Are you sure you want to delete this item')"> delete </a>
				                	</td>
				                	<td>
				                	<a href="/AisyBestari/StaffController?action=updateStaff&id=<c:out value="${staff.staffId}" />"align="center" class="form-control"> update</a>
				               </td>
				                
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>

	<!-- SCRIPTS -->
	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/aos.js" type="text/javascript"></script>
	<script src="js/owl.carousel.min.js" type="text/javascript"></script>
	<script src="js/custom.js" type="text/javascript"></script>
	<script src="js/tabletimes2.js" type="text/javascript"></script>

</body>
</html>