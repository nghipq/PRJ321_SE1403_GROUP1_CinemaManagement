<%-- 
    Document   : updateUser
    Created on : Jul 21, 2020, 1:08:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<div class="d-flex flex-column justify-content-center align-items-center p-5" style="width: 100vw;">
    <form action="#">
        <div class="d-flex flex-column justify-content-center align-items-center p-5 w-100 rounded-sm m-5 bg-white">
            <strong class="text-warning" style="font-size: 40px">Cập nhật người dùng</strong>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="text" placeholder="Username" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="text" placeholder="Email" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="text" placeholder="Birthday" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="text" placeholder="Nationality" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <p>Gender</p>
                <input type="radio" id="male" name="gender" value="1">
                <label for="male">Male</label><br>
                <input type="radio" id="female" name="gender" value="0">
                <label for="female">Female</label><br>
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="text" placeholder="Address" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="text" placeholder="Phone" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="textarea" placeholder="Register Date" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="date" placeholder="Permission" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-between align-items-center m-2">
                <button type="button" class="btn btn-warning btn-lg"><strong>Cập nhật</strong></button>
            </div>
        </div>
    </form>
</div>
<%@include file="footer.jsp" %>