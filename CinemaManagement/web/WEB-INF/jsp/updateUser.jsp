<%-- 
    Document   : updateUser
    Created on : Jul 21, 2020, 1:08:17 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="d-flex flex-column justify-content-center align-items-center p-5" style="width: 100vw;">
    <form action="updateUser.html" method="POST">
        <div class="d-flex flex-column justify-content-center align-items-center p-5 w-100 rounded-sm m-5 bg-white">
            <strong class="text-warning" style="font-size: 40px">Cập nhật người dùng</strong>
            <input class="p-2" type="hidden" placeholder="Username" name="uId" value="${user.getuId()}" style="width: 25vw; height: 5vh">
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="text" placeholder="Username" name="UName" value="${user.getUsername()}" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="text" placeholder="Email" name="UEmail" value="${user.getEmail()}"  style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="date" placeholder="Birthday" name="UBirthday" value="${user.getBirthday()}" style="width: 25vw; height: 5vh">
            </div>

            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <div class="d-flex flex-row justify-content-start w-45">gender</div>
                <!--                <input class="pl-4" type="radio" id="male" name="Ugender" value="1">
                                <label for="male">Male</label>
                                <input type="radio" id="female" name="Ugender" value="0">
                                <label for="female">Female</label><br>-->
                <c:choose>
                    <c:when test="${user.getGender() == 0}">
                        <input class="pl-4" type="radio" id="male" name="Ugender" value="1">
                        <label for="male">Male</label>
                        <input type="radio" id="female" name="Ugender" value="0" checked>
                        <label for="female">Female</label><br>
                    </c:when>
                    <c:otherwise>
                        <input class="pl-4" type="radio" id="male" name="Ugender" value="1" checked>
                        <label for="male">Male</label>
                        <input type="radio" id="female" name="Ugender" value="0">
                        <label for="female">Female</label><br>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="text" placeholder="Address" name="UAddress" value="${user.getAddress()}" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="text" placeholder="Phone" name="UPhone" value="${user.getPhone()}" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="date" placeholder="Register Date" name="URegis" value="${user.getRegisDate()}" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <div class="d-flex flex-row justify-content-start w-45">Permission</div>
                <c:choose>
                    <c:when test="${user.getPremission() == 0}">
                        <input type="radio" id="User" name="UPermission" value="0" checked>
                        <label for="User">User</label>
                        <input type="radio" id="Staff" name="UPermission" value="1">
                        <label for="Staff">Staff</label>
                    </c:when>

                    <c:otherwise>
                        <input type="radio" id="User" name="UPermission" value="0">
                        <label for="User">User</label>
                        <input type="radio" id="Staff" name="UPermission" value="1" checked>
                        <label for="Staff">Staff</label>
                    </c:otherwise>
                </c:choose>
                <div class="d-flex flex-row justify-content-between align-items-center m-2">
                    <input type="submit" class="btn btn-warning btn-lg" value="Cập Nhật"/>
                </div>
            </div>


        </div>
    </form>
</div>