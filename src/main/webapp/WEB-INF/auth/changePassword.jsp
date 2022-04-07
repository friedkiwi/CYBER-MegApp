<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="ux" tagdir="/WEB-INF/tags/ux" %>

<ux:body>
    <h1>Change password</h1>
    <p>&nbsp;</p>
    <s:form action="changePassword" theme="bootstrap" namespace="/auth" cssClass="form-horizontal">
        <s:password name="oldPassword" label="Old password" />
        <s:password name="newPassword" label="New password" />
        <s:password name="newPasswordRepeat" label="Repeat new password" />
        <p>&nbsp;</p>
        <s:submit value="Update password" />
        <s:hidden name="%{#attr._csrf.parameterName}"  value="%{#attr._csrf.token}"/>
    </s:form>
</ux:body>