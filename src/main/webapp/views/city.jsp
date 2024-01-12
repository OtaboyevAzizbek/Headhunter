<%@ page import="com.HeadhunterModel.City" %>
<%@ page import="java.util.List" %>
<%@ page import="com.HeadhunterModel.Country" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11.01.2024
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp"%>
<% List<City> cityList = (List<City>) request.getAttribute("cityList");%>
<% List<Country> countryList = (List<Country>) request.getAttribute("countryList");%>
<div class="d-grid gap-5 d-md-flex align-items-center justify-content-md-end m-2">
    <button class="btn btn-primary me-md-2" data-bs-toggle="modal" data-bs-target="#exampleModel2" type="button">Create city</button>
</div>
<table class="table table-bordered border-2 table-striped">
    <thead>
    <tr>
        <th>City ID</th>
        <th>City Name</th>
        <th>Country Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <% for (City city : cityList) {%>
    <tr>
        <td><%=city.getCityId()%></td>
        <td><%=city.getCityName()%></td>
        <td><%=city.getCountryName()%></td>
        <td>
            <button type="button" data-bs-toggle="modal" data-bs-target=".bd-example-modal-x<%=city.getCityId()%>" class="btn btn-warning">Edit</button>
            <a href="<%=request.getContextPath()%>/headhunter/delete_city/<%=city.getCityId()%>" class="btn btn-danger">Delete</a>
        </td>
        <%--Modal--%>
        <div class="modal fade bd-example-modal-x<%=city.getCityId()%>" aria-labelledby="exampleModalLabel5" tabindex="-1">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel5">Edit city</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="edit_city" method="post">
                        <input type="hidden" name="cityId" value="<%=city.getCityId()%>">
                        <div class="modal-body">
                            <div class="mb-3">
                                <label for="exampleCity2" class="form-label">City Name</label>
                                <input type="text" name="name" class="form-control" id="exampleCity2" value="<%=city.getCityName()%>" required>
                            </div>
                            <div class="mb-3">
                                <label for="country2" class="form-label">Country Name</label>
                                <select name="countryId" id="country2" class="form-control" required>
                                    <option value="" selected>Select country</option>
                                    <% for (Country country : countryList) {%>
                                    <option value="<%=country.getCountryId()%>"><%=country.getCountryName()%></option>
                                    <%}%>
                                </select>
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
<div class="modal fade" id="exampleModel2" aria-labelledby="exampleModalLabel2" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel2">Create city</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="create_city" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleCity" class="form-label">City Name</label>
                        <input type="text" name="name" class="form-control" id="exampleCity" required>
                    </div>
                    <div class="mb-3">
                        <label for="country" class="form-label">Country Name</label>
                        <select name="countryId" id="country" class="form-control" required>
                            <option value="" selected>Select country</option>
                            <% for (Country country : countryList) {%>
                            <option value="<%=country.getCountryId()%>"><%=country.getCountryName()%></option>
                            <%}%>
                        </select>
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
