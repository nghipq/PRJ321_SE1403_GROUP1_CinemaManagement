<%-- 
    Document   : updateShowtimes
    Created on : Jul 22, 2020, 1:20:57 PM
    Author     : GF63 8RD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
    <div class="d-flex flex-column justify-content-between align-items-center p-5" style="width: 100vw;">
        <form action="#">
            <h1 style="text-align: center;">Thêm lịch chiếu</h1>
            <div class="d-flex flex-column justify-content-between align-items-center p-3 w-100 rounded-sm m-2">
                <div class="d-flex flex-row justify-content-between align-items-center w-200 rounded-sm m-2">
                    <input type="date" placeholder="Ngày chiếu">
                </div>
                <div class="d-flex flex-row justify-content-between align-items-center w-200 rounded-sm m-2">
                    <input type="time" placeholder="Giờ bắt đầu">
                </div>
                <div class="d-flex flex-row justify-content-between align-items-center w-200 rounded-sm m-2">
                    <input type="time" placeholder="Giờ kết thúc">
                </div>
                <div class="d-flex flex-row justify-content-between align-items-center m-2">
                    <button type="button" class="btn btn-warning btn-lg"><strong>Thêm</strong></button>
                </div>
            </div>
        </form>
    </div>
<%@include file="footer.jsp" %>
