<%-- 
    Document   : admin.filmList
    Created on : Jul 16, 2020, 1:22:07 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.FilmDAO"%>
<%@include file="admin.header.jsp" %>
<link href="<c:url value="/resources/css/admin.filmList.css"/>" rel="stylesheet"/>
<!DOCTYPE html>
<div class="d-flex flex-row">
    <%@include file="dashboard.jsp" %>
    <div class="d-block flex-column justify-content-start align-items-center p-5" style="width: 80%;">
        <table class="d-flex flex-column justify-content-start align-items-center w-100">
            <tr class="d-flex flex-row justify-content-start align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-dark text-warning">
                <td style="width: 4vw">
                    <strong>STT</strong>
                </td>
                <td style="width: 19vw">
                    <strong>Tên phim</strong>
                </td>
                <td style="width: 10vw">
                    <strong>Tuổi giới hạn</strong>
                </td>
                <td style="width: 8vw">
                    <strong>Trạng thái</strong>
                </td>
                <td>
                    <strong></strong>
                </td>
            </tr>


            <c:forEach var="row" items="${films}">
                <tr class="d-flex flex-row justify-content-start align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-white text-dark ">

                    <td class="d-flex flex-row justify-content-start align-items-start"  style="width: 4vw">
                        <strong>${row.getfId()}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-between align-items-start"  style="width: 21vw">
                        <strong>${row.getfName()}</strong>
                    <td>
                    <td class="d-flex flex-row justify-content-between align-items-start w-5" style="width: 10vw">
                        <strong>${row.getLimitAge()}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-between align-items-start w-5"  style="width: 8vw">
                        <strong>${row.getStatus()}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-between align-items-start w-5">
                        <a href="updateUser.html?id=${row.getuId()}">Edit</a>
                    </td>

                </tr>
            </c:forEach>
        </table>

        <div
            class="d-flex flex-row justify-content-between align-items-center p-2 mt-4 w-100 rounded-sm m-2">
            <div class="container">
                <button type="button" class="btn btn-warning btn-lg"><strong>Thêm phim</strong></button>
            </div>
        </div>
    </div>

</div>
<%@include file="admin.footer.jsp" %>
