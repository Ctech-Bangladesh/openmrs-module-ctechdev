<%@ include file="/WEB-INF/template/include.jsp" %>

<%@ include file="/WEB-INF/template/header.jsp" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js"></script>

<style>
    .headText {
        background: rgb(0, 3, 36);
        background: linear-gradient(90deg, rgba(0, 3, 36, 1) 0%, rgba(9, 121, 97, 1) 54%, rgba(0, 212, 255, 1) 100%);
        color: white;
    }
</style>

<div class="container">
    <h2 align="center" class="headText">Crystal Technology Bangladesh Limited</h2>
    <br/>
    <h1>Developer List</h1>
    <h3>
        <a href="newDeveloper.form">Add New Developer</a>
    </h3>

    <table id="developer" class="table table-striped table-bordered" style="width:100%">
        <thead class="thead-dark">
        <tr>
            <th>Job ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Designation</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
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
        </tbody>
        <tfoot>
        <tr>
            <th>Job ID</th>
            <th>Name</th>
            <th>Gender</th>
            <th>Designation</th>
            <th>Action</th>
        </tr>
        </tfoot>
    </table>
</div>

<script>
    $(document).ready(function () {
        $('#developer').DataTable();
    });
</script>
<%@ include file="/WEB-INF/template/footer.jsp" %>
