<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="ux" tagdir="/WEB-INF/tags/ux" %>

<ux:body>
    <h1>EnergyMon - Report</h1>
    <h2>Readings</h2>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Date</th>
                <th scope="col">Reading</th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="meterReadings">

                <tr>
                    <th scope="row">
                        <s:date name="dateTimeTaken" format="yyyy-MM-dd" />
                    </th>
                    <td>
                        <s:property value="getText('{0,number,#,##0.0}',{reading})"/>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>

    <h2>Payments</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Date</th>
            <th scope="col">Amount</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator value="payments">

            <tr>
                <th scope="row">
                    <s:date name="datePaymentMade" format="yyyy-MM-dd" />
                </th>
                <td>
                    EUR <s:property value="getText('{0,number,#,##0.00}',{amountPaid})"/>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>

    <h2>Summary</h2>
    <p>Balance: EUR <s:property value="getText('{0,number,#,##0.00}',{balance})"/> </p>
    <p>Last reading: <s:property value="getText('{0,number,#,##0.0}',{lastMeterReading.reading})"/> on <s:date name="lastMeterReading.dateTimeTaken" format="yyyy-MM-dd"/></p>
</ux:body>