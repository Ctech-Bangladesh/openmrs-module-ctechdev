<%@ include file="/WEB-INF/template/include.jsp" %>

<%@ include file="/WEB-INF/template/header.jsp" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
    .headText{
        background: rgb(0,3,36);
        background: linear-gradient(90deg, rgba(0,3,36,1) 0%, rgba(9,121,97,1) 54%, rgba(0,212,255,1) 100%);
        color: white;
    }
</style>

<div class="container">
    <h2 align="center" class="headText">Crystal Technology Bangladesh Limited</h2>
    <br/>
    <h2>Ctech Developer</h2>
    <br/>
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
                <td><form:input name="designation" path="designation" placeholder="Designation"/></td>
            </tr>
            <tr>
                <td colspan="2" style="height: 20px; padding-top: 5px;">
                    <input type="submit" value="<spring:message text="Save Developer"/>">
                </td>
            </tr>
        </table>
    </form:form>
</div>

<%@ include file="/WEB-INF/template/footer.jsp" %>
