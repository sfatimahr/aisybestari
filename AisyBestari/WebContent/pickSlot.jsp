<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
	.search_categories{
  font-size: 20px;
  padding: 10px 8px 10px 14px;
  background: #fff;
  border: 1px solid #ccc;
  border-radius: 6px;
  position: relative;
  width: 120%;

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
	
	<section class="blog section-padding">
      	<div class="container">
      		<div class="row">
      			<div class="col-lg-12 col-12 py-5 mt-5 mb-3 text-center">
		        	<h1 class="mb-4" data-aos="fade-up"><strong>Choose which slot you would like to enroll in!</strong></h1><br><br>
		        </div>
		       
		       
		       <div class="col-lg-8 mx-auto col-md-10 col-12">
		       	<form id="pickSlot" name="pickSlot" action="Enroll_SubjectController?action=enroll" method="post" class="contact-form" data-aos="fade-up" data-aos-delay="300" role="form">
		        	<div class="row">		        
                        
                        <select name="subjectId" class="search_categories">
							<option value="">Select Subject</option>
							<c:forEach var="subject" items="${subjects}">
								<option value="${subject.subjectId}">${subject.subjectName} ${subject.lvl}</option>
							</c:forEach>
						</select>
						<br><br>
                       
                       <select name="slotId" class="search_categories">
							<option value="">Select Slot</option>
							<c:forEach var="slot" items="${slots}">
								<option value="${slot.slotId}">${slot.subjectName}  ${slot.lvl} - ${slot.slotDay} - ${slot.slotTime} - RM${slot.fee}</option>
							</c:forEach>
						</select>
                       
                        <div class="col-lg-5 mx-auto col-7">
                        <br><br>
                          	<button type="submit" class="form-control" id="submit-button" name="submit" >Enroll</button>
                        </div>
				       
		        	</div>				
				</form>
			</div>
      		</div>
      	</div>
      </section>


	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	<script src="js/aos.js" type="text/javascript"></script>
	<script src="js/owl.carousel.min.js" type="text/javascript"></script>
	<script src="js/custom.js" type="text/javascript"></script>


</body>
</html>
