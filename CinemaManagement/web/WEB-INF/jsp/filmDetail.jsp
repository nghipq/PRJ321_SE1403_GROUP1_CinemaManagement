<%-- 
    Document   : filmDetail
    Created on : Jul 9, 2020, 4:30:35 PM
    Author     : phamq
--%>

<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="models.Scheldule"%>
<%@page import="org.springframework.scheduling.annotation.Scheduled"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<link href="<c:url value="/resources/css/Detail.css"/>" rel="stylesheet"/>
<%  FilmDAO fd = new FilmDAO();
    TicketDAO td = new TicketDAO();
%>
<div class="bg-white container mt-5">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-12">
                <%
                    String imgPath = "/resources/image/" + fd.getFilmPoster(Integer.parseInt(request.getParameter("id")));
                    pageContext.setAttribute("imgPath", imgPath);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat eFormat = new SimpleDateFormat("E");
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
                            <%
                                Calendar eCal = Calendar.getInstance();
                                eCal.setTime(new Date());
                            %>
                            <li class="page-item"><a class="page-link" href="?date=0&id=${film.getfId()}"><%=eFormat.format(eCal.getTime())%></a></li>
                                <%
                                    eCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
                                %>
                            <li class="page-item"><a class="page-link" href="?date=1&id=${film.getfId()}"><%=eFormat.format(eCal.getTime())%></a></li>
                                <%
                                    eCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
                                %>
                            <li class="page-item"><a class="page-link" href="?date=2&id=${film.getfId()}"><%=eFormat.format(eCal.getTime())%></a></li>
                                <%
                                    eCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
                                %>
                            <li class="page-item"><a class="page-link" href="?date=3&id=${film.getfId()}"><%=eFormat.format(eCal.getTime())%></a></li>
                                <%
                                    eCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
                                %>
                            <li class="page-item"><a class="page-link" href="?date=4&id=${film.getfId()}"><%=eFormat.format(eCal.getTime())%></a></li>
                                <%
                                    eCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
                                %>
                            <li class="page-item"><a class="page-link" href="?date=5&id=${film.getfId()}"><%=eFormat.format(eCal.getTime())%></a></li>
                                <%
                                    eCal.add(GregorianCalendar.DAY_OF_MONTH, 1);
                                %>
                            <li class="page-item"><a class="page-link" href="?date=6&id=${film.getfId()}"><%=eFormat.format(eCal.getTime())%></a></li>
                        </ul>
                    </nav>
                </div>

                <div class="showtime" >
                    <div>
                        <label class="showtime-text row">Lịch Chiếu: </label>
                    </div>
                    <div class="border row" >
                        <c:forEach var="schedule" items="${schedules}">
                            <a href="/room.html?rId=${schedule.value.getrId()}&scheId=${schedule.key}&fId=${schedule.value.getfId()}">
                                <button type="button" class="btn btn-secondary">                            
                                    <c:set var="sesId" value="${schedule.value.getSesId()}"/>
                                    <c:set var="scheId" value="${schedule.value.getScheId()}"/>
                                    <%
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
<%
    fd.closeConnect();
    td.closeConnect();
%>
<%@include file="footer.jsp" %>