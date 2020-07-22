<%-- 
    Document   : updateShowtimes
    Created on : Jul 22, 2020, 1:20:57 PM
    Author     : GF63 8RD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<div class="bg-white container mt-5">
    <div>
        <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
            <input class="p-2" type="time" placeholder="Register Date" name="URegis" value="${user.getRegisDate()}" style="width: 25vw; height: 5vh">
       </div>
        <div class="d-flex flex-row justify-content-center align-items-center w-100 rounded-sm m-2">
            <input class="p-2" type="time" placeholder="Register Date" name="URegis" value="${user.getRegisDate()}" style="width: 25vw; height: 5vh">
       </div>
    </div>
</div>

<%@include file="footer.jsp" %>
