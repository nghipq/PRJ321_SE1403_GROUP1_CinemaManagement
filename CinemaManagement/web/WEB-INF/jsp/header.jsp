<%-- 
    Document   : header
    Created on : Jul 6, 2020, 5:17:31 PM
    Author     : GF63 8RD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Asterism Cinema</title>
    <!-- Import Boostrap css, js, font awesome here -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="./css/style.css" rel="stylesheet">
</head>

<body>
    <nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
        <div class="container-fluid">
            <a class="navbar-branch" href="#" onclick="window.location.reload();">
                <img src="./image/Capture.PNG (2).png" height="100">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link active" href="#" onclick="window.location.reload();">Trang Chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Phim</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Lịch Chiếu</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Liên Hệ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Đăng Nhập</a>
                    </li>
                    <li class="nav-item">
                        <form class="form-inline">
                            <input class="form-control mr-sm-2" type="search" placeholder="Tìm kiếm" aria-label="Search">
                            <button class="btn" type="submit">Search</button>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div>
        <img src="./image/rapgiave-hinhrap-nvq-01_1557130993556.jpg" alt="background" style="width: 100%;">
    </div>
    <footer>
        <div class="container-fluid padding">
            <div class="row text-center">


                <div class="col-md-4">
                    <hr class="light">
                    <h5>Thông tin rạp</h5>
                    <hr class="light">
                    <p>SE1403</p>
                    <p>Đại học FPT Cần Thơ</p>
                    <p>Khu Vực 6, Phường An Bình, Quận Ninh Kiều, Tp Cần Thơ</p>
                </div>

                <div class="col-md-4">
                    <hr class="light">
                    <h5>Chăm sóc khách hàng</h5>
                    <hr class="light">
                    <p>Mọi chi tiết xin liên hệ</p>
                    <p>nhanltce140044@fpt.edu.vn</p>
                    <p>SĐT: 0587964355</p>
                </div>

                <div class="col-md-3 d-flex flex-column justify-content-center align-items-center">
                    <img src="./image/Capture.PNG (2).png" alt="logo" style="width: 50%;">
                </div>
            </div>
        </div>
    </footer>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>

</html>
