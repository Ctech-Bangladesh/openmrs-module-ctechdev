<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<h2 align="center" style="color: blue">Crystal Technology Bangladesh Limited</h2>
<br/>
<h1>Developer List</h1>
<h3>
    <a href="newDeveloper.form">New Developer</a>
</h3>
    <table border="1" class="data">

        <th width="80">Job ID</th>
        <th width="80">Name</th>
        <th width="80">Gender</th>
        <th width="80">Designation</th>
        <th width="120">Action</th>

        <c:forEach var="developer" items="${listDeveloper}">
                <tr>
                    <td>${developer.jobid}</td>
                    <td>${developer.name}</td>
                    <td>${developer.gender}</td>
                    <td>${developer.designation}</td>

                    <td><a href="editDeveloper/${developer.id}.form">Edit</a>
                        <a
                                href="deleteDeveloper/${developer.id}.form">Delete</a></td>

                </tr>
        </c:forEach>
    </table>
<%@ include file="/WEB-INF/template/footer.jsp"%>
