<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shopping chart</title>
<link rel="stylesheet" href='bootstrap/css/bootstrap4.min.css'>
</head>
<body>
	<h1 class="text-success text-center">shopping chart</h1>
	<h2 class="text-warning text-center">${ranking}</h2>
	<div class="container">
		<div class="d-flex flex-wrap">
			<c:forEach var="product" items="${shopping_chart_list}">
				<div class="bg-light h-25  mt-2 mr-1 p-2">
					<p>product name: </p>
					<p class="text-success"><c:out value="${product}" /></p>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>