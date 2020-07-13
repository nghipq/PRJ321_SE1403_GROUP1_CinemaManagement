<%-- 
    Document   : room
    Created on : Jul 10, 2020, 9:51:33 AM
    Author     : phamq
--%>

<%@page import="DAO.FilmDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<link href="<c:url value="/resources/css/booking.css"/>"/>
<div class="container">
    <div class="bg-dark col-12 row p-3 rounded mt-2">
        <h3 style="color: #ffd750;" class="text-center w-100">BOOKING ONLINE</h3>
        <h5 style="color: #ffd750;" class="text-center w-100">Rạp ${rId}</h5>
    </div>
    <div class="bg-white col-12 row p-3 rounded mb-2">
        <div class="col-md-4 col-2 d-none d-lg-flex">
            <%
                FilmDAO fd = new FilmDAO();
                String imgPath = "/resources/image/" + fd.getFilmPoster(Integer.parseInt(request.getParameter("fId")));
                pageContext.setAttribute("imgPath", imgPath);
            %>
            <img class="w-100" src="<c:url value="${imgPath}"/>" alt="poster"/>
        </div>
        <div class="col-lg-8 col-12 d-flex flex-column justify-content-center align-items-center">
            <div class="border w-100 p-lg-3 text-center bg-warning"><strong>Màn Hình</strong></div>
            <div class="col-lg-8 col-12 d-flex flex-column justify-content-center align-items-center" id="seatList"></div>
        </div>
    </div>
    <div class="bg-dark col-12 row rounded p-3">
        <button class="col-2 btn btn-warning" onclick="function() {
                                window.history.back();
                            }">QUAY LẠI</button>
        <form class="row col-8" action="bill.html" method="post">
            <input class="col-12 w-100 text-center" type="text" value="" id="seats" name="txtSeats" disabled/>
            <input class="d-none" type="text" value="" id="ticketIds" name="txtTickets" disabled/>
        </form>
        <button class="col-2 btn btn-warning" onclick="billForm()">TIẾP TỤC</button>
    </div>
</div>
<script>
    var tickets = ${tickets}
    console.log(tickets)
</script>
<script src="<c:url value="/resources/JS/booking.js"/>"></script>
<%@include file="footer.jsp" %>