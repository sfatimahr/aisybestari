<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enroll</title>
</head>
<body>
	
	<h1>Add Enrollment</h1>

	<form id="regEnrollmentForm" name="regEnrollmentForm" method="post" action="EnrollmentController">
	
		<!--<label for="date">Enrollment Date:</label><br>        
        <input type="date" id="enrollDate" name="enrollDate" required="required"><br> -->
        
        <!-- <label for="status">Enrollment Status:</label><br>        
        <input type="text" id="enrollStatus" name="enrollStatus" required="required"><br>  -->
        

		<input type="radio" name="status" value="ACTIVE" checked> Active
		<input type="radio" name="status" value="NOTACTIVE"> Not Active <br>
        
        
        <label for="student">Student:</label><br>        
        <input type="text" id="studentId" name="studentId" readonly><br>
        
        <select name="student">
					<option value="">Select Student</option>
					<c:forEach var="student" items="${students}">
						<option value="${student.studId}">${student.studName} </option>
					</c:forEach>
		</select><br>
		
        <select name="staff">
					<option value="">Select Staff</option>
					<c:forEach var="staff" items="${staff}">
						<option value="${staff.staffId}">${staff.staffUser}</option>
					</c:forEach>
		</select><br>
        
        <!-- <label for="staff">Staff:</label><br>        
        <input type="text" id="staffId" name="staffId"><br> -->
        
        <label for="totalPayment">Total Payment:</label><br>        
        <input type="text" id="totalPayment" name="totalPayment" required="required"><br><br>
        
  		<input type="submit" value="Submit"><br><br>
  		
  		<br/><a href="index.jsp">Back Home</a><br/><br/><br/>
	
	</form>
	
	<br/><a href="/AisyBestari/EnrollmentController?action=listEnrollment">View Slot List</a><br/>

</body>
</html> --%>


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
                          <a href="main.html" class="nav-link">About</a>
                      </li>
                      <li class="nav-item">
                          <a href="main.html#project" class="nav-link">Subject</a>
                      </li>
                      <li class="nav-item">
                          <a href="main.html#testimonial" class="nav-link">Instructors</a>
                      </li>
                      <li class="nav-item">
                          <a href="student-page.html#testimonial" class="nav-link">My Courses</a>
                      </li>
                      </ul>
              </div>
          </div>
      </nav>

	<section class="contact section-padding">
          <div class="container">
               <div class="row">
               		<div class="col-lg-6 mx-auto col-md-7 col-12 py-5 mt-5 text-center" data-aos="fade-up">
                      <h1 class="mb-4"><strong>Enroll!</strong></h1>                      
                    </div>
                    <div class="col-lg-8 mx-auto col-md-10 col-12">
                    	<form id="regEnrollmentForm" name="regEnrollmentForm" action="EnrollmentController" method="post" class="contact-form" data-aos="fade-up" data-aos-delay="300" role="form">
	                    	<!-- <input type="radio" id="enrollStatus" name="enrollStatus" value="ACTIVE" checked> Active
							<input type="radio" id="enrollStatus" name="enrollStatus" value="NOTACTIVE"> Not Active <br><br>	 -->
							
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

