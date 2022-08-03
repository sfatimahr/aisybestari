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
<body>

      <nav class="navbar navbar-expand-lg position-absolute">
          <div class="container">
              <a class="navbar-brand" href="index.jsp">
                <i class="fa fa-line-chart"></i>
                Aisy Bestari Tuition Center
              </a>

              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

               <div class="collapse navbar-collapse" id="navbarNav">
                  <ul class="navbar-nav ml-auto">
                      <li class="nav-item">
                          <a href="myAccount.jsp" class="nav-link smoothScroll">Home</a>
                      </li>
                      <li class="nav-item">
                          <a href="index.jsp" class="nav-link contact">Log out</a>
                      </li>
                      <li class="nav-item">
                        <a href="LogoutController" class="nav-link contact">Logout</a>
             	      </li>
                      </ul>
              </div>
          </div>
      </nav>

		<section class="blog section-padding">
		  <div class="container">
		    <div class="row">
		      
		      <div class="col-lg-12 col-12 py-5 mt-5 mb-3 text-center">
		        <h1 class="mb-4" data-aos="fade-up">Welcome to Aisy Bestari<br> <strong>Choose which level syllabus to enroll in</strong></h1><br><br>
		        
		         <form action="#" method="post" class="contact-form" data-aos="fade-up" data-aos-delay="300" role="form">
			      <div class="row">
			      	<div class="col-lg-6 mx-auto col-12">
				         <button type="button" onclick="location.href='pickSlot.jsp'" class="form-control" id="submit-button" name="form1">Form 1</button>
				    </div>
				    <div class="col-lg-6 mx-auto col-12">
				         <button type="button" onclick="location.href='pickSlot.jsp'" class="form-control" id="submit-button" name="form2">Form 2</button>
				    </div> 
				    <div class="col-lg-6 mx-auto col-12">
				         <button type="button" onclick="location.href='pickSlot.jsp'" class="form-control" id="submit-button" name="form3">Form 3</button>
				    </div>    
				    <div class="col-lg-6 mx-auto col-12">
				         <button type="button" onclick="location.href='pickSlot.jsp'" class="form-control" id="submit-button" name="form4">Form 4</button>
				    </div>     
				    <div class="col-lg-6 mx-auto col-12">
				         <button type="button" onclick="location.href='pickSlot.jsp'" class="form-control" id="submit-button" name="form5">Form 5</button>
				    </div>
			      </div>			     
		        </form>
		     </div>
		     
		     
		
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
