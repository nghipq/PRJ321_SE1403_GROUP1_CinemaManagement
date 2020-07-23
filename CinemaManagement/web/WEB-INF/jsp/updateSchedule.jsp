<%-- 
    Document   : updateSchedule
    Created on : Jul 23, 2020, 7:55:59 PM
    Author     : phamq
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="admin.header.jsp" %>
<%@include file="dashboard.jsp" %>
<div class="d-flex flex-column justify-content-center align-items-center" style="width: 75vw">
    <div class="text-center bg-dark text-warning p-2 rounded-sm border border-warning m-2" style="width: 35vw">
        <strong style=" font-size: 2rem">Cập Nhật Lịch Chiếu</strong>
    </div>
    <form action="updateSchedule.html" method="POST" class="d-flex flex-column justify-content-center align-items-center rounded-sm p-3 bg-dark" style="width: 35vw">
        <input type="hidden" name ="scheId" value="${schedule.getScheId()}"/>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Rạp:</label>
            <input type="number" placeholder="Rạp" name="sRoom" class="w-100 p-2 border border-warning rounded" value="${schedule.getrId()}">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Ngày chiếu:</label>
            <input type="date" placeholder="Ngày chiếu" name="sDate" class="w-100 p-2 border border-warning rounded" value="${schedule.getsDate()}">
        </div>
        <div class="d-flex flex-row justify-content-between align-items-center w-100">
            <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
                <label class="text-white">Giờ bắt đầu:</label>
                <input type="time" placeholder="Giờ bắt đầu" name="sStart" class="w-100 p-2 border border-warning rounded" value="${session.getStartTime()}">
            </div>
            <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
                <label class="text-white">Giờ kết thúc:</label>
                <input type="time" placeholder="Giờ kết thúc" name="sEnd" class="w-100 p-2 border border-warning rounded" value="${session.getEndTime()}">
            </div>
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Thể loại:</label>
            <div>
                <c:choose>
                    <c:when test="${schedule.getFmId() == 1}">
                        <input type="radio" id="Staff" name="fmName" value="1" checked>
                        <label class="text-white" for="2D">2D</label><br>
                        <input type="radio" id="Staff" name="fmName" value="2">
                        <label class="text-white" for="3D">3D</label><br>
                    </c:when>
                    <c:otherwise>
                        <input type="radio" id="Staff" name="fmName" value="1">
                        <label class="text-white" for="2D">2D</label><br>
                        <input type="radio" id="Staff" name="fmName" value="2" checked="">
                        <label class="text-white" for="3D">3D</label><br>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <input type="submit" class="btn btn-warning btn-lg w-100" value="Thêm"/>
        </div>
    </form>
</div>
<%@include file="admin.footer.jsp" %>
