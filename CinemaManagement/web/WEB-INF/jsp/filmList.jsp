<%-- 
    Document   : filmList
    Created on : Jul 7, 2020, 4:21:26 PM
    Author     : phamq
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DAO.TicketDAO"%>
<%@page import="DAO.ScheduleDAO"%>
<%@page import="models.Scheldule"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="DAO.FilmDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<link href="<c:url value="/resources/css/film.css"/>" rel="stylesheet"/>

<div class="container">
    <div class="col bg-white mt-2 mb-2">
        <div class="border-bottom mb-3">
            <h3 style="color: #ffd750;" class="p-3">PHIM MỚI</h3>
        </div>
        <div class="owl-carousel px-5 owl-theme bg-white">
            <c:forEach var="film" items="${films}">
                <div class="item" style="width: 10rem; height: 15rem;">
                    <c:set var="fId" value="${film.getfId()}"/>
                    <%
                        int fId = Integer.parseInt(pageContext.getAttribute("fId").toString());
                        String imgPath = "/resources/image/" + new FilmDAO().getFilmPoster(fId);
                        pageContext.setAttribute("imgPath", imgPath);
                    %>
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
    <div class="col bg-dark mt-2 mb-2 p-3">
        <div class="row rounded m-3">
            <h4 style="color: #ffd750">PHIM ĐANG CHIẾU</h4>
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
            <c:forEach var="film" items="${films}">
                <div class="row border bg-white rounded m-3">
                    <div class="d-flex flex-column justify-content-center align-items-center col-md-2 col-12">
                        <c:set var="fId" value="${film.getfId()}"/>
                        <%
                            int fId1 = Integer.parseInt(pageContext.getAttribute("fId").toString());
                            String imgPath1 = "/resources/image/" + new FilmDAO().getFilmPoster(fId1);
                            pageContext.setAttribute("imgPath", imgPath1);
                        %>
                        <img src="<c:url value="${imgPath}"/>" alt="${film.getfName()}" class="w-100 h-100"/>
                    </div>
                    <div class="d-flex flex-column justify-content-center align-items-start col-10">
                        <div class="ml-5">
                            <h4 style="color: #635423;">${film.getfName()}</h4>
                            <p>${film.getDescription()}</p>
                        </div>
                        <div class="ml-5">
                            <h5 style="color: #635423;">LỊCH CHIẾU</h5>
                            <div class="border row p-2">
                                <%
                                    ScheduleDAO sd = new ScheduleDAO();
                                    HashMap<Integer, Scheldule> schedules = sd.getSchedulesDetail(Integer.parseInt(pageContext.getAttribute("fId").toString()));
                                    pageContext.setAttribute("schedules", schedules);
                                %>
                                <c:forEach var="schedule" items="${schedules}">
                                    <a href="/cinemaManagement/room.html?rId=${schedule.value.getrId()}&scheId=${schedule.key}&fId=${schedule.value.getfId()}">
                                        <button type="button" class="btn btn-secondary">                            
                                            <c:set var="sesId" value="${schedule.value.getSesId()}"/>
                                            <c:set var="scheId" value="${schedule.value.getScheId()}"/>
                                            <%
                                                TicketDAO td = new TicketDAO();
                                                int sesId = Integer.parseInt(pageContext.getAttribute("sesId").toString());
                                                int scheId = Integer.parseInt(pageContext.getAttribute("scheId").toString());
                                                ArrayList<String> details = td.getDetail(sesId, scheId);
                                                pageContext.setAttribute("details", details);
                                            %>
                                            ${details.get(0)}<br/>
                                            ${details.get(1)}
                                        </button>
                                    </a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="col bg-dark rounded mt-2 mb-2">
        <h4 class="w-100 p-3" style="color: #ffd750">SẮP RA MẮT</h4>
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
