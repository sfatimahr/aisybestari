<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Aisy Bestari - Staff</title>
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


	<!-- PROJECT DETAIL -->
	<section class="project-detail section-padding-half">
		<div class="container">
			<div class="row">

				<div class="col-lg-9 mx-auto col-md-10 col-12 mt-lg-5 text-center">

					<h1>
						<br><br><strong>List of Students</strong>
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
							<th>Student ID</th>
							<th>Student Name</th>
							<th>Age</th>
							<th>Home Address</th>
							<th>Phone Number</th>
							<th>Email Address</th>
							<th></th>
							<th>Edit</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${students}" var="student">
							<tr>
								<td><c:out value="${student.studId}" /></td>
								<td><c:out value="${student.studName}" /></td>
								<td><c:out value="${student.age}" /></td>
								<td><c:out value="${student.address}" /></td>
								<td><c:out value="${student.contact}" /></td>
								<td><c:out value="${student.email}" /></td>
								<td>
				                	<a href="/AisyBestari/StudentController?action=viewStudent&id=<c:out value="${student.studId}" />" align="center" class="form-control">view</a>
				                </td>
				                <td>
				                  	<a href="/AisyBestari/StudentController?action=updateStudent&id=<c:out value="${student.studId}" />" align="center" class="form-control"> update</a>
				                </td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<hr>
				<div align="center">
					<a href="registerStudent.jsp" class="form-control"> add new student </a>
				</div>
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