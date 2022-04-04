<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Login Page</title>
</head>
<body>

<h3>Login Page</h3>
<s:if test="%{#parameters.error != null}">
  Invalid username or password!
</s:if>
<s:if test="%{#parameters.logout != null}">
  Logout successfully
</s:if>
<s:form method="post" action="/auth/process-login.action">
  <s:textfield label="Username" name="username"></s:textfield>
  <s:password label="Password" name="password"></s:password>
  <s:submit value="Login" align="left"></s:submit>
</s:form>

</body>
</html>