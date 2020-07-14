<%-- 
    Document   : billForm
    Created on : Jul 12, 2020, 7:39:57 PM
    Author     : phamq
--%>

<%@page import="DAO.FilmDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<link href="<c:url value="/resources/css/billform.css"/>" rel="stylesheet"/>
    <div class="bg-white container mt-5">
        <div class="container">
             <div class="row">
        <div class="col-md-4 col-12">
            <c:set var="fId" value="${film.getfId()}" />
            <%
                FilmDAO fd = new FilmDAO();
                String imgPath = "/resources/image/" + fd.getFilmPoster(Integer.parseInt(pageContext.getAttribute("fId").toString()));
                pageContext.setAttribute("imgPath", imgPath);
            %>
            <img class="w-100" src="<c:url value="${imgPath}"/>" alt="poster"/>
        </div>
                <div class="col-md-8 col-12">
                    <div class="title">${film.getfName()}</div>
                    <div class="formality">
                        <label>${formality.getFmName()}</label>
                    </div>
                    <div class="formality">
                        <label>Ban Age:</label>
                        <a>${film.getLimitAge()}+ - Phim cấm khán giả dưới ${film.getLimitAge()} tuổi</a>
                    </div>
                          <form>
                            <div class="form-group">
                              <input type="text" class="form-control" id="Name" placeholder="Họ Tên">
                            </div>
                            <div class="form-group">
                              <input type="text" class="form-control" id="Phone" placeholder="Số Điện Thoại">
                            </div>
                          </form>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-5 col-12">
                    <div class="formality">
                        <label>Tên rạp:</label>
                        <a>Asterism</a>
                    </div>
                    <div class="formality">
                        <label>Xuất chiếu: </label> 
                         <a>${session.getStartTime().toString()}-${session.getEndTime().toString()}</a>
                    </div>
                    <div class="formality">
                        <label>Phòng chiếu: </label>
                        <a>${rId}</a>
                    </div>
                    <div class="formality">
                        <label>Số ghế: </label>
                        <a>${ticketNames}</a>
                    </div>
                </div>
                <div class="col-md-7 col-12">
                    <div class="formality">
                        <label>Giá phim: </label>
                        <a>${formality.getTicketPrice()}</a>
                    </div>
                    <div class="formality">
                        <label>Tổng: </label>
                        <a>${total}</a>
                    </div>
                    <div class="formality">
                        <label></label>
                    </div>
                    <div class="formality">
                        <label></label>
                        <button type="button" class="btn btn-warning btn-lg" onclick="booking()">Đặt Vé</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
<script>
    function booking() {
      alert("đặt vé thành công");
    }
</script>
<%@include file="footer.jsp" %>
