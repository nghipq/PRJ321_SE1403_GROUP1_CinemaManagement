<%-- 
    Document   : bills
    Created on : Jul 20, 2020, 3:11:26 PM
    Author     : GF63 8RD
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.FilmDAO"%>
<%@include file="header.jsp" %>

<div class="container mt-5">
    <div class="container">
        <div class="row">
<table class="d-flex flex-column justify-content-center align-items-center w-100">
            <tr class="d-flex flex-row justify-content-center align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-dark text-warning">
                <td class="d-flex flex-row justify-content-center align-items-start" style="width: 8vw">
                    <strong>Mã Hóa Đơn</strong>
                </td>
                <td class="d-flex flex-row justify-content-center align-items-start" style="width: 15vw">
                    <strong>Tên</strong>
                </td>
                <td class="d-flex flex-row justify-content-center align-items-start" style="width: 10vw">
                    <strong>Số Điện Thoại</strong>
                </td>
                <td class="d-flex flex-row justify-content-center align-items-start" style="width: 10vw">
                    <strong>Ngày Mua</strong>
                </td>
                <td class="d-flex flex-row justify-content-center align-items-start" style="width: 10vw" >
                    <strong>Chi Tiết</strong>
                </td>
            </tr>


            <c:forEach var="row" items="${bill}">
                <tr class="d-flex flex-row justify-content-center align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-white text-dark ">

                    <td class="d-flex flex-row justify-content-center align-items-start"  style="width: 8vw">
                        <strong>${row.getbId()}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-center align-items-start"  style="width: 15vw">
                        <strong>${row.getName()}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-center align-items-start"  style="width: 10vw">
                        <strong>${row.getPhone()}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-center align-items-start"  style="width: 10vw">
                        <strong>${row.getDateBuy()}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-center align-items-start" style="width: 10vw">
                        <strong><a href="billDetail.html?bId=${row.getbId()}">Xem Hóa Đơn</a></strong>
                    </td>

                </tr>
            </c:forEach>
        </table>

        </div>
    </div>
</div>

<%@include file="footer.jsp" %>


