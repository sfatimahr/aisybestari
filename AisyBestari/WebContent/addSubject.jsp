	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>

<title>Welcome to Aisy Bestari</title>
<link rel="icon" href="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fumbrellalegalmarketing.com%2Fwp-content%2Fuploads%2F2015%2F10%2Fab-logo-2.png&f=1&nofb=1">
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

<!-- MAIN CSS -->
<link rel="stylesheet" href="css/templatemo-digital-trend.css">

</head>
<body>

	<!-- MENU BAR -->
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
                    <li class="nav-item">
                        <a href="staffManagerLogin.jsp" class="nav-link">Home</a>
                    </li>
                    <li class="nav-item">
                        <a href="manageSubject.jsp" class="nav-link">Subject</a>
                    </li>
                    <li class="nav-item">
                        <a href="manageStudent.jsp" class="nav-link">Student</a>
                    </li>
                    <li class="nav-item">
                        <a href="manageSlot.jsp" class="nav-link">Slot</a>
                    </li>
                    <li class="nav-item">
                        <a href="registerStudent.jsp" class="nav-link active contact">New Student</a>
                    </li>
                </ul>
            </div>
		</div>
	</nav>

	<section class="project-detail section-padding-half">
		<div class="container">
			<div class="row">

				<div class="col-lg-9 mx-auto col-md-5 col-6 mt-lg-5 text-center"
					data-aos="fade-up">

					<h1>
						<strong>Add new Course</strong>
					</h1>

				</div>

			</div>
		</div>
	</section>

	<!-- update subject -->
	<section class="contact section-padding">
		<div class="container">
			<div class="row">

				<div class="col-lg-8 mx-auto col-md-5 col-12">

					<form id="addSubForm" name="addSubForm" action="SubjectController" method="post" class="contact-form" data-aos="fade-up" data-aos-delay="300" role="form">
						<div class="row">

							<div class="col-lg-6 col-12">							
								<input type="text" class="form-control" id="subjectName" name="subjectName" placeholder="Name" required="required">
							</div>

							<div class="col-lg-6 col-12">
								<input type="text" class="form-control" id="lvl" name="lvl" placeholder="Level" required="required">
							</div>

							<div class="col-lg-6 col-12">
								<input type="text" class="form-control" id="fee" name="fee" placeholder="Fee" required="required">
							</div>

							<div class="col-lg-5 mx-auto col-7">
								<button type="submit" class="form-control" id="submit-button" name="submit">Add</button>							
							</div>

						</div>

					</form>
						
				</div>

			</div>
		</div>
	</section>

	<!-- SCRIPTS -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/custom.js"></script>

</body>
</html>