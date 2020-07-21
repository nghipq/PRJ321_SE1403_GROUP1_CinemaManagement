<%-- 
    Document   : dashboard
    Created on : Jul 21, 2020, 1:29:59 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-light bg-dark flex-column p-0" style="width: 20vw; height: 100vh;">
        <img src="<c:url value="/resources/image/Capture.PNG (2).png"/>"style="width: 60%">
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
                    <a class="nav-link text-white" href="#">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Danh sách hóa đơn</span>
                    </a>
                </li>
                <li class="nav-item active p-3 pl-4">
                    <a class="nav-link text-white" href="userList.html">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Danh sách người dùng</span> 
                    </a>
                </li>
                <li class="nav-item p-3 pl-4">
                    <a class="nav-link text-white" href="#">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Danh sách lịch chiếu</span>
                    </a>
                </li>
                <li class="nav-item p-3 pl-4">
                    <a class="nav-link text-white" href="#">Thoát</a>
                </li>
            </ul>
        </div>
    </nav>