<%-- 
    Document   : addFilm
    Created on : Jul 21, 2020, 4:02:35 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="dashboard.jsp" %>
<!DOCTYPE html>

<%@include file="admin.header.jsp" %>
<div class="d-flex flex-column justify-content-center align-items-center">
    <div class="text-center bg-dark text-warning p-2 rounded-sm border border-warning m-2" style="width: 35vw">
        <strong style=" font-size: 2rem">Thêm phim mới</strong>
    </div>
    <form action="updateUser.html" method="POST">
        <div class="d-flex flex-column justify-content-center align-items-center p-5 rounded-sm m-2 bg-white" style="width: 35vw">
            <div class="d-flex flex-column justify-content-start align-items-center p-5" style="width: 80vw;">
                <div
                    class="d-flex flex-column justify-content-between align-items-center p-3 w-100 rounded-sm m-2">
                    <div
                        class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                        <input type="text" placeholder="Tên Phim">
                    </div>
                    <div
                        class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                        <input type="text" placeholder="ID nhà sản xuất">
                    </div>
                    <div
                        class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                        <input type="text" placeholder="Tuổi giới hạn">
                    </div>
                    <div
                        class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                        <input type="text" placeholder="Trạng thái phim">
                    </div>
                    <div
                        class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                        <input type="text" placeholder="Poster">
                    </div>
                    <div
                        class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                        <input type="textarea" placeholder="Thông tin phim">
                    </div>
                    <div
                        class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                        <input type="date" placeholder="Ngày phát hành">
                    </div>
                    <div
                        class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                        <input type="date" placeholder="Ngày công chiếu">
                    </div>
                    <div
                        class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                        <input type="date" placeholder="Ngày ngừng chiếu">
                    </div>
                    <div class="d-flex flex-row justify-content-between align-items-center m-2">
                        <button type="button" class="btn btn-warning btn-lg"><strong>Thêm</strong></button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<%@include file="admin.footer.jsp" %>

