<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/tld/add_vaccine.tld" prefix="vaccination" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add_vaccine</title>
</head>
<body>
	<vaccination:insert table="vaccines" value1="${name}" value2="${number_of_doses}" value3="${number_of_shots}" value4="${period_btn_shots}" /> 
</body>
</html>