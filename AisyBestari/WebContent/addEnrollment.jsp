<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
  <title>Aisy Bestari - Student</title>
  
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
  <link rel="stylesheet" type="text/css" href="css/tr.css">
  <link rel="stylesheet" type="text/css" href="css/subjects.css">
  <link rel="stylesheet" type="text/css" href="css/dropdowns.css">

  <link rel="stylesheet" href="css/templatemo-digital-trend.css">
</head>
<body>

      <nav class="navbar navbar-expand-lg position-absolute">
          <div class="container">
              <a class="navbar-brand" href="main.html">
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
                        <a href="index.jsp" class="nav-link">Home</a>
                    </li>
                    <li class="nav-item">
                        <a href="registerStudent.jsp" class="nav-link active contact">Register</a>
                    </li>
                </ul>
            </div>
          </div>
      </nav>

	<section class="contact section-padding">
          <div class="container">
               <div class="row">
               		<div class="col-lg-6 mx-auto col-md-7 col-12 py-5 mt-5 text-center" data-aos="fade-up">
                      <h1 class="mb-4"><strong>You have registered with Aisy Bestari! Continue with your registration wtih signing in!</strong></h1>                      
                    </div>
                    <div class="col-lg-8 mx-auto col-md-10 col-12">
                    	<form id="regEnrollmentForm" name="regEnrollmentForm" action="EnrollmentController" method="post" class="contact-form" data-aos="fade-up" data-aos-delay="300" role="form">
							<button type="submit" class="form-control" id="submit-button" name="submit" >Continue</button>
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

