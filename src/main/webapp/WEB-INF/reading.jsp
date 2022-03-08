<%--
  Created by IntelliJ IDEA.
  User: friedkiwi
  Date: 08/03/2022
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>EnergyMon - Submit reading</title>
</head>
<body>
<h1>Submit reading</h1>
<hr />

<s:form action="reading">
    <s:textfield name="meterReadingBean.reading" label="Current meter reading" />
    <s:submit value="Submit" />
</s:form>

<p><a href="<s:url action='' />">Back</a></p>
</body>
</html>
