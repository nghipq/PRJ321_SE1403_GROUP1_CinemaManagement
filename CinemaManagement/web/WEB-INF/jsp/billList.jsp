<%-- 
    Document   : bills
    Created on : Jul 20, 2020, 3:11:26 PM
    Author     : GF63 8RD
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.FilmDAO"%>
<%@include file="header.jsp" %>

<div class="bg-white container mt-5">
    <div class="container">
        <div class="row">
<table class="d-flex flex-column justify-content-start align-items-center w-100">
            <tr class="d-flex flex-row justify-content-start align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-dark text-warning">
                <td style="width: 25vw">
                    <strong>STT</strong>
                </td>
     
                <td >
                    <strong>Chi Tiết</strong>
                </td>
            </tr>


            <c:forEach var="row" items="${bill}">
                <tr class="d-flex flex-row justify-content-start align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-white text-dark ">

                    <td class="d-flex flex-row justify-content-start align-items-start"  style="width: 25vw">
                        <strong>${row.getbId()}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-between align-items-start w-5">
                        <strong><a href="bill/">xem Bill</a></strong>
                    </td>

                </tr>
            </c:forEach>
        </table>

        <div
            class="d-flex flex-row justify-content-between align-items-center p-2 mt-4 w-100 border border-white rounded-sm m-2 bg-white text-dark">
            <div class="container">
                <button type="button" class="btn btn-warning btn-lg"><strong>Change Page</strong></button>
            </div>
        </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>


