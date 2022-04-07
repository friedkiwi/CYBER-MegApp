<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@ taglib prefix="ux" tagdir="/WEB-INF/tags/ux" %>

<ux:body>
        <h1>Submit payment</h1>
        <p>&nbsp;</p>
        <s:form namespace="/energymon" action="payment" theme="bootstrap" cssClass="form-horizontal">
            <s:textfield name="energyPaymentBean.amountPaid" label="Amount paid" />
            <s:submit value="Submit" />
            <s:hidden name="%{#attr._csrf.parameterName}"  value="%{#attr._csrf.token}"/>
        </s:form>
</ux:body>