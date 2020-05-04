<%@ include file="/WEB-INF/template/include.jsp" %>

<%@ include file="/WEB-INF/template/header.jsp" %>

<h2 align="center" style="color: blue">Crystal Technology Bangladesh Limited</h2>
<br/>
<h1>Ctech Developer</h1>

<form:form action="updateDeveloper.form" method="POST" modelAttribute="developer" id="developer">
    <table>
        <form:hidden name="id" path="id"/>
        <tr>
            <td>Job ID:</td>
            <td><form:input name="jobid" path="jobid"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input name="name" path="name"/></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>
                <form:radiobutton path="gender" value="M"/>Male
                <form:radiobutton path="gender" value="F"/>Female
                <form:radiobutton path="gender" value="O"/>Other
            </td>
        </tr>
        <tr>
            <td>Designation:</td>
            <td><form:input name="designation" path="designation"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="<spring:message text="Update Developer"/>">
            </td>
        </tr>
    </table>
</form:form>

<%@ include file="/WEB-INF/template/footer.jsp" %>
