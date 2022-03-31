<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<p>Balance: EUR <s:property value="getText('{0,number,#,##0.00}',{balance})"/> </p>
<p>Last reading: <s:property value="getText('{0,number,#,##0.0}',{lastMeterReading.reading})"/> on <s:date name="lastMeterReading.dateTimeTaken" format="yyyy-MM-dd"/></p>
<p>Last payment: EUR <s:property value="getText('{0,number,#,##0.00}',{lastEnergyPayment.amountPaid})"/> on <s:date name="lastEnergyPayment.datePaymentMade" format="yyyy-MM-dd"/></p>
<p>
    <a href="<s:url action='payment' />">Submit payment</a>
    <a href="<s:url action='reading' />">Submit reading</a>
    <a href="<s:url action='report' />">Generate report</a>
</p>
</body>
</html>