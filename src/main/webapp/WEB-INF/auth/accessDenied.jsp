<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="ux" tagdir="/WEB-INF/tags/ux" %>

<ux:blankbody>
<h3>Access Denied</h3>
<s:a namespace="/" action="login">Login</s:a>
</ux:blankbody>