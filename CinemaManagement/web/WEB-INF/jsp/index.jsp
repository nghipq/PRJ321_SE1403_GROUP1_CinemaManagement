<%@page import="DAO.FilmDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header.jsp" %>
<%    FilmDAO fd = new FilmDAO();
%>
<link href="<c:url value="/resources/css/home.css"/>" rel="stylesheet">
<div id="carouselExampleIndicators" class="carousel slide w-100" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" style="height: 40rem;">
        <>
        <div class="carousel-item active w-100 h-100">
            <img class="d-block w-100" src="<c:url value="/resources/image/cinema.jpg"/>" alt="First slide">
            <div class="carousel-caption">
                <h1 class="display-2">Asterism Cinema</h1>
                <h3>Hiện Đại</h3>
                <button type="button" class="btn btn-primary btn-lg">Đặt Vé</button>
            </div>
        </div>
        <div class="carousel-item w-100 h-100">
            <img class="d-block w-100" src="<c:url value="/resources/image/cinema1.jpg"/>" alt="Second sslide">
            <div class="carousel-caption">
                <h1 class="display-2">Asterism Cinema</h1>
                <h3>Sang Trọng</h3>
                <button id="idTICKET" type="button" class="btn btn-primary btn-lg">Đặt Vé</button>
            </div>
        </div>
        <div class="carousel-item w-100 h-100">
            <img class="d-block w-100" src="<c:url value="/resources/image/cinema2.jpg"/>" alt="Third slide">
            <div class="carousel-caption">
                <h1 class="display-2">Asterism Cinema</h1>
                <h3>Sạch Sẽ</h3>
                <button type="button" class="btn btn-primary btn-lg">Đặt Vé</button>
            </div>
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<div class="container">

    <div class="col bg-white mt-2 mb-2">
        <div class="border-bottom mb-3">
            <h3 style="color: #505050;" class="p-3">PHIM MỚI</h3>
        </div>
        <div class="owl-carousel px-5 owl-theme bg-white">

            <c:forEach var="film" items="${films}">

                <c:set var="fId" value="${film.getfId()}"/>
                <%
                    int fId = Integer.parseInt(pageContext.getAttribute("fId").toString());
                    String imgPath = "/resources/image/" + fd.getFilmPoster(fId);
                    pageContext.setAttribute("imgPath", imgPath);
                %>
                <div id="${film.getfId()}" class="item" style="width: 10rem; height: 15rem;">
                    <img src="<c:url value="${imgPath}"/>" alt="${film.getfName()}" class="w-100 h-100"/>
                    <a href="/cinemaManagement/films/film.html?id=${film.getfId()}">
                        <div class="overlay w-100 h-100 d-flex flex-column justify-content-center align-items-center">
                            <p class="detail">Chi Tiết</p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="col bg-white mt-2 mb-2">
        <div class="border-bottom mb-3">
            <h3 style="color: #505050;" class="p-3">SỰ KIỆN</h3>
        </div>
        <div class="owl-carousel px-5 owl-theme bg-white">
            <div class="item" style="width: 15rem; height: 12rem;">
                <img src="<c:url value="/resources/image/event1.png"/>" alt="event" class="w-100" />
            </div>
            <div class="item" style="width: 15rem; height: 12rem;">
                <img src="<c:url value="/resources/image/event2.png"/>" alt="event" class="w-100" />
            </div>
            <div class="item" style="width: 15rem; height: 12rem;">
                <img src="<c:url value="/resources/image/event3.jpg"/>" alt="event" class="w-100" />
            </div>
            <div class="item" style="width: 15rem; height: 12rem;">
                <img src="<c:url value="/resources/image/event4.jpg"/>" alt="event" class="w-100" />
            </div>
            <div class="item" style="width: 15rem; height: 12rem;">
                <img src="<c:url value="/resources/image/event5.jpg"/>" alt="event" class="w-100" />
            </div>
            <div class="item" style="width: 15rem; height: 12rem;">
                <img src="<c:url value="/resources/image/event6.jpg"/>" alt="event" class="w-100" />
            </div>
        </div>
    </div>
</div>
<% fd.closeConnect();%>
<%@include file="footer.jsp" %>