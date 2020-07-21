<%-- 
    Document   : updateUser
    Created on : Jul 21, 2020, 1:08:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<div class="d-flex flex-column justify-content-start align-items-center p-5" style="width: 80vw;">
    <form action="#">
        <h1>Thêm phim mới</h1>
        <div class="d-flex flex-column justify-content-between align-items-center p-3 w-100 rounded-sm m-2">
            <div class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                <input type="text" placeholder="Username">
            </div>
            <div class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                <input type="text" placeholder="Email">
            </div>
            <div class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                <input type="text" placeholder="Birthday">
            </div>
            <div class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                <input type="text" placeholder="Gender">
            </div>
            <div class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                <input type="text" placeholder="Address">
            </div>
            <div class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                <input type="text" placeholder="Phone">
            </div>
            <div class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                <input type="textarea" placeholder="">
            </div>
            <div class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                <input type="date" placeholder="Ngày phát hành">
            </div>
            <div class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                <input type="date" placeholder="Ngày công chiếu">
            </div>
            <div class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm m-2">
                <input type="date" placeholder="Ngày ngừng chiếu">
            </div>
            <div class="d-flex flex-row justify-content-between align-items-center m-2">
                <button type="button" class="btn btn-warning btn-lg"><strong>Thêm</strong></button>
            </div>
        </div>
    </form>
</div>
<%@include file="footer.jsp" %>