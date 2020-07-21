<%-- 
    Document   : admin.filmList
    Created on : Jul 16, 2020, 1:22:07 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.FilmDAO"%>
<%@include file="header.jsp" %>
<link href="<c:url value="/resources/css/admin.filmList.css"/>" rel="stylesheet"/>
<!DOCTYPE html>
<div class="d-flex flex-row">
    <%@include file="dashboard.jsp" %>
    <sql:setDataSource driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://localhost/group1"
                       user="root" password=""
                       var="conn" scope="session"/>

    <div class="d-block flex-column justify-content-start align-items-center p-5" style="width: 80vw;">
        <table class="d-flex flex-column justify-content-start align-items-center w-100">
            <tr class="d-flex flex-row justify-content-start align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-dark text-warning">
                <td style="width: 3vw">
                    <strong>STT</strong>
                </td>
                <td style="width: 15vw">
                    <strong>Tên phim</strong>
                </td>
                <td style="width: 6vw">
                    <strong>Thể loại</strong>
                </td>
                <td style="width: 8vw">
                    <strong>Tuổi giới hạn</strong>
                </td>
                <td style="width: 10vw">
                    <strong>Đạo diễn</strong>
                </td>
                <td style="width: 10vw">
                    <strong>Diễn viên</strong>
                </td>
                <td >
                    <strong>Trạng thái</strong>
                </td>
            </tr>


            <c:forEach var="row" items="${films}">
                <tr class="d-flex flex-row justify-content-start align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-white text-dark ">

                    <td class="d-flex flex-row justify-content-start align-items-start"  style="width: 3vw">
                        <strong>${row.getfId()}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-between align-items-start"  style="width: 15vw">
                        <strong>${row.getfName()}</strong>
                    <td>
                    <td class="d-flex flex-row justify-content-between align-items-start w-5" style="width: 8vw">
                        <strong>${categories}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-between align-items-start w-5" style="width: 8vw">
                        <strong>${row.getLimitAge()}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-between align-items-start w-5" style="width: 10vw">
                        <strong>${directors}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-between align-items-start w-5" style="width: 10vw">
                        <strong>${actors}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-between align-items-start w-5">
                        <strong>${row.getStatus()}</strong>
                    </td>

                </tr>
            </c:forEach>
        </table>

        <div
            class="d-flex flex-row justify-content-between align-items-center p-2 mt-4 w-100 rounded-sm m-2">
            <div class="container">
                <button type="button" class="btn btn-warning btn-lg"><strong>Change Page</strong></button>
            </div>
        </div>
    </div>

</div>
<%@include file="footer.jsp" %>
