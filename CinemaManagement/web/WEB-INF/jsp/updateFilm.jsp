<%-- 
    Document   : updateFilm
    Created on : Jul 22, 2020, 1:07:31 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="d-flex flex-column justify-content-center align-items-center p-5" style="width: 100vw;">
    <form action="updateFilm.html" method="POST">
        <div class="d-flex flex-column justify-content-center align-items-center p-5 w-100 rounded-sm m-5 bg-white">
            <strong class="text-warning" style="font-size: 40px">Cập nhật phim</strong>
            <input class="p-2" type="hidden" placeholder="STT" name="uId" value="${user.getuId()}" style="width: 25vw; height: 5vh">
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="text" placeholder="Tên phim" name="FName" value="${user.getUsername()}" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="number" placeholder="Tuổi giới hạn" name="FAge" value="${user.getEmail()}"  style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="date" placeholder="Ngày phát hành" name="FRelease" value="${user.getBirthday()}" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="date" placeholder="Ngày công chiếu" name="FAir" value="${user.getBirthday()}" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <input class="p-2" type="date" placeholder="Ngày ngừng chiếu" name="FEnd" value="${user.getBirthday()}" style="width: 25vw; height: 5vh">
            </div>
            <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
                <div class="d-flex flex-row justify-content-start w-45">Trạng thái</div>
                <c:choose>
                    <c:when test="${user.getGender() == 0}">
                        <input class="pl-4" type="radio" id="onl" name="FStatus" value="1">
                        <label for="onl">Đang hoạt độngg</label>
                        <input type="radio" id="onl" name="FStatus" value="0" checked>
                        <label for="off">Dừng hoạt động</label><br>
                    </c:when>
                    <c:otherwise>
                        <input class="pl-4" type="radio" id="onl" name="FStatus" value="1" checked>
                        <label for="onl">Đang hoạt động</label>
                        <input type="radio" id="off" name="FStatus" value="0">
                        <label for="off">Dừng hoạt động</label><br>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form>
</div>
