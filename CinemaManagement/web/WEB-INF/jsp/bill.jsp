<%-- 
    Document   : bill
    Created on : Jul 16, 2020, 1:14:24 PM
    Author     : GF63 8RD
--%>


<%@page import="DAO.FilmDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<link href="<c:url value="/resources/css/billform.css"/>" rel="stylesheet"/>
<%    FilmDAO fd = new FilmDAO();%>
<div class="bg-white container mt-5">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-12">
                <c:set var="fId" value="${film.getfId()}" />
                <%
                    String imgPath = "/resources/image/" + fd.getFilmPoster(Integer.parseInt(pageContext.getAttribute("fId").toString()));
                    pageContext.setAttribute("imgPath", imgPath);

                %>
                <img class="w-100" src="<c:url value="${imgPath}"/>" alt="poster"/>
            </div>
            <div class="col-md-8 col-12">
                <div class="title">${film.getfName()}</div>
                <div class="formality">
                    <label>Loại: ${formality.getFmName()}</label>
                </div>
                <div class="formality">
                    <label>Mã hóa đơn: #${bid}</label>
                </div>
                <div class="formality">
                    <label>Tên người đặt:</label>
                    <a>${name}</a>
                </div>
                <div class="formality">
                    <label>Số điện thoại:</label>
                    <a>${phone}</a>
                </div>
                <div id="totals" class="formality">
                    <label style="font-size: 2rem">Tổng giá:</label>
                    <b style="font-size: 2rem;" class="text-danger">${total} VND </b>

                </div>
            </div>
        </div>
    </div>
</div>
                    
<% fd.closeConnect(); %>
<%@include file="footer.jsp" %>