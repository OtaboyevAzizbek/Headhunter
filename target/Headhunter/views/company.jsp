<%@ page import="com.HeadhunterModel.Company" %>
<%@ page import="java.util.List" %>
<%@ page import="com.HeadhunterModel.City" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11.01.2024
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp"%>
<% List<Company> companyList = (List<Company>) request.getAttribute("companyList");%>
<% List<City> cityList = (List<City>) request.getAttribute("cityList");%>
<div class="d-grid gap-5 d-md-flex align-items-center justify-content-md-end m-2">
    <button class="btn btn-primary me-md-2" data-bs-toggle="modal" data-bs-target="#exampleModel3" type="button">Create company</button>
</div>
<table class="table table-bordered border-2 table-striped">
    <thead>
    <tr>
        <th>Company ID</th>
        <th>Company Name</th>
        <th>Company Tel</th>
        <th>Company Email</th>
        <th>City Name</th>
        <th>Country Name</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>
    <% for (Company company : companyList) {%>
    <tr>
        <td><%=company.getCompanyId()%></td>
        <td><%=company.getCompanyName()%></td>
        <td><%=company.getCompanyTel()%></td>
        <td><%=company.getCompanyEmail()%></td>
        <td><%=company.getCityName()%></td>
        <td><%=company.getCountryName()%></td>
        <td><%=company.getDescription()%></td>
    </tr>
    <%}%>
    </tbody>
</table>
<%--Modal--%>
<div class="modal fade" id="exampleModel3" aria-labelledby="exampleModalLabel3" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel3">Create company</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="create_company" method="post">
                <div class="modal-body">
                    <div class="mb-3">
                        <label for="exampleCompanyName" class="form-label">Company Name</label>
                        <input type="text" name="companyName" class="form-control" id="exampleCompanyName" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleCompanyTel" class="form-label">Company Tel</label>
                        <input type="text" name="companyTel" class="form-control" id="exampleCompanyTel" required>
                    </div>
                    <div class="mb-3">
                        <label for="exampleCompanyEmail" class="form-label">Company Email</label>
                        <input type="text" name="companyEmail" class="form-control" id="exampleCompanyEmail" required>
                    </div>
                    <div class="mb-3">
                        <label for="cityLable" class="form-label">Country Name</label>
                        <select name="cityId" id="cityLable" class="form-control" required>
                            <option value="" selected>Select address</option>
                            <% for (City city : cityList) {%>
                            <option value="<%=city.getCityId()%>"><%=city.getCityName()%>,<%=city.getCountryName()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="exampleCompanyDescription" class="form-label">Description</label>
                        <textarea name="description" class="form-control" rows="2" id="exampleCompanyDescription"></textarea>
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
