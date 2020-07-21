<%-- 
    Document   : admin.customerList
    Created on : Jul 20, 2020, 1:28:32 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.UserDAO"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>

<!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">-->
<link href="<c:url value="/resources/css/admin.filmList.css"/>" rel="stylesheet"/>
<div class="d-flex flex-row">
    <%@include file="dashboard.jsp" %>
    <div class="d-flex flex-column justify-content-start align-items-center p-5" style="width: 80vw;">
        <table>
            <tr class="d-flex flex-row justify-content-between align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-dark text-warning">
                <td style="width: 12vw">
                    <strong>Name</strong>
                </td>
                <td style="width: 15vw">
                    <strong>Email</strong>
                </td>
                <td style="width: 10vw">
                    <strong>Phone</strong>
                </td>
                <td style="width: 5vw">
                    <strong>Gender</strong>
                </td>
                <td style="width:5vw">
                    <strong>Level</strong>
                </td>
                <td style="width: 5vw">
                    <strong>Status</strong>
                </td>
                <td style="width: 5vw">
                    <strong></strong>
                </td>
            </tr>
            <c:forEach var="row" items="${user}">
                <tr class="d-flex flex-row justify-content-between align-items-center p-3 w-100 border border-dark rounded-sm m-2  bg-white text-dark">

                    <td style="width: 12vw">
                        <strong>${row.getUsername()}</strong>
                    </td>
                    <td style="width: 15vw">
                        <strong>${row.getEmail()}</strong>
                    </td>
                    <td style="width: 14vw">
                        <strong>${row.getPhone()}</strong>
                    </td>
                    <td style="width: 5vw">
                        <strong>${row.getGender()}</strong>
                    </td>
                    <td style="width: 5vw">
                        <strong>0</strong>
                    </td>
                    <td style="width: 5vw">
                        <strong>Status</strong>
                    </td>
                    <td style="width: 5vw">
                        <a href="updateUser.html?id=${row.getuId()}">Edit</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
        <div class="container">
            <button type="button" class="btn btn-warning btn-lg"><strong>Change Page</strong></button>
        </div>

    </div>
</div>
<%@include file="footer.jsp" %>
