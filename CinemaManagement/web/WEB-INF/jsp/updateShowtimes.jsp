<%-- 
    Document   : updateShowtimes
    Created on : Jul 22, 2020, 1:20:57 PM
    Author     : GF63 8RD
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="admin.header.jsp" %>
<%@include file="dashboard.jsp" %>
<div class="d-flex flex-column justify-content-center align-items-center" style="width: 75vw">
    <div class="text-center bg-dark text-warning p-2 rounded-sm border border-warning m-2" style="width: 35vw">
        <strong style=" font-size: 2rem">Thêm Lịch Chiếu</strong>
    </div>
    <form action="updateSuccess.html" method="POST" class="d-flex flex-column justify-content-center align-items-center rounded-sm p-3 bg-dark" style="width: 35vw">
        <input type="hidden" placeholder="Id" name="sId" value="${fId}">
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Rạp:</label>
            <select class="w-100 p-2 border border-warning rounded" name="sRoom">
                <c:forEach var="item" items="${rooms}">
                    <option value="${item.getrId()}">${item.getrId()}</option>
                </c:forEach>
            </select>
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Ngày chiếu:</label>
            <input type="date" placeholder="Ngày chiếu" name="sDate" class="w-100 p-2 border border-warning rounded">
        </div>
        <div class="d-flex flex-row justify-content-between align-items-center w-100">
            <div class="d-flex flex-column justify-content-center align-items-start w-100 m-2">
                <label class="text-white">Giờ bắt đầu:</label>
                <input type="time" placeholder="Giờ bắt đầu" name="sStart" class="w-100 p-2 border border-warning rounded">
            </div>
            <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 m-2">
                <label class="text-white">Giờ kết thúc:</label>
                <input type="time" placeholder="Giờ kết thúc" name="sEnd" class="w-100 p-2 border border-warning rounded ">
            </div>
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Thể loại:</label>
            <div>
                <input type="radio" id="Staff" name="fmName" value="1" checked>
                <label class="text-white" for="2D">2D</label><br>
                <input type="radio" id="Staff" name="fmName" value="2">
                <label class="text-white" for="3D">3D</label><br>
            </div>
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <input type="submit" class="btn btn-warning btn-lg w-100" value="Thêm"/>
        </div>
    </form>
</div>
<%@include file="admin.footer.jsp" %>
