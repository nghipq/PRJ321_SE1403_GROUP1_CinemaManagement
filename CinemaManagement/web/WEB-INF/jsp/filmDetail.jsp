<%-- 
    Document   : filmDetail
    Created on : Jul 9, 2020, 4:30:35 PM
    Author     : phamq
--%>

<%@page import="models.Scheldule"%>
<%@page import="org.springframework.scheduling.annotation.Scheduled"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.TicketDAO"%>
<%@page import="DAO.FilmDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<link href="<c:url value="/resources/css/Detail.css"/>" rel="stylesheet"/>
<div class="bg-white container mt-5">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-12">
                <%
                    FilmDAO fd = new FilmDAO();
                    String imgPath = "/resources/image/" + fd.getFilmPoster(Integer.parseInt(request.getParameter("id")));
                    pageContext.setAttribute("imgPath", imgPath);
                %>
                <img class="w-100" src="<c:url value="${imgPath}"/>" alt="poster"/>
            </div>
            <div class="col-md-8 col-12">
                <div class="title">${film.getfName()}</div>
                <div class="formality">
                    <label>Đạo Diễn:</label>
                    <a>${directors}</a>
                </div>
                <div class="formality">
                    <label>Diễn Viên:</label>
                    <a>${actors}</a>
                </div>
                <div class="formality">
                    <label>Thể Loại:</label>
                    <a>${categories}</a>
                </div>
                <!--                <div class="formality">
                                    <label>Độ dài:</label>
                                    <a>115 phút</a>
                                </div>-->
                <!--                <div class="formality">
                                    <label>Ngôn ngữ:</label>
                                    <a>Phụ đề tiếng Việt</a>
                                </div>-->
                <div class="formality">
                    <label>Ban Age:</label>
                    <a>${film.getLimitAge()}+ - Phim cấm khán giả dưới ${film.getLimitAge()} tuổi</a>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-12">
                <div class="attribute">
                    <label>Thông tin chi tiết phim </label>
                    <p>${film.getDescription()}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-12">
                <div class="days row">
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
                </div>

                <div class="showtime" >
                    <div>
                        <label class="showtime-text row">Lịch Chiếu: </label>
                    </div>
                    <div class="border row" >
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
    </div>
</div>
<%@include file="footer.jsp" %>