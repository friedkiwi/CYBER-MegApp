<%--
  Created by IntelliJ IDEA.
  User: friedkiwi
  Date: 08/03/2022
  Time: 20:48
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
                <li class="nav-item active">
                    <s:url var="payment_url" action="payment"/>
                    <s:a href="%{payment_url}" cssClass="nav-link">Submit payment</s:a>
                </li>
                <li class="nav-item">
                    <s:url var="reading_url" action="reading"/>
                    <s:a href="%{reading_url}" cssClass="nav-link">Submit Reading</s:a>
                </li>
                <li class="nav-item">
                    <s:url var="report_url" action="report"/>
                    <s:a href="%{report_url}" cssClass="nav-link">Generate report</s:a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container" role="main">
        <h1>Submit payment</h1>
        <p>&nbsp;</p>
        <s:form action="payment" theme="bootstrap" cssClass="form-horizontal">
            <s:textfield name="energyPaymentBean.amountPaid" label="Amount paid" />
            <s:submit value="Submit" />
        </s:form>
    </div>
</body>
</html>
