<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EnergyMon</title>
</head>
<body>
<h1>EnergyMon - Welcome</h1>
<hr />
<p>Balance: </p>
<p>Last reading: XX on YY</p>
<p>Last payment: XX on YY</p>
<p>
    <a href="<s:url action='payment' />">Submit payment</a>
    <a href="<s:url action='reading' />">Submit reading</a>
    <a href="<s:url action='report' />">Generate report</a>
</p>
</body>
</html>