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
    </tr>
    </thead>
    <tbody>
    <% for (City city : cityList) {%>
    <tr>
        <td><%=city.getCityId()%></td>
        <td><%=city.getCityName()%></td>
        <td><%=city.getCountryName()%></td>
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
