<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="WEB-INF/tld/booking/vaccine.tld" prefix="vaccination" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href='bootstrap/css/bootstrap4.min.css'>
<title>Insert title here</title>
</head>
<body>


<h1>PATIENT REGISTRATION FORM</h1>
<div class="">
	<form action="patient_register" method="POST">
		<label  for="email">Email</label>
		<input  id="email" name="email" class="" type="text"><br>
		<label  for="nin">NIN</label>
		<input  id="nin" name="nin" class="" type="text"><br>
		<label  for="email">Patient Name</label>
		<input  id="name" name="name" class="" type="text"><br>
		<label  for="doa">Date Of Administration</label>
		<input  id="doa" name="doa" class="" type="date"><br>
		<label  for="batch_no">Batch Number</label>
		<input  id="batch_no" name="batch_no" class="" type="text"><br>
		<label  for="vaccine">Vaccine</label>
		<select name="vaccine_id">
		<vaccination:select table="vaccines"/>
		</select><br>
		
		<input type="submit" value="REGISTER">
	</form>	
</div>
</body>
</html>