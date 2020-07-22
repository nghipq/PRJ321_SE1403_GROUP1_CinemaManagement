<%-- 
    Document   : addFilm
    Created on : Jul 21, 2020, 4:02:35 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="admin.header.jsp" %>
<%@include file="dashboard.jsp" %>
<div class="d-flex flex-column justify-content-center align-items-center" style="width: 75vw">
    <div class="text-center bg-dark text-warning p-2 rounded-sm border border-warning m-2" style="width: 35vw">
        <strong style=" font-size: 2rem">Thêm phim mới</strong>
    </div>
    <form name="filmform" action="insertFilm.html" method="POST" class="d-flex flex-column justify-content-center align-items-center rounded-sm p-3 bg-dark" style="width: 35vw">
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Tên Phim:</label>
            <input type="text" name="fName" placeholder="Tên Phim" class="w-100 p-2 border border-warning rounded">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Nhà Sản Xuất:</label>
            <input type="text" name="fProducer" placeholder="ID nhà sản xuất" class="w-100 p-2 border border-warning rounded">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Giới Hạn Độ Tuổi:</label>
            <input type="number" name="fAge" placeholder="Tuổi giới hạn" class="w-100 p-2 border border-warning rounded">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Thông Tin Phim:</label>
            <input type="text" name="fInfo" class="w-100 p-2 border border-warning rounded" placeholder="Thông tin phim">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Ngày Phát Hành:</label>
            <input type="date" name="fRelease" placeholder="Ngày phát hành" class="w-100 p-2 border border-warning rounded">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Ngày Công Chiếu:</label>
            <input type="date" name="fStartTime" placeholder="Ngày công chiếu" class="w-100 p-2 border border-warning rounded">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Ngày Kết Thúc:</label>
            <input type="date" name="fEndTime" placeholder="Ngày ngừng chiếu" class="w-100 p-2 border border-warning rounded">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <input type="submit" class="btn btn-warning btn-lg w-100" value="Thêm phim"/>
        </div>
    </form>
</div>
<%@include file="admin.footer.jsp" %>

