<%-- 
    Document   : updateBill
    Created on : Jul 23, 2020, 12:39:32 PM
    Author     : phamq
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="admin.header.jsp" %>
<%@include file="dashboard.jsp" %>
<div class="d-flex flex-column justify-content-center align-items-center" style="width: 75vw">
    <div class="text-center bg-dark text-warning p-2 rounded-sm border border-warning m-2" style="width: 35vw">
        <strong style=" font-size: 2rem">Cập Nhật Hóa Đơn</strong>
    </div>
    <form action="updateBill.html" method="POST" class="d-flex flex-column justify-content-center align-items-center rounded-sm p-3 bg-dark" style="width: 35vw">
        <input class="p-2" type="hidden" name="bId" value="${bill.getbId()}" style="width: 25vw; height: 5vh">
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Tên người đặt:</label>
            <input class="w-100 p-2 border border-warning rounded" type="text" placeholder="Tên Người Đặt" name="bName" value="${bill.getName()}" style="width: 25vw; height: 5vh">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">SĐT:</label>
            <input class="w-100 p-2 border border-warning rounded" type="text" placeholder="Số điện thoại" name="bPhone" value="${bill.getPhone()}"  style="width: 25vw; height: 5vh">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Tổng tiền:</label>
            <input class="w-100 p-2 border border-warning rounded" type="number" placeholder="Tổng tiền" name="bTotal" value="${bill.getTotal()}" style="width: 25vw; height: 5vh" readonly>
        </div>

        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Tình trạng:</label>
            <div class="pr-3">
                <c:choose>
                    <c:when test="${bill.getStatus() == 0}">
                        <input class="pl-4" type="radio" id="male" name="bStatus" value="1">
                        <label class="text-white" for="male">Đã Thanh Toán</label>
                        <input type="radio" id="female"  name="bStatus" value="0" checked>
                        <label class="text-white" for="female">Chưa Thanh Toán</label><br>
                    </c:when>

                    <c:otherwise>
                        <input class="pl-4" type="radio" id="male" name="bStatus" value="1" checked>
                        <label class="text-white" for="male">Đã Thanh Toán</label>
                        <input type="radio" id="female"  name="bStatus" value="0">
                        <label class="text-white" for="female">Chưa Thanh Toán</label><br>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        

        <div class="d-flex flex-row justify-content-between align-items-center m-2 w-100">
            <input type="submit" id="update_bill" class="btn btn-warning btn-lg w-100" value="Cập Nhật"/>
        </div>
    </form>
</div>
<%@include file="admin.footer.jsp" %>