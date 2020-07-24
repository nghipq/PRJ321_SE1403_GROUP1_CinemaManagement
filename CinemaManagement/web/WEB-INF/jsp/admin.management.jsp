<%-- 
    Document   : admin.management
    Created on : Jul 23, 2020, 11:44:03 PM
    Author     : phamq
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
                    <strong>Rank</strong>
                </td>
                <td style="width: 6vw" class="text-center">
                    <strong>Mã Phim</strong>
                </td>
                <td style="width: 6vw" class="text-center">
                    <strong>POSTER</strong>
                </td>
                <td style="width: 15vw" class="text-center">
                    <strong>Tên phim</strong>
                </td>
                <td style="width: 10vw" class="text-center">
                    <strong>Thể Loại</strong>
                </td>
                <td style="width: 10vw" class="text-center">
                    <strong>Tuổi giới hạn</strong>
                </td>
                <td style="width: 8vw" class="text-center">
                    <strong>Trạng thái</strong>
                </td>
                <td style="width: 10vw" class="text-center">
                    <strong>Doanh Thu</strong>
                </td>
            </tr>


            <c:forEach var="i" begin="0" end="${len}">
                <tr class="d-flex flex-row justify-content-start align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-white text-dark ">
                    <c:set var="fId" value="${films.get(i).getfId()}"/>
                    <%
                        int fId = Integer.parseInt(pageContext.getAttribute("fId").toString());
                        String imgPath = "/resources/image/" + fd.getFilmPoster(fId);
                        pageContext.setAttribute("imgPath", imgPath);
                    %>
                    <td class="text-center"  style="width: 6vw">
                        <strong>#${i}</strong>
                    </td>
                    <td class="text-center"  style="width: 6vw">
                        <strong>#${films.get(i).getfId()}</strong>
                    </td>
                    <td style="width: 6vw">
                        <img src="<c:url value="${imgPath}"/>" alt="${films.get(i).getfName()}" class="w-100"/>
                    </td>
                    <td class="text-center"  style="width: 15vw">
                        <strong>${films.get(i).getfName()}</strong>
                    <td>
                    <td class="text-center"  style="width: 10vw">
                        <strong>${categories.get(i)}</strong>
                    <td>
                    <td class="text-center" style="width: 10vw">
                        <strong>${films.get(i).getLimitAge()}+</strong>
                    </td>
                    <td class="text-center"  style="width: 8vw">
                        <strong>
                            <c:if test="${films.get(i).getStatus() == 0}">
                                Sắp chiếu
                            </c:if>
                            <c:if test="${films.get(i).getStatus() == 1}">
                                Đang chiếu
                            </c:if>
                            <c:if test="${films.get(i).getStatus() == 2}">
                                Đã ngừng chiếu
                            </c:if>
                        </strong>
                    </td>
                    <td class="d-flex flex-column justify-content-center align-items-center text-center" style="width: 10vw">
                        <strong>${prices.get(i)} VND</strong>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="d-flex flex-row justify-content-center align-items-center p-2 w-100 rounded-sm m-2">
            <a href="ExportTop10Films.html" class="btn btn-warning btn-md m-1"><strong>SAVE</strong></a>
        </div>
    </div>
</div>
<%
    fd.closeConnect();
%>
<%@include file="admin.footer.jsp" %>