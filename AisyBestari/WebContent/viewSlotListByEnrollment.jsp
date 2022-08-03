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
     
     <section class="blog section-padding">
               <div class="row">

                    <div class="col-lg-12 col-12 py-5 mt-5 mb-3 text-center">
                    
                    <h1 class="mb-4"><b>Enrollments in this slot</b></h1>
                      
						<br><b>Slot Id : </b> <c:out value="${slot.slotId}" />
						<br><b>Time : </b> <c:out value="${slot.slotTime}" />
						<br><b>Day : </b> <c:out value="${slot.slotDay}" />
						<br><b>Seats : </b> <c:out value="${slot.slotSeat}" />
						<br><b>Subject : </b> <c:out value="${slot.subjectName}" />
						<br><br>
						
						<a href="/AisyBestari/SlotController?action=listSlot">Back</a>
						
						<hr>
						
					    <div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th scope="col">Enrollment Id</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${slot.enroll_subjects}" var="Enroll_Subject">
								       	<tr>
								       		<td><c:out value="${enroll_subject.enrollId}"/></td>  
								   		</tr>
					        		</c:forEach>      
								</tbody>
							</table>				
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
