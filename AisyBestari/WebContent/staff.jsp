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
                    <li class="nav-item">
                        <a href="index.jsp" class="nav-link">Home</a>
                    </li>
                    <li class="nav-item">
                        <a href="registerStudent.jsp" class="nav-link active contact">Register New Student</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>


     <!-- CONTACT -->
     <section class="contact section-padding">
          <div class="container">
               <div class="row">

                    <div class="col-lg-6 mx-auto col-md-7 col-12 py-5 mt-5 text-center" data-aos="fade-up">

                      <h1 class="mb-4">Hey there, welcome back to <strong>Aisy Bestari Tuition Center</strong></h1>

                      <p>or email us at <a href="mailto:hello@company.com">hello@company.com</a></p>
                      <p>Please follow our <a rel="nofollow" href="https://templatemo.com/contact">contact page</a> to <strong>setup</strong> the contact form.</p>
                    </div>

                    <div class="col-lg-8 mx-auto col-md-10 col-12">
                    
                    <!-- Follow https://templatemo.com/contact page to setup your own contact form -->
                    
                    <c:if test="${param.message != null }">
					<p style="color:red;">${param.message}</p>
					</c:if>
                    
                    
                    
                      <form action="<%=request.getContextPath()%>/StaffController" method="post" class="contact-form" data-aos="fade-up" data-aos-delay="300" role="form">
                        <div class="row">
                        
                        
                          <div class="col-lg-6 col-12">
                            <input type="text" class="form-control" name="staffUser" placeholder="Username">
                          </div>

                          <div class="col-lg-6 col-12">
                            <input type="password" class="form-control" name="staffPassword" placeholder="Password">
                          </div>
                          
                          <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
                      
                          <div class="col-lg-12 mx-auto col-7">
                       
                          	<button type="submit" class="form-control" id="submit-button" value="Login" name="submit" >LOGIN</button>
                           <!-- <button type="button" onclick="location.href='staffManagerLogin.jsp'" class="form-control" id="submit-button" name="submit" value="Login">Log In</button>
                           --> 
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