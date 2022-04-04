<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="ux" tagdir="/WEB-INF/tags/ux" %>

<ux:body>
    <h1>EnergyMon</h1>
    <p>&nbsp;</p>
    <p>Balance: EUR <s:property value="getText('{0,number,#,##0.00}',{balance})"/> </p>
    <p>Last reading: <s:property value="getText('{0,number,#,##0.0}',{lastMeterReading.reading})"/> on <s:date name="lastMeterReading.dateTimeTaken" format="yyyy-MM-dd"/></p>
    <p>Last payment: EUR <s:property value="getText('{0,number,#,##0.00}',{lastEnergyPayment.amountPaid})"/> on <s:date name="lastEnergyPayment.datePaymentMade" format="yyyy-MM-dd"/></p>
</ux:body>