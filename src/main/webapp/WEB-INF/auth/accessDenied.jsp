<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Access Denied Page</title>
</head>
<body>

<h3>Access Denied Page</h3>
<s:a namespace="/dashboard" action="login">Login</s:a>

</body>
</html>