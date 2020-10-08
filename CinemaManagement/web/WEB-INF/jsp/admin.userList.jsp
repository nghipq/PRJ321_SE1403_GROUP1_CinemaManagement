<%-- 
    Document   : admin.customerList
    Created on : Jul 20, 2020, 1:28:32 PM
    Author     : Admin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="admin.header.jsp" %>
<!DOCTYPE html>

<!--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">-->
<!--<link href="<c:url value="/resources/css/admin.filmList.css"/>" rel="stylesheet"/>-->
<div class="d-flex flex-row">
    <%@include file="dashboard.jsp" %>
    <div class="d-flex flex-column justify-content-start align-items-center p-5" style="width: 80vw;">
        <table>
            <tr class="d-flex flex-row justify-content-between align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-dark text-warning">
                <td class="text-center" style="width: 12vw">
                    <strong>Name</strong>
                </td>
                <td class="text-center" style="width: 5vw">
                    <strong>Role</strong>
                </td>
                <td class="text-center" style="width: 15vw">
                    <strong>Email</strong>
                </td>
                <td class="text-center" style="width: 10vw">
                    <strong>Phone</strong>
                </td>
                <td class="text-center" style="width: 14vw">
                    <strong>Address</strong>
                </td>
                <td class="text-center" style="width: 5vw">
                    <strong>Gender</strong>
                </td>
                <td class="text-center" style="width: 5vw">
                    <strong></strong>
                </td>
            </tr>
            <c:forEach var="row" items="${user}">
                <tr class="d-flex flex-row justify-content-between align-items-center p-3 w-100 border border-dark rounded-sm m-2  bg-white text-dark">

                    <td class="text-center" style="width: 12vw">
                        <strong id="user_name">${row.getUsername()}</strong>
                    </td>
                    <td class="text-center" style="width: 5vw">
                        <c:if test="${row.getPremission() == 0}">
                            <strong class="text-success">Customer</strong>
                        </c:if>
                        <c:if test="${row.getPremission() == 1}">
                            <strong class="text-primary">Staff</strong>
                        </c:if>
                    </td>
                    <td class="text-center" style="width: 15vw">
                        <strong>${row.getEmail()}</strong>
                    </td>
                    <td class="text-center" style="width: 10vw">
                        <strong>${row.getPhone()}</strong>
                    </td>
                    <td class="text-center" style="width: 14vw">
                        <strong>${row.getAddress()}</strong>
                    </td>
                    <td class="text-center" style="width: 5vw">
                        <strong>
                            <c:if var="item" test="${row.getGender() == 0}">
                                Female
                            </c:if>
                            <c:if var="item" test="${row.getGender() == 1}">
                                Male
                            </c:if>
                        </strong>
                    </td>
                    <td class="text-center" style="width: 5vw">
                        <a href="updateUser.html?id=${row.getuId()}">
                            <img id="image_update_user" style="width: 1rem; height: 1rem" src="<c:url value="/resources/icons/pencil-alt-solid.svg"/>" alt="update" class="w-100"/>
                        </a>
                        <a href="deleteUser.html?uId=${row.getuId()}">
                            <img style="width: 1rem; height: 1rem" src="<c:url value="/resources/icons/trash-alt-solid.svg"/>" alt="update" class="w-100"/>
                        </a>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="admin.footer.jsp" %>
