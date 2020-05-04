<%@ include file="/WEB-INF/template/include.jsp" %>

<%@ include file="/WEB-INF/template/header.jsp" %>

<h2 align="center" style="color: blue">Crystal Technology Bangladesh Limited</h2>
<br/>
<h2>Ctech Developer</h2>

<form:form action="saveDeveloper.form" method="POST" modelAttribute="developer" id="developer">
    <table>
        <form:hidden name="id" path="id"/>
        <tr>
            <td>Job ID:</td>
            <td><form:input name="jobid" path="jobid" value="Ctech" required="true"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input name="name" path="name" required="true"/></td>
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
            <td><form:input name="designation" path="designation" placeholder="Programmer / Jr. Programmer"/></td>
        </tr>
        <tr>
            <td colspan="2" style="height: 20px; padding-top: 5px;">
                <input type="submit" value="<spring:message text="Save Developer"/>">
            </td>
        </tr>
    </table>
</form:form>

<%@ include file="/WEB-INF/template/footer.jsp" %>
