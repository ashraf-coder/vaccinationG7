<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="WEB-INF/tld/admin/patient_certificate.tld" prefix="vaccination" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href='bootstrap/css/bootstrap4.min.css'>
<title>patient's certificate</title>
	<style type="text/css">
		    body {
                color: black;
                display: table;
                font-family: Georgia, serif;
                font-size: 23px;
                text-align: center;
            }
		.wrapper{
			border: 15px solid tan;
			align-items: center;
			width: 750px;
			height: 570px;
			display: table-cell;
			vertical-align: middle;
			/*align-content: center;*/

		}
		.heading{
			color: tan;
            font-size: 25px;
            margin: 20px
		}
		.presented{
			margin: 20px;
		}
		.patient_name{
			border-bottom: 2px solid black;
            font-size: 26px;
            font-style: italic;
            margin: 20px auto;
            width: 400px;
            font-weight: bold;
		}
		.reason{
			margin: 20px
		}
	</style>
</head>
<body>
	<div class="d-flex justify-content">
		<vaccination:select table="patients" where="${nin}"/>
	</div>
</body>
</html>