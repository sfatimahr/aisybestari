<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@page import="aisybestari.model.*" %> 
<%@page import="java.util.*" %> 

<!DOCTYPE html>
<html lang="en">
<head>

     <title>Welcome to Aisy Bestari</title>
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
        var subcategory = {
            STAFF: ["SITI", "MARIAM", "WAHID", "LILY"],
            MANAGER: ["NULL"]
        }

        function makeSubmenu(value) {
            if (value.length == 0) document.getElementById("managerId").innerHTML = "<option></option>";
            else {
                var citiesOptions = "";
                for (categoryId in subcategory[value]) {
                    citiesOptions += "<option>" + subcategory[value][categoryId] + "</option>";
                }
                document.getElementById("managerId").innerHTML = citiesOptions;
            }
        }

        function displaySelected() {
            var country = document.getElementById("staffRole").value;
            var city = document.getElementById("managerId").value;
            alert(country + "\n" + city);
        }

        function resetSelection() {
            document.getElementById("staffRole").selectedIndex = 0;
            document.getElementById("managerId").selectedIndex = 0;
        }
   
   
 

function yesnoCheck() {
    if (document.getElementById('status').checked) {
        document.getElementById('ifYes').style.visibility = 'visible';
    }
    else document.getElementById('ifYes').style.visibility = 'hidden';

}

</script>
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
<body onload="resetSelection()">

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
                        <a href="index.jsp" class="nav-link">About</a>
                    </li>
                    <li class="nav-item">
                        <a href="index.jsp#project" class="nav-link">Subject</a>
                    </li>
                    <li class="nav-item">
                        <a href="index.jsp#testimonial" class="nav-link">Instructors</a>
                    </li>
                    <li class="nav-item">
                        <a href="login.jsp" class="nav-link active contact">Sign In</a>
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

                      <h1 class="mb-4">Hey there! Welcome to <strong>Aisy Bestari Tuition Centre</strong></h1>

                      <p>Follow us on our academic journey</p>
                      <p>Friendly teachers and the guarantee of graduating your year with flying colours!</p>
                    </div>

                    <div class="col-lg-8 mx-auto col-md-10 col-12">
                    
                    <!-- Follow https://templatemo.com/contact page to setup your own contact form -->
                    
                      <form id="regStaffForm" name="regStaffForm" action="StaffController" method="post" class="contact-form" data-aos="fade-up" data-aos-delay="300" role="form">
                        <div class="row">

                          <!-- <div class="col-lg-12 col-12">
                            <input type="text" class="form-control" id="staffId" name="staffId" placeholder="staff ID" >
                          </div> -->
                         
                          <div class="col-lg-12 col-12">
                            <input type="text" class="form-control" id="staffUser" name="staffUser" placeholder="Username" required="required">
                          </div>

                          <div class="col-lg-12 col-12">
                            <input type="password" class="form-control" id="staffPassword" name="staffPassword" placeholder="Password" required="required">
                          </div>
							
							
							<div class="col-lg-12 col-12">
							 <select id="staffRole" name="staffRole" size="1" class="form-control" onchange="makeSubmenu(this.value)">
							<option value="" disabled selected>  SELECT ROLE  </option>
					<option >STAFF</option>
					<option >MANAGER</option>
				</select>
				</div>
							<div class="col-lg-12 col-12">
							 <select id="managerId" name="managerId" class="form-control" size="1" >
							<option value="" disabled selected>Choose manager</option>
					<option ></option>
					</select>
					</div>
				 
			        <div class="col-lg-12 col-12">
			         <label for="status">FULLTIME : </label><br>  
					YES <input type="radio"  onclick="javascript:yesnoCheck();" name="status" id="status" required="required"> 
					NO <input type="radio"  onclick="javascript:yesnoCheck();" name="status" id="status" required="required" ><br>
					</div>
					
         			<div class="col-lg-12 col-12" id="ifYes" style="visibility:hidden">
          			Fixed allowance: <input type="text" id="fixedAllowance" name="fixedAllowance"><br>
          			</div>
        			</div>
        				
                          <div class="col-lg-5 mx-auto col-7">
                          	<button type="submit" class="form-control" id="submit-button" name="submit" >Register</button>
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