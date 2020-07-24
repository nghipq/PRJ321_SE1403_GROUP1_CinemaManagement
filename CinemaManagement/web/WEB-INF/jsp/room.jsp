<%-- 
    Document   : room
    Created on : Jul 10, 2020, 9:51:33 AM
    Author     : phamq
--%>

<%@page import="DAO.FilmDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <%                FilmDAO fd = new FilmDAO();
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
        <button class="col-2 btn btn-warning" onclick="function () {
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
    var rId = ${rId}

    var sortable = [];

    for (var key in tickets) {
        sortable.push([key, tickets[key]]);
    }

    sortable.sort();

    var tickets = {};
    sortable.forEach(function (item) {
        tickets[item[0]] = item[1];
    });

    var seatList = document.getElementById("seatList")
    var seat = ""
    var count = 0

    for (key in tickets) {
        var ticket = JSON.parse(tickets[key])
        console.log(ticket['tId'])

        if (count == 0) {
            seat += "<div class='d-flex flex-row justify-content-center align-items-center w-100' >"
        }

        if (ticket["status"] == 1) {
            console.log()
            seat += `<button class="btn btn-warning" id="` + ticket['tId'] + `" disabled style='width: 20%'>` + key + `</button>`
        } else {
            seat += `<button class='btn btn-secondary' id="` + ticket['tId'] + `" onclick="addSeat('` + key + `',` + ticket['tId'] + `)" style='width: 20%'>` + key + `</button>`
        }

        count += 1
        if (count == 8) {
            seat += "</div>"
            count = 0
        }
    }

    seatList.innerHTML = seat

    var seats = document.getElementById("seats")
    var ticketId = document.getElementById("ticketIds")

    var chooseSeats = []
    var ticketIds = []

    function addSeat(name, tId) {
        var choosed = document.getElementById(tId)
        if (chooseSeats.indexOf(name) == -1) {
            choosed.classList.replace("btn-secondary", "btn-white")
            chooseSeats.push(name)
            ticketIds.push(tId)
        } else {
            choosed.classList.replace("btn-white", "btn-secondary")
            chooseSeats = chooseSeats.filter(x => x != name)
            ticketIds = ticketIds.filter(x => x != tId)
        }

        var values = chooseSeats.join(", ")
        seats.value = values
        ticketId.value = ticketIds.join(", ")
    }

    function billForm() {
        location.href = `bill.html?rId=` + rId + `&tickets=` + ticketIds.join(", ") + `&ticketNames=` + chooseSeats.join(", ")
    }

</script>
<script src="<c:url value="/resources/JS/booking.js"/>"></script>
<%@include file="footer.jsp" %>