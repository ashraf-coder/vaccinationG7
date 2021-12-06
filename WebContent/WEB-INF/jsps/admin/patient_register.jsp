<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="WEB-INF/tld/admin/register_patient.tld" prefix="vaccination" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>patient form data</title>
</head>
<body>
<vaccination:insert table="patients" value1="${email}" value2="${nin}" value3="${name}" value4="${doa}" value5="${batch_no}" value6="${vaccine_id}"  />

</body>
</html>