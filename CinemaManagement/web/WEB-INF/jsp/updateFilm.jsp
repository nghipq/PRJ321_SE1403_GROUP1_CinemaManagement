<%-- 
    Document   : updateFilm
    Created on : Jul 22, 2020, 1:07:31 PM
    Author     : Admin
--%>

<%@page import="DAO.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="admin.header.jsp" %>
<%@include file="dashboard.jsp" %>
<div class="d-flex flex-column justify-content-center align-items-center">
    <div class="text-center bg-dark text-warning p-2 rounded-sm border border-warning mt-2 mb-2" style="width: 35vw">
        <strong style=" font-size: 2rem">Cập Nhật Phim</strong>
    </div>
    <div class="d-flex flex-row justify-content-center align-items-start" style="width: 75vw">

        <div class="d-flex flex-column justify-content-center align-items-end" style="width: 30vw">
            <c:set var="fId" value="${film.getfId()}"/>
            <%
                FilmDAO fd = new FilmDAO();
                int fId = Integer.parseInt(pageContext.getAttribute("fId").toString());
                String imgPath = "/resources/image/" + fd.getFilmPoster(fId);
                pageContext.setAttribute("imgPath", imgPath);
            %>

            <div class="d-flex flex-column justify-content-center align-items-center bg-white p-4" style="width: 25vw">
                <img src="<c:url value="${imgPath}"/>" alt="${film.getfName()}" class="w-100"/>
            </div>
            <form action="/files/uploadFile.html" enctype="multipart/form-data" method="POST" class="d-flex flex-column justify-content-center align-items-center rounded-sm p-3 bg-dark" style="width: 25vw">
                <input type="hidden" name="fId" value="${film.getfId()}"/>
                <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
                    <label class="text-white">Cập nhật hình ảnh:</label>
                    <input type="file" name="file" value="${imgPath}" class="w-100 p-2 border border-warning rounded bg-white">
                </div>
                <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
                    <input type="submit" class="btn btn-warning btn-lg w-100" value="Cập nhật"/>
                </div>
            </form>
        </div>
        <form action="updateFilm.html" form="filmform" method="POST" class="d-flex flex-column justify-content-center align-items-center rounded-sm p-3 bg-dark" style="width: 35vw">
            <input type="hidden" name="fId" value="${film.getfId()}"/>
            <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
                <label class="text-white">Tên Phim:</label>
                <input type="text" name="fName" placeholder="Tên Phim" value="${film.getfName()}" class="w-100 p-2 border border-warning rounded">
            </div>
            <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
                <label class="text-white">Nhà Sản Xuất:</label>
                <select name="fProducer" class="w-100 p-2 border border-warning rounded">
                    <c:forEach var="row" items="${producers}">
                        <c:if test="${row.getPrId() == film.getpId()}">
                            <option value="${row.getPrId()}" selected="selected">${row.getPrName()}</option>
                        </c:if>
                        <c:if test="${row.getPrId() != film.getpId()}">
                            <option value="${row.getPrId()}">${row.getPrName()}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
                <label class="text-white">Giới Hạn Độ Tuổi:</label>
                <input type="number" name="fAge" placeholder="Tuổi giới hạn" value="${film.getLimitAge()}" class="w-100 p-2 border border-warning rounded">
            </div>
            <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
                <label class="text-white">Thông Tin Phim:</label>
                <input name="fInfo" class="w-100 p-2 border border-warning rounded" value="${film.getDescription()}"/>
                <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
                    <label class="text-white">Ngày Phát Hành:</label>
                    <input type="date" name="fRelease" placeholder="Ngày phát hành" value="${film.getReleaseDate().toString()}" class="w-100 p-2 border border-warning rounded">
                </div>
                <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
                    <label class="text-white">Ngày Công Chiếu:</label>
                    <input type="date" name="fStartTime" placeholder="Ngày công chiếu" value="${film.getAirDate().toString()}" class="w-100 p-2 border border-warning rounded">
                </div>
                <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
                    <label class="text-white">Ngày Kết Thúc:</label>
                    <input type="date" name="fEndTime" placeholder="Ngày ngừng chiếu" value="${film.getEndDate().toString()}" class="w-100 p-2 border border-warning rounded">
                </div>
                <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
                    <input type="submit" class="btn btn-warning btn-lg w-100" value="Cập nhật"/>
                </div>
        </form>
    </div>
</div>
<%@include file="admin.footer.jsp" %>