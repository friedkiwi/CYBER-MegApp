<%@ tag description="ux:body tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CYBER.gent</title>

    <sj:head/>
    <sb:head/>
    <style>
        body {
            padding-top: 80px; /* 60px to make the container go all the way to the bottom of the topbar */
            background-color: yellow;
        }
        .logo {
            width: 60%;
            margin-left: auto;
            margin-right: auto;
            margin-top: 15%;
            display: block;
        }
    </style>
    <meta name="wot-verification" content="29cd031202081d16c161"/>
</head>
<body>



<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top nav-pills">
    <a class="navbar-brand" href="#">CYBER</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto nav nav-pills">
            <li class="nav-item">
                <s:a href="./" cssClass="nav-link">Home</s:a>
            </li>
            <s:if test="%{authenticated}">
            <li class="nav-item">
                <div class="dropdown">
                    <a href="#" class="nav-link dropdown-toggle" id="energyMonDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">EnergyMon</a>
                    <div class="dropdown-menu" aria-labelledby="energyMonDropdown">
                        <s:url var="payment_url" action="" namespace="/energymon"/>
                        <s:a href="%{payment_url}"  cssClass="dropdown-item">Overview</s:a>
                        <s:url var="payment_url" action="payment" namespace="/energymon"/>
                        <s:a href="%{payment_url}"  cssClass="dropdown-item">Submit payment</s:a>
                        <s:url var="reading_url" action="reading" namespace="/energymon"/>
                        <s:a href="%{reading_url}"  cssClass="dropdown-item">Submit Reading</s:a>
                        <s:url var="report_url" action="report" namespace="/energymon"/>
                        <s:a href="%{report_url}"  cssClass="dropdown-item">Generate report</s:a>
                    </div>
                </div>
            </li>
            </s:if>
        </ul>
    </div>

    <div class="navbar-collapse collapse order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto nav nav-pills">
            <li class="nav-item">
                <s:if test="%{authenticated}">
                <div class="dropdown">
                    <a href="#" class="nav-link dropdown-toggle" id="userMenuDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><s:property value="username" /></a>

                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userMenuDropdown">
                        <s:url var="change_password_url" action="changePassword" namespace="/auth"/>
                        <s:a href="%{change_password_url}" cssClass="dropdown-item">Update password</s:a>
                        <div class="dropdown-divider"></div>
                        <a href="/auth/logout.action?logout" class="dropdown-item">Log out</a>
                    </div>
                </div>
                </s:if>
                <s:else>
                    <s:url var="login_url" action="login" namespace="/auth"/>
                    <s:a href="%{login_url}" cssClass="nav-link">Login</s:a>
                </s:else>
            </li>
        </ul>
    </div>
</nav>

<div class="container" role="main">
    <jsp:doBody />
</div>
</body>
</html>