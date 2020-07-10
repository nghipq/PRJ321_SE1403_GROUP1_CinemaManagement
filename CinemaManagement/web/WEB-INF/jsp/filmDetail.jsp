<%-- 
    Document   : filmDetail
    Created on : Jul 9, 2020, 4:30:35 PM
    Author     : phamq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<link href="<c:url value="/resources/css/Detail.css"/>" rel="stylesheet"/>
<div class="bg-white container mt-5">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-12">
                <img src="image/Ngoi_den_ki_quai.jpg" alt="image-film" style="width: 100%">
            </div>
            <div class="col-md-8 col-12">
                <div class="title">${film.getfName()}</div>
                <div class="formality">
                    <label>Đạo Diễn:</label>
                    <a>Phontharis Chotkijsadarsopon</a>
                </div>
                <div class="formality">
                    <label>Diễn Viên:</label>
                    <a>Phiravich Attachitsataporn, Timethai Plangsilp, Paisarnkulwong Vachiravit</a>
                </div>
                <div class="formality">
                    <label>Thể Loại:</label>
                    <a>Hài, Kinh Dị</a>
                </div>
                <div class="formality">
                    <label>Độ dài:</label>
                    <a>115 phút</a>
                </div>
                <div class="formality">
                    <label>Ngôn ngữ:</label>
                    <a>Phụ đề tiếng Việt</a>
                </div>
                <div class="formality">
                    <label>Ban Age:</label>
                    <a>16+ - Phim cấm khán giả dưới 16 tuổi</a>
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
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1">Previous</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">T2</a></li>
                            <li class="page-item"><a class="page-link" href="#">T3</a></li>
                            <li class="page-item"><a class="page-link" href="#">T4</a></li>
                            <li class="page-item"><a class="page-link" href="#">T5</a></li>
                            <li class="page-item"><a class="page-link" href="#">T6</a></li>
                            <li class="page-item"><a class="page-link" href="#">T7</a></li>
                            <li class="page-item"><a class="page-link" href="#">CN</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>

                <div class="showtime" >
                    <div>
                        <label class="showtime-text row">Lịch Chiếu: </label>
                    </div>
                    <div class="border row" >
                        <button type="button" class="btn btn-secondary">                            
                            8:30AM
                            <br>
                            64 ghế trống
                        </button>
                        <button type="button" class="btn btn-secondary">                            
                            11:45AM
                            <br>
                            64 ghế trống
                        </button>
                        <button type="button" class="btn btn-secondary">                            
                            13:00PM
                            <br>
                            64 ghế trống
                        </button>
                        <button type="button" class="btn btn-secondary">                            
                            16:15PM
                            <br>
                            64 ghế trống
                        </button>
                        <button type="button" class="btn btn-secondary">                            
                            19:30PM
                            <br>
                            64 ghế trống
                        </button>
                        <button type="button" class="btn btn-secondary">                            
                            21:45PM
                            <br>
                            64 ghế trống
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>