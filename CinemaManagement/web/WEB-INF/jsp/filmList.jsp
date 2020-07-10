<%-- 
    Document   : filmList
    Created on : Jul 7, 2020, 4:21:26 PM
    Author     : phamq
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.FilmDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<link href="<c:url value="/resources/css/films.css"/>" rel="stylesheet"/>

<div class="container">
        <div class="col bg-white mt-2 mb-2">
            <div class="border-bottom mb-3">
                <h3 style="color: #ffd750;" class="p-3">PHIM MỚI</h3>
            </div>
            <div class="owl-carousel px-5 owl-theme bg-white">
                <%
                    FilmDAO fd = new FilmDAO();
                    ResultSet rs = fd.getAll();
                    while(rs.next()) {
                      int fId = rs.getInt("fId");
                      String imgLink = fd.getFilmPoster(fId);
                      out.print("<div class='item' style='width: 10rem; height: 20rem;'>");
                      out.print("<img src="+ imgLink +" alt='poster' class='w-100' />");
                      out.print("<a href='/cinemaManagement/films/film.html?id="+ fId +"'>");
                      out.print("<div class='overlay w-100 h-100 d-flex flex-column justify-content-center align-items-center'>");
                      out.print("<p class='detail'>Chi Tiết</p>");
                      out.print("</div>");
                      out.print("</a>");
                      out.print("</div>");
                    };
                %>
<!--                <div class="item" style="width: 10rem; height: 20rem;">
                    <img src="<c:url value="/resources/image/Em_chưa_18.jpg"/>" alt="poster" class="w-100" />
                    <a href="#">
                        <div class="overlay w-100 h-100 d-flex flex-column justify-content-center align-items-center">
                            <p class="detail">Chi Tiết</p>
                        </div>
                    </a>
                </div>
                <div class="item" style="width: 10rem; height: 20rem;">
                    <img src="<c:url value="/resources/image/Em_chưa_18.jpg"/>" alt="poster" class="w-100" />
                    <a href="#">
                        <div class="overlay w-100 h-100 d-flex flex-column justify-content-center align-items-center">
                            <p class="detail">Chi Tiết</p>
                        </div>
                    </a>
                </div>
                <div class="item" style="width: 10rem; height: 20rem;">
                    <img src="<c:url value="/resources/image/Em_chưa_18.jpg"/>" alt="poster" class="w-100" />
                    <a href="#">
                        <div class="overlay w-100 h-100 d-flex flex-column justify-content-center align-items-center">
                            <p class="detail">Chi Tiết</p>
                        </div>
                    </a>
                </div>
                <div class="item" style="width: 10rem; height: 20rem;">
                    <img src="<c:url value="/resources/image/Em_chưa_18.jpg"/>" alt="poster" class="w-100" />
                    <a href="#">
                        <div class="overlay w-100 h-100 d-flex flex-column justify-content-center align-items-center">
                            <p class="detail">Chi Tiết</p>
                        </div>
                    </a>
                </div>-->
            </div>
        </div>
        <div class="col bg-dark mt-2 mb-2 p-3">
            <div class="row p-3 rounded m-3">
                <h4><a class="p-3" style="color: #ffd750" href="#">PHIM ĐANG CHIẾU</a></h3>
                    <h4><a class="p-3" style="color: #ffd750" href="#">PHIM SẮP CHIẾU</a></h3>
            </div>
            <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-start">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1">Previous</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="#">T2</a></li>
                    <li class="page-item"><a class="page-link" href="#">T3</a></li>
                    <li class="page-item"><a class="page-link" href="#">T4</a></li>
                    <li class="page-item"><a class="page-link" href="#">T5</a></li>
                    <li class="page-item"><a class="page-link" href="#">T6</a></li>
                    <li class="page-item"><a class="page-link" href="#">T7</a></li>
                    <li class="page-item"><a class="page-link" href="#">CN</a></li>
                    <li class="page-item">
                        <a class="page-link" href="#">Next</a>
                    </li>
                </ul>
            </nav>
            <div class="col">
                <div class="row border bg-white rounded">
                    <div class="d-flex flex-column justify-content-center align-items-center col-md-2 col-12">
                        <img src="<c:url value="/resources/image/Em_chưa_18.jpg"/>" alt="poster" class="w-100" />
                    </div>
                    <div class="d-flex flex-column justify-content-center align-items-start col-10">
                        <div class="ml-5">
                            <h4 style="color: #635423;">TÊN PHIM</h4>
                            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Voluptas recusandae ab
                                provident rerum libero assumenda ad at aliquam quibusdam harum. Consequatur vel mollitia
                                in. Ab quas dignissimos deleniti minus exercitationem.</p>
                        </div>
                        <div class="ml-5">
                            <h5 style="color: #635423;">LỊCH CHIẾU</h5>
                            <div class="border row">
                                <button type="button" class="btn btn-secondary">
                                    8:30AM
                                    <br>
                                    64 ghế trống
                                </button>
                                <button type="button" class="btn btn-secondary">
                                    11:45AM
                                    <br>
                                    64 ghế trống
                                </button>
                                <button type="button" class="btn btn-secondary">
                                    13:00PM
                                    <br>
                                    64 ghế trống
                                </button>
                                <button type="button" class="btn btn-secondary">
                                    16:15PM
                                    <br>
                                    64 ghế trống
                                </button>
                                <button type="button" class="btn btn-secondary">
                                    19:30PM
                                    <br>
                                    64 ghế trống
                                </button>
                                <button type="button" class="btn btn-secondary">
                                    21:45PM
                                    <br>
                                    64 ghế trống
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col bg-dark rounded mt-2 mb-2">
            <h5 class="w-100 p-3" style="color: #ffd750">SẮP RA MẮT</h1>
            <div class="row bg-white border">
                <div class="col-12 col-md-6">
                    <h6 class="p-3">
                        <a href="#"  style="color: #635423;" >HÀNH ĐỘNG</a>
                        <a href="#"  style="color: #635423;">VIỄN TƯỞNG</a>
                    </h6>
                    <div class="d-flex flex-row justify-content-between align-items-center">
                        <h5 class="p-3" style="color: #635423;">TÊN PHIM</h5>
                        <h5 class="p-3" style="color: #635423;">NGÀY RA MẮT: 0/0/0</h5>
                    </div>
                    <div>
                        <p class="p-3" style="color: #635423;">Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt itaque unde veniam aliquam error et vel! Perferendis nam vero itaque ullam rem placeat ut nesciunt repellat quod, fuga dicta unde?</p>
                    </div>
                </div>
                <div class="col-12 col-md-6 text-center">
                    <div class="d-flex flex-row justify-content-center align-items-center p-3">
                        <iframe class="w-100" 
                                src="https://www.youtube.com/embed/watch?v=_affkHceSj4" 
                                frameborder="0"
                                allowfullscreen>
                        </iframe>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-3 col-md-4 col-6 d-flex flex-column justify-content-center align-items-center p-4">
                    <a href="#">
                        <img src="<c:url value="/resources/image/Em_chưa_18.jpg"/>" alt="poster" class="w-100" />
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6 d-flex flex-column justify-content-center align-items-center p-4">
                    <a href="#">
                        <img src="<c:url value="/resources/image/Em_chưa_18.jpg"/>" alt="poster" class="w-100" />
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6 d-flex flex-column justify-content-center align-items-center p-4">
                    <a href="#">
                        <img src="<c:url value="/resources/image/Em_chưa_18.jpg"/>" alt="poster" class="w-100" />
                    </a>
                </div>
                <div class="col-lg-3 col-md-4 col-6 d-flex flex-column justify-content-center align-items-center p-4">
                    <a href="#">
                        <img src="<c:url value="/resources/image/Em_chưa_18.jpg"/>" alt="poster" class="w-100" />
                    </a>
                </div>
            </div>
        </div>
    </div>
<%@include file="footer.jsp" %>
