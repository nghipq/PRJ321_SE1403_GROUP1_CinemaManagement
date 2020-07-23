<%-- 
    Document   : admin.schedule
    Created on : Jul 22, 2020, 9:58:55 PM
    Author     : phamq
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="models.*"%>
<%@page import="DAO.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="admin.header.jsp" %>

<div class="d-flex flex-row">
    <%@include file="dashboard.jsp" %>
    <%
        SessionDAO sed = new SessionDAO();
        FilmDAO fd = new FilmDAO();
        TicketDAO td = new TicketDAO();
    %>
    <div class="d-block flex-column justify-content-start align-items-center p-5" style="width: 80%;">
        <table class="d-flex flex-column justify-content-start align-items-center w-100">
            <tr class="d-flex flex-row justify-content-start align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-dark text-warning">
                <td class="d-flex flex-row justify-content-center align-items-center" style="width: 15vw; text-align: center">
                    <strong>Tên Phim</strong>
                </td>
                <td class="d-flex flex-row justify-content-center align-items-center" style="width: 15vw; text-align: center">
                    <strong>Giờ Chiếu</strong>
                </td>
                <td class="d-flex flex-row justify-content-center align-items-center" style="width: 15vw; text-align: center">
                    <strong>Ngày Chiếu</strong>
                </td>
                <td class="d-flex flex-row justify-content-center align-items-center" style="width: 10vw; text-align: center">
                    <strong>Số Ghế Trống</strong>
                </td>
            </tr>
            <c:forEach var="row" items="${schedules}">
                <tr class="d-flex flex-row justify-content-start align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-white text-dark "> 
                    <c:set var="scheId" value="${row.getScheId()}"/>
                    <c:set var="fId" value="${row.getfId()}"/>
                    <c:set var="sesId" value="${row.getfId()}"/>
                    <c:set var="rId" value="${row.getrId()}"/>
                    <%
                        String filmName = fd.getFilmsById(Integer.parseInt(pageContext.getAttribute("fId").toString())).getfName();
                        pageContext.setAttribute("filmName", filmName);
                        int sesId = Integer.parseInt(pageContext.getAttribute("sesId").toString());
                        int scheId = Integer.parseInt(pageContext.getAttribute("scheId").toString());
                        ArrayList<String> details = td.getDetail(sesId, scheId);
                        pageContext.setAttribute("details", details);
                    %>
                    <td class="d-flex flex-row justify-content-center align-items-center"  style="width: 15vw">
                        <strong>${filmName}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-center align-items-center"  style="width: 15vw">
                        <strong>${details.get(0)}</strong>
                    <td>
                    <td class="d-flex flex-row justify-content-center align-items-center w-5" style="width: 15vw">
                        <strong>0</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-center align-items-center w-5" style="width: 10vw">
                        <strong>${details.get(1)}</strong>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>

<%@include  file="admin.footer.jsp" %>
