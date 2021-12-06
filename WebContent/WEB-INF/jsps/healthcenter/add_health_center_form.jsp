<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Health center</title>
</head>


<body>
	<h1>Add Health center</h1>
	<form action="add_health_center_data" method="POST">
		<p>Health Center Name</p>
		<label for="center">health center name</label>
		<input id="center" type="text" name="center">
		<input type="submit" value="Add">
	</form>
</body>
</html>