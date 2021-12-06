<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/tld/healthcenter/update_center_detail.tld" prefix="vaccination" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>center detail</title>
<link rel="stylesheet" href='bootstrap/css/bootstrap4.min.css'>
</head>
<body>
	<vaccination:update table="health_centers" value="${number}"/>
</body>
</html>