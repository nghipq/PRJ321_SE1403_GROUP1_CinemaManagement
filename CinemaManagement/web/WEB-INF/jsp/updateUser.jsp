<%-- 
    Document   : updateUser
    Created on : Jul 21, 2020, 1:08:17 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="admin.header.jsp" %>
<%@include file="dashboard.jsp" %>
<div class="d-flex flex-column justify-content-center align-items-center" style="width: 75vw">
    <div class="text-center bg-dark text-warning p-2 rounded-sm border border-warning m-2" style="width: 35vw">
        <strong style=" font-size: 2rem">Cập Nhật Người Dùng</strong>
    </div>
    <form action="updateUser.html" method="POST" class="d-flex flex-column justify-content-center align-items-center rounded-sm p-3 bg-dark" style="width: 35vw">

        <input class="p-2" type="hidden" placeholder="Username" name="uId" value="${user.getuId()}" style="width: 25vw; height: 5vh">
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Tên:</label>
            <input class="w-100 p-2 border border-warning rounded" type="text" placeholder="Username" name="UName" value="${user.getUsername()}" style="width: 25vw; height: 5vh">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Email:</label>
            <input class="w-100 p-2 border border-warning rounded" type="text" placeholder="Email" name="UEmail" value="${user.getEmail()}"  style="width: 25vw; height: 5vh">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Ngày sinh:</label>
            <input class="w-100 p-2 border border-warning rounded" type="date" placeholder="Birthday" name="UBirthday" value="${user.getBirthday()}" style="width: 25vw; height: 5vh">
        </div>

        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Giới tính:</label>
            <div class="pr-3">
                <c:choose>
                    <c:when test="${user.getGender() == 0}">
                        <input class="pl-4" type="radio" id="male" name="Ugender" value="1">
                        <label class="text-white" for="male">Male</label>
                        <input type="radio" id="female" name="Ugender" value="0" checked>
                        <label class="text-white" for="female">Female</label><br>
                    </c:when>

                    <c:otherwise>
                        <input class="pl-4" type="radio" id="male" name="Ugender" value="1" checked>
                        <label class="text-white" for="male">Male</label>
                        <input type="radio" id="female" name="Ugender" value="0">
                        <label class="text-white" for="female">Female</label><br>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Địa chỉ:</label>
            <input class="w-100 p-2 border border-warning rounded" type="text" placeholder="Address" name="UAddress" value="${user.getAddress()}" style="width: 25vw; height: 5vh">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">SĐT:</label>
            <input class="w-100 p-2 border border-warning rounded" type="text" placeholder="Phone" name="UPhone" value="${user.getPhone()}" style="width: 25vw; height: 5vh">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Ngày đăng ký:</label>
            <input class="w-100 p-2 border border-warning rounded" type="date" placeholder="Register Date" name="URegis" value="${user.getRegisDate()}" style="width: 25vw; height: 5vh">
        </div>
        <div class="d-flex flex-column justify-content-center align-items-start w-100 mt-2 mb-2">
            <label class="text-white">Quyền:</label>
            <div class="pr-3">
                <c:choose>
                    <c:when test="${user.getPremission() == 0}">
                        <input type="radio" id="User" name="UPermission" value="0" checked>
                        <label class="text-white" for="User">User</label>
                        <input type="radio" id="Staff" name="UPermission" value="1">
                        <label class="text-white" for="Staff">Staff</label><br>
                    </c:when>

                    <c:otherwise>
                        <input type="radio" id="User" name="UPermission" value="0">
                        <label class="text-white" for="User">User</label>
                        <input type="radio" id="Staff" name="UPermission" value="1" checked>
                        <label class="text-white" for="Staff">Staff</label><br/>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <div class="d-flex flex-row justify-content-between align-items-center m-2 w-100">
            <input type="submit" class="btn btn-warning btn-lg w-100" value="Cập Nhật"/>
        </div>
    </form>
</div>
<%@include file="admin.footer.jsp" %>