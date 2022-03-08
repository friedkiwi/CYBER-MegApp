<%--
  Created by IntelliJ IDEA.
  User: friedkiwi
  Date: 08/03/2022
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Submit payment</title>
</head>
<body>
    <h1>EnergyMon - Submit payment</h1>
    <hr />

    <s:form action="payment">
        <s:textfield name="amountPaid" label="Amount paid" />
        <s:submit value="Submit" />
    </s:form>

    <p><a href="<s:url action='' />">Back</a></p>
</body>
</html>
