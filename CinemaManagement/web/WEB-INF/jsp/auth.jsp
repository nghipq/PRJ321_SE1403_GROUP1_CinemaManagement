<%-- 
    Document   : auth
    Created on : Jul 9, 2020, 1:29:25 PM
    Author     : phamq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/auth.css"/>" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="width: 100vw; height: 100vh" class="body">
            <div class="container" id="container" style="text-align: center;">
                <div class="form-container sign-up-container">
                    <spring:form method = "POST" commandName="tk" action="auth/register.html">
                        <h1>Đăng Ký</h1>
                        <input type="text" name="txtName" placeholder="Tên" />
                        <input type="email" name="txtEmail" placeholder="Email" />
                        <input type="password" name="txtPass" placeholder="Mật khẩu" />
                        <input type="password" name="txtconfirmpass" placeholder="Nhập lại mật khẩu" />
                        <input type="date" name="txtDate"/>
                        <input type="text" name="txtAddress" placeholder="Địa chỉ" />
                        <input type="text" name="txtPhone" placeholder="SĐT" />
                        <button>Đăng ký</button>
                    </spring:form>
                </div>
                <div class="form-container sign-in-container">
                    <!--                <form action="#">
                                        <h1>Đăng Nhập</h1>
                                        <input type="email" placeholder="Email" />
                                        <input type="password" placeholder="Password" />
                                        <button>Đăng nhập</button>
                                    </form>-->

                    <spring:form method = "POST" commandName="tk" action="auth/login.html">
                        <h1>Đăng Nhập</h1>
                        <spring:input path="email" /><br>
                        <spring:password path="password"/><br>
                        <h3 style="color: red">${message}</h3>
                        <button>Đăng nhập</button>

                    </spring:form>

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
        </div>
        <script src="<c:url value="/resources/JS/authEffect.js"/>"></script>
    </body>
</html>
