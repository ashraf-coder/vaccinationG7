<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="WEB-INF/tld/vaccine2.tld" prefix="vaccination" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>products</title>
<link rel="stylesheet" href='bootstrap/css/bootstrap4.min.css'>
</head>
<body>
	<div class="container">
    <div class="row p-4">
    <div class="col-md-6  mx-auto">
        <h4 class="text-center text-secondary">new vaccine</h4>
        <form action="add_vaccine_data" method="POST" >
            <div class="form-group mb-2">
                <label for="name" class="mb-1">Vaccine name:</label>
                <input name="name" type="text" class="form-control" placeholder="vaccine name" id="name" required>
            </div>

            <div class="form-group">
                <label for="pwd" class="mb-1">Number of doses:</label>
                <input name="number_of_doses" type="number" class="form-control" placeholder="Number of doses" id="pwd" required>
            </div>
            
            <div class="form-group">
                <label for="pwd" class="mb-1">Number of shots:</label>
                <input name="number_of_shots" type="number" class="form-control" placeholder="Number of shots" id="pwd" required>
            </div>
            
            <div class="form-group">
                <label for="pwd" class="mb-1">Period between shots:</label>
                <input name="period_btn_shots" type="number" class="form-control" placeholder="Period between shots" id="pwd" required>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-success mb-1 w-50">add</button><br>
            </div>
        </form><br>
    </div>
    </div>
</div>
</body>
</html>