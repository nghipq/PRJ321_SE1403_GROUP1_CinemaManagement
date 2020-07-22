<%-- 
    Document   : updateShowtimes
    Created on : Jul 22, 2020, 1:20:57 PM
    Author     : GF63 8RD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="admin.header.jsp" %>
<div class="d-flex flex-row justify-content-center align-items-center">
    <%@include file="dashboard.jsp" %>
    <div class="d-flex flex-column justify-content-between align-items-center p-5" style="width: 100vw;">
        <div class="bg-dark border border-warning p-3 m-2 rounded-sm" style="width: 30vw">
            <h1 class="text-center text-warning w-100">Thêm lịch chiếu</h1>
        </div>
        <form action="updateSuccess.html" method="POST" class="m-2 rounded-sm" style="width: 30vw">
            <input type="hidden" placeholder="Id" name="sId" value="${fId}">
            <div class="d-flex flex-column justify-content-between align-items-center w-100 rounded-sm">
                <div class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm">
                    <input type="number" placeholder="Rạp" name="sRoom" class="w-100">
                </div>
                <div class="d-flex flex-row justify-content-between align-items-centers w-100 rounded-sm">
                    <input type="date" placeholder="Ngày chiếu" name="sDate" class="w-100">
                </div>
                <div class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm">
                    <input type="time" placeholder="Giờ bắt đầu" name="sStart" class="w-100">
                </div>
                <div class="d-flex flex-row justify-content-between align-items-center w-100 rounded-sm">
                    <input type="time" placeholder="Giờ kết thúc" name="sEnd" class="w-100">
                </div>
                <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm bg-white">
                    <div class="d-flex flex-row justify-content-start w-100">Thể loại</div>
                    <input type="radio" id="Staff" name="fmName" value="1" checked>
                    <label for="2D">2D</label><br>
                    <input type="radio" id="Staff" name="fmName" value="2">
                    <label for="3D">3D</label><br>
                </div>
                <div class="d-flex flex-row justify-content-between align-items-center w-100">
                    <input type="submit" class="btn btn-warning btn-lg w-100" value="Thêm"/>
                </div>
            </div>
        </form>
    </div>
</div>
<%@include file="admin.footer.jsp" %>
