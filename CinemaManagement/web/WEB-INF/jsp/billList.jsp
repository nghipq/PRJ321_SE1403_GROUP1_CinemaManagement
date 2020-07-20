<%-- 
    Document   : bills
    Created on : Jul 7, 2020, 4:30:18 PM
    Author     : phamq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<!DOCTYPE html>
<link href="<c:url value="/resources/css/admin.filmList.css"/>" rel="stylesheet"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
        integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<div class="d-flex flex-row">
    <nav class="navbar navbar-expand-lg navbar-light bg-dark flex-column p-0" style="width: 20vw; height: 100vh;">
        <img src="image/Capture.PNG (2).png" alt="image-film" style="width: 60%">
        <a class="navbar-brand text-white" href="#">Admin name</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse flex-column w-100" id="navbarNav">
            <ul class="navbar-nav flex-column w-100">
                <li class="nav-item p-3 pl-4">
                    <a class="nav-link text-white" href="filmList.html">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Danh sách phim</span>
                    </a>
                </li>
                <li class="nav-item p-3 pl-4">
                    <a class="nav-link text-white" href="addFilm.html">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Thêm phim</span>
                    </a>
                </li>
                <li class="nav-item p-3 pl-4">
                    <a class="nav-link text-white" href="updateFilm.html">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Cập nhật phim</span>
                    </a>
                </li>
                <li class="nav-item active p-3 pl-4">
                    <a class="nav-link text-white" href="billList.html">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Danh sách hóa đơn</span>
                    </a>
                </li>
                <li class="nav-item active p-3 pl-4">
                    <a class="nav-link text-white" href="customerList.html">Danh sách người dùng</a>
                </li>
                <li class="nav-item p-3 pl-4">
                    <a class="nav-link text-white" href="#">Thoát</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="d-block flex-column justify-content-start align-items-start p-5" style="width: 80vw;">
        <div class="d-flex flex-row justify-content-between align-items-start p-3 w-100 border border-warning rounded-sm m-2 bg-dark text-warning"
            style="font-size: 1.4rem;">
            <div>
                <strong class="">User Name</strong>
            </div>
            <div>
                <strong>Film Name</strong>
            </div>
            <div>
                <strong>Position</strong>
            </div>
            <div>
                <strong>Time</strong>
            </div>
            <div>
                <strong>Status Bill</strong>
            </div>
        </div>

        <div
            class="d-flex flex-row justify-content-between align-items-center p-2 mt-4 w-100 border border-white rounded-sm m-2 bg-white text-dark">
            <div>
                <strong>Username</strong>
            </div>
            <div>
                <strong>Name of Film</strong>
            </div>
            <div>
                <strong>Id chair</strong>
            </div>
            <div>
                <strong>18:00</strong>
            </div>
            <div class="border border-danger text-danger p-1">
                <strong>Status Bill</strong>
            </div>
        </div>
        <div
            class="d-flex flex-row justify-content-between align-items-center p-2 mt-4 w-100 border border-white rounded-sm m-2 bg-white text-dark">
            <div class="container">
                <button type="button" class="btn btn-warning btn-lg"><strong>Change Page</strong></button>
            </div>
        </div>
    </div>

</div>
<%@include file="footer.jsp" %>