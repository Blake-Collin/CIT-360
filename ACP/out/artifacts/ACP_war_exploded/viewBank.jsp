<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="bank" type="design.BankVO" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Bank Information</title>
</head>
<body>
<p style="color: blue;font-size:x-large; large;font-family: sans-serif;">
    Bank Account: <jsp:getProperty property="account" name="bank"/><br>
    Transfer Number: <jsp:getProperty property="transfer" name="bank"/>
</p>
</body>
</html>