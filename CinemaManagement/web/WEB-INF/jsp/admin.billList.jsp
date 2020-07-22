<%-- 
    Document   : admin.billList
    Created on : Jul 21, 2020, 3:50:41 PM
    Author     : phamq
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="admin.header.jsp" %>

<div class="d-flex flex-row">
    <%@include file="dashboard.jsp" %>
    <div class="d-block flex-column justify-content-start align-items-center p-5" style="width: 80%;">
        <table class="d-flex flex-column justify-content-start align-items-center w-100">
            <tr class="d-flex flex-row justify-content-start align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-dark text-warning">
                <td class="d-flex flex-row justify-content-center align-items-center" style="width: 3vw">
                    <strong>MHĐ</strong>
                </td>
                <td class="d-flex flex-row justify-content-center align-items-center" style="width: 15vw; text-align: center">
                    <strong>Tên khách hàng</strong>
                </td>
                <td class="d-flex flex-row justify-content-center align-items-center" style="width: 15vw; text-align: center">
                    <strong>Số điện thoại</strong>
                </td>
                <td class="d-flex flex-row justify-content-center align-items-center" style="width: 15vw; text-align: center">
                    <strong>Ngày đặt</strong>
                </td>
                <td class="d-flex flex-row justify-content-center align-items-center" style="width: 8vw; text-align: center">
                    <strong>Trạng thái</strong>
                </td>
            </tr>


            <c:forEach var="row" items="${bills}">
                <tr class="d-flex flex-row justify-content-start align-items-center p-3 w-100 border border-warning rounded-sm m-2 bg-white text-dark ">

                    <td class="d-flex flex-row justify-content-center align-items-center"  style="width: 3vw">
                        <strong>${row.getbId()}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-center align-items-center"  style="width: 15vw">
                        <strong>${row.getName()}</strong>
                    <td>
                    <td class="d-flex flex-row justify-content-center align-items-center w-5" style="width: 15vw">
                        <strong>${row.getPhone()}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-center align-items-center w-5" style="width: 15vw">
                        <strong>${row.getDateBuy()}</strong>
                    </td>
                    <td class="d-flex flex-row justify-content-center align-items-center w-5" style="width: 8vw">
                        <strong>${row.getStatus()}</strong>
                    </td>

                </tr>
            </c:forEach>
        </table>

    </div>
</div>

<%@include  file="admin.footer.jsp" %>
