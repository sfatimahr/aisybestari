<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Slot to Enrollment</title>
</head>
<body>

<h1>Assign Slot to Enrollment</h1>

	<form id="pickSlot" name="pickSlot" method="post" action="Enroll_SubjectController">
	
		<label for="enrollId">Enrollment id:</label><br>        
        <input type="text" id="enrollId" name="enrollId" required="required"><br>
        
        <label for="subjectId">Subject id:</label><br>        
        <input type="text" id="subjectId" name="subjectId" required="required"><br>
        
        <label for="slotId">Slot id:</label><br>        
        <input type="text" id="slotId" name="slotId" required="required"><br>
        
  		<input type="submit" value="Submit">
	
	</form>

</body>
</html>