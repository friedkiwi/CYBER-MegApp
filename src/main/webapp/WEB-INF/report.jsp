<%--
  Created by IntelliJ IDEA.
  User: friedkiwi
  Date: 08/03/2022
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>EnergyMon</title>

    <sb:head/>
    <style>
        body {
            padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-light fixed-top">
    <a class="navbar-brand" href="#">EnergyMon</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <s:a href="./" cssClass="nav-link">Home</s:a>
            </li>
            <li class="nav-item ">
                <s:url var="payment_url" action="payment"/>
                <s:a href="%{payment_url}" cssClass="nav-link">Submit payment</s:a>
            </li>
            <li class="nav-item ">
                <s:url var="reading_url" action="reading"/>
                <s:a href="%{reading_url}" cssClass="nav-link">Submit Reading</s:a>
            </li>
            <li class="nav-item active">
                <s:url var="report_url" action="report"/>
                <s:a href="%{report_url}" cssClass="nav-link">Generate report</s:a>
            </li>
        </ul>
    </div>
</nav>

<div class="container" role="main">
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
</div>
</body>
</html>
