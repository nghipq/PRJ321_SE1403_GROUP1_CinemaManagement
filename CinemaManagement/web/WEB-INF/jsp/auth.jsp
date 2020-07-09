<%-- 
    Document   : auth
    Created on : Jul 9, 2020, 1:29:25 PM
    Author     : phamq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/auth.css"/>" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container" id="container" style="text-align: center;">
            <div class="form-container sign-up-container">
                <form action="#">
                    <h1>Đăng Ký</h1>
                    <input type="text" placeholder="Tên" />
                    <input type="email" placeholder="Email" />
                    <input type="password" placeholder="Mật khẩu" />
                    <input type="password" placeholder="Nhập lại mật khẩu" />
                    <input type="date">
                    <input type="text" placeholder="Địa chỉ" />
                    <input type="text" placeholder="SĐT" />
                    <button>Đăng ký</button>
                </form>
            </div>
            <div class="form-container sign-in-container">
                <form action="#">
                    <h1>Đăng Nhập</h1>
                    <input type="email" placeholder="Email" />
                    <input type="password" placeholder="Password" />
                    <button>Đăng nhập</button>
                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Chào mừng đến với Asterism Cinema</h1>
                        <p style="margin-left:50;">Để tiếp tục, xin vui lòng đăng nhập!</p>
                        <button class="ghost" id="signIn">Đăng nhập</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Xin chào!</h1>
                        <p>Điền thông tin của bạn để bắt đầu trải nghiệm trang web của chúng tôi!</p>
                        <button class="ghost" id="signUp">Đăng ký</button>
                    </div>
                </div>
            </div>
        </div>
        <script src="<c:url value="/resources/JS/authEffect.js"/>"></script>
    </body>
</html>
