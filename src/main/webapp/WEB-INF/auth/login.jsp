<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="ux" tagdir="/WEB-INF/tags/ux" %>

<ux:blankbody>

<h3>Login Page</h3>
<s:if test="%{#parameters.error != null}">
  Invalid username or password!
</s:if>
<s:if test="%{#parameters.logout != null}">
  Logout successfully
</s:if>
<s:form method="post" action="/auth/process-login.action" theme="bootstrap">
  <s:textfield label="Username" name="username"></s:textfield>
  <s:password label="Password" name="password"></s:password>
  <s:submit value="Login" align="left"></s:submit>
  <s:hidden name="%{#attr._csrf.parameterName}"  value="%{#attr._csrf.token}"/>
</s:form>
</ux:blankbody>