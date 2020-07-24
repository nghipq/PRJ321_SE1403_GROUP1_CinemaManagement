<%-- 
    Document   : admin.filmList
    Created on : Jul 16, 2020, 1:22:07 PM
    Author     : Admin
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="DAO.*"%>
<a href="admin.filmList.jsp"></a>
<%@include file="admin.header.jsp" %>
<!--<link href="<c:url value="/resources/css/admin.filmList.css"/>" rel="stylesheet"/>-->
<!DOCTYPE html>
<%
    FilmDAO fd = new FilmDAO();
%>
<div class="d-flex flex-row">
    <%@include file="dashboard.jsp" %>
    <div class="d-block flex-column justify-content-center align-items-center p-2" style="width: 75vw;">
        <div class="d-flex flex-row justify-content-center align-items-center p-2 w-100 rounded-sm m-2">
            <a href="insertFilm.html" class="btn btn-warning btn-md m-1"><strong>Thêm Phim Mới</strong></a>
            <a href="filmList.html" class="btn btn-warning btn-md m-1"><strong>Danh Sách</strong></a>
            <a href="filmList.html?status=0" class="btn btn-warning btn-md m-1"><strong>Phim Sắp Chiếu</strong></a>
            <a href="filmList.html?status=1" class="btn btn-warning btn-md m-1"><strong>Phim Đang Chiếu</strong></a>
            <a href="deletedfilms.html" class="btn btn-warning btn-md m-1"><strong>Phim đã xóa</strong></a>
            <a href="filmsManagement.html" class="btn btn-warning btn-md m-1"><strong>Doanh Thu</strong></a>
        </div>
        <table class="d-flex flex-column justify-content-start align-items-center w-100">
            <tr class="d-flex flex-row justify-content-start align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-dark text-warning">
                <td style="width: 6vw" class="text-center">
                    <strong>Mã Phim</strong>
                </td>
                <td style="width: 6vw" class="text-center">
                    <strong>POSTER</strong>
                </td>
                <td style="width: 21vw" class="text-center">
                    <strong>Tên phim</strong>
                </td>
                <td style="width: 10vw" class="text-center">
                    <strong>Tuổi giới hạn</strong>
                </td>
                <td style="width: 8vw" class="text-center">
                    <strong>Trạng thái</strong>
                </td>
                <td style="width: 6vw"></td>
            </tr>


            <c:forEach var="row" items="${films}">
                <tr class="d-flex flex-row justify-content-start align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-white text-dark ">
                    <c:set var="fId" value="${row.getfId()}"/>
                    <%
                        int fId = Integer.parseInt(pageContext.getAttribute("fId").toString());
                        String imgPath = "/resources/image/" + fd.getFilmPoster(fId);
                        pageContext.setAttribute("imgPath", imgPath);
                    %>

                    <td class="text-center"  style="width: 6vw">
                        <strong>#${row.getfId()}</strong>
                    </td>
                    <td style="width: 6vw">
                        <img src="<c:url value="${imgPath}"/>" alt="${row.getfName()}" class="w-100"/>
                    </td>
                    <td class="text-center"  style="width: 21vw">
                        <strong>${row.getfName()}</strong>
                    <td>
                    <td class="text-center" style="width: 10vw">
                        <strong>${row.getLimitAge()}+</strong>
                    </td>
                    <td class="text-center"  style="width: 8vw">
                        <strong>
                            <c:if test="${row.getStatus() == 0}">
                                Sắp chiếu
                            </c:if>
                            <c:if test="${row.getStatus() == 1}">
                                Đang chiếu
                            </c:if>
                            <c:if test="${row.getStatus() == 2}">
                                Đã ngừng chiếu
                            </c:if>
                        </strong>
                    </td>
                    <td class="d-flex flex-column justify-content-center align-items-center text-center" style="width: 6vw">
                        <a href="updateFilm.html?fId=${row.getfId()}" class="p-1">
                            <img style="width: 1rem; height: 1rem" src="<c:url value="/resources/icons/pencil-alt-solid.svg"/>" alt="Cập nhật" class="w-100"/>
                        </a>
                        <a href="deleteFilm.html?fId=${row.getfId()}" class="p-1">
                            <img style="width: 1rem; height: 1rem" src="<c:url value="/resources/icons/trash-alt-solid.svg"/>" alt="Xóa" class="w-100"/>
                        </a>
                        <a href="updateShowtimes.html?id=${row.getfId()}" class="p-1">
                            <img style="width: 1rem; height: 1rem" src="<c:url value="/resources/icons/calendar-regular.svg"/>" alt="Xóa" class="w-100"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%
    fd.closeConnect();
%>
<%@include file="admin.footer.jsp" %>
