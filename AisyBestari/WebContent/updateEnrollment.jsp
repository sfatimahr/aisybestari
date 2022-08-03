<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
   
<!DOCTYPE html>
<html lang="en">
<head>

     <title>Welcome to Aisy Bestari</title>
<!--

DIGITAL TREND

https://templatemo.com/tm-538-digital-trend

-->
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

     <!-- MAIN CSS -->
     <link rel="stylesheet" href="css/templatemo-digital-trend.css">

</head>
<body>

     <!-- MENU BAR -->
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
					<li class="nav-item"><a href="index.jsp" class="nav-link smoothScroll">Home</a></li>
					<li class="nav-item"><a href="/AisyBestari/SubjectController?action=listSubject" class="nav-link">Subjects</a></li>
					<li class="nav-item"><a href="/AisyBestari/StudentController?action=listStudent" class="nav-link">Students</a>
					</li>
				</ul>
			</div>
        </div>
    </nav>


     <!-- update student -->
     <section class="contact section-padding">
          <div class="container">
               <div class="row">
               	
                    <div class="col-lg-8 mx-auto col-md-10 col-12">
                                      
                      <form id="upEnrollForm" name="upEnrollForm" action="EnrollmentController" method="post" class="contact-form" data-aos="fade-up" data-aos-delay="300" role="form">
                        <div class="row">

                          <div class="col-lg-12 col-12">
                          	<label for="enrollId">Enrollment Id : </label><br> 
                            <input type="text" class="form-control" name="enrollId" id="enrollId" value="<c:out value="${enrollment.enrollId}" />" readonly/>
                          </div>
                          
                          <div class="col-lg-6 col-12">
                          	<label for="studName">Student : </label><br> 
                            <input type="text" class="form-control" name="studName" id="studName" value="<c:out value="${enrollment.studName}" />"readonly/><br>
                          </div>

                          <div class="col-lg-6 col-12">
                          	<label for="enrollDate">Data Enrolled : </label><br> 
                            <input type="text" class="form-control" name="enrollDate" id="enrollDate" value="<c:out value="${enrollment.enrollDate}" />"readonly/><br>
                          </div>

                          <div class="col-lg-12 col-12">
                          	<label for="enrollStatus">Status : </label><br> 
                            <input type="text" class="form-control" name="enrollStatus" id="enrollStatus" value="<c:out value="${enrollment.enrollStatus}" />"/><br>
                          </div>

						  <div class="col-lg-6 col-12">
						  	<label for="staffId">Staff in Charge : </label><br> 
						  	<input type="text" class="form-control" name="staffId" id="staffId" value="<c:out value="${enrollment.staffId}" />"/><br>
						  </div>
                          
                          <div class="col-lg-6 col-12">
                          	<label for="totalPayment">Total Payment : </label><br> 
                            <input type="text" class="form-control" name="totalPayment" id="totalPayment" value="<c:out value="${enrollment.totalPayment}" />"/><br>
                          </div>
		
                          <div class="col-lg-5 mx-auto col-7">
                          	<button type="submit" class="form-control" id="submit-button" value="submit">Update</button>
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