<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="student" type="design.StudentVO" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student Information</title>
</head>
<body>
<p style="color: blue;font-size:x-large; large;font-family: sans-serif;">
    Student Id : <jsp:getProperty property="id" name="student"/><br>
    Student Name : <jsp:getProperty property="name" name="student"/>
</p>
</body>
</html>