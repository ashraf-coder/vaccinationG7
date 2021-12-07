<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/tld/booking/vaccine1.tld" prefix="vaccination" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href='bootstrap/css/bootstrap4.min.css'>
<title>make_booking</title>
</head>
<body>
<div class="container-fluid p-0">
	<div class="bg-light pl-5 pt-5" style="height: 50vh;">VACCINATE</div>
</div>
	
<vaccination:select table="bookings" where ="${date}" />

<div class="text-center">
	<form action="check_booking" method="POST">
		<label  for="date">date</label>
		<input  id="date" name="date" class="" type="date">
		<input type="submit" value="check">
	</form>	
</div>

<div class="container text-center mt-5 mb-5">
	<form action="make_booking" method="POST"></form>
		<div class="container">		
			<label for="center">choose health center</label>
			<select name="center" id="center">
				<option>mulago</option>
				<option>nsabya</option>
				<option>kiluddu</option>
			</select>
		</div>
		<label for="time">time</label>
		<select name="time" id="time">
			<option>morning</option>
			<option>afternoon</option>
			<option>evening</option>
		</select>
		<input type="submit" value="book">
	</form>
</div>
</body>
</html>