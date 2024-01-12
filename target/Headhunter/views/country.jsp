<%@ page import="java.util.List" %>
<%@ page import="com.HeadhunterModel.Country" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 10.01.2024
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp"%>
<% List<Country> countryList = (List<Country>) request.getAttribute("countryList");%>
<div class="d-grid gap-5 d-md-flex align-items-center justify-content-md-end m-2">
    <button class="btn btn-primary me-md-2" data-bs-toggle="modal" data-bs-target="#exampleModel" type="button">Create country</button>
</div>
<table class="table table-bordered border-2 table-striped">
    <thead>
    <tr>
        <th>Country ID</th>
        <th>Country Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <% for (Country country : countryList) {%>
    <tr>
        <td><%=country.getCountryId()%></td>
        <td><%=country.getCountryName()%></td>
        <td>
            <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-z<%=country.getCountryId()%>" class="btn btn-warning">Edit</button>
            <a href="<%=request.getContextPath()%>/headhunter/delete_country/<%=country.getCountryId()%>" class="btn btn-danger">Delete</a>
        </td>
        <%--Modal--%>
        <div class="modal fade bd-example-modal-z<%=country.getCountryId()%>" aria-labelledby="exampleModalLabel4" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel4">Edit country</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="edit_country" method="post">
                        <input type="hidden" name="countryId" value="<%=country.getCountryId()%>">
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="exampleCountry2" class="form-label">Country Name</label>
                                <input type="text" name="name" class="form-control" id="exampleCountry2" value="<%=country.getCountryName()%>" required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-success">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </tr>
    <%}%>
    </tbody>
</table>
<%--Modal--%>
<div class="modal fade" id="exampleModel" aria-labelledby="exampleModalLabel" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Create country</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="create_country" method="post">
            <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleCountry" class="form-label">Country Name</label>
                        <input type="text" name="name" class="form-control" id="exampleCountry" required>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-success">Save</button>
            </div>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>
