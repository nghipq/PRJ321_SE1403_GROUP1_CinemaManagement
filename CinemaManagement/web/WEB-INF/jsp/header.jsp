<%-- 
    Document   : header
    Created on : Jul 6, 2020, 5:17:31 PM
    Author     : GF63 8RD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Asterism Cinema</title>
    <!-- Import Boostrap css, js, font awesome here -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value="/resources/public/OwlCarousel2-2.3.4/dist/assets/owl.carousel.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/public/OwlCarousel2-2.3.4/dist/assets/owl.theme.default.min.css"/>"/>
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
</head>

<body>
    <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
        <div class="container-fluid">
            <a class="navbar-branch" href="/cinemaManagement/" onclick="window.location.reload();">
                <img src="<c:url value="/resources/image/Capture.PNG (2).png"/>" height="100">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="/cinemaManagement/" onclick="window.location.reload();">Trang Chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/cinemaManagement/films.html">Phim</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/cinemaManagement/bill/billList.html">Danh Sách Hóa Đơn</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Liên Hệ</a>
                    </li>
                    <%

                        Cookie[] cookies = null;
                        // Get an array of Cookies associated with the this domain
                        cookies = request.getCookies();

                        if (cookies.length > 1) {

                            for (Cookie cookie : cookies) {
                                if (cookie.getName().equals("Name")) {
                                    out.print("<li class='nav-item'>");
                                    out.print("<a class='nav-link' href='#'>" + cookie.getValue() + "</a>");
                                    out.print("</li>");
                                    out.print("<li class='nav-item'>");
                                    out.print("<a class='nav-link' href='/cinemaManagement/auth/logout.html'>Đăng Xuất</a>");
                                    out.print("</li>");
                                }
                            }
                        } else {
                            out.print("<li class='nav-item'>");
                            out.print("<a class='nav-link' href='/cinemaManagement/auth.html'>Đăng Nhập</a>");
                            out.print("</li>");
                        }
                    %>
                </ul>
            </div>
        </div>
    </nav>
    <div class="web-body">


