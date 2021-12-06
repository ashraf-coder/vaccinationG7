<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4 style="color:red;">${message}</h4>
	<form action="register_booker" method="POST">
		<legend>Register to book a vaccine</legend>
		<label for="email">Email: <input type="email" name="email" id="email"></label>
		<label for="password">Password<input type="password" name="password" id="password"></label>
		<label for="cpassword">Confirm Password<input type="password" name="cpassword" id="cpassword"></label>
		<button type="submit">Register</button>
	</form>
</body>
</html>