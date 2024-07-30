<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login Form</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="views/css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="logreg-forms">
    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:if>

    <form class="form-signin" method="post" action="/account/login-check">
        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign in</h1>
        <input name="user" value="${username }"  type="text" id="inputEmail" class="form-control" placeholder="Username" required autofocus>
        <input name="pass" value="${password }" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <div class="form-group form-check">
            <input name="remember" value="1" type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Remember me</label>
        </div>
        <div class="float-end">
         <a href="forgotPassword" class="btn btn-link">Quên mật khẩu?</a>
        </div>
     
        <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>
        <hr>
        <button class="btn btn-primary btn-block" type="button" id="btn-signup"><i class="fas fa-user-plus"></i> Sign up New Account</button>
    </form>

    <form action="signup" method="post" class="form-signup">
        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Sign up</h1>
        <input name="user" type="text" id="user-name" class="form-control" placeholder="User name" required autofocus>
        <input name="pass" type="password" id="user-pass" class="form-control" placeholder="Password" required autofocus>
        <input name="repass" type="password" id="user-repeatpass" class="form-control" placeholder="Repeat Password" required autofocus>
        <input name="email" type="email" id="email" class="form-control" placeholder="Email" required autofocus>
        <button class="btn btn-primary btn-block" type="submit"><i class="fas fa-user-plus"></i> Sign Up</button>
        <a href="#" id="cancel_signup"><i class="fas fa-angle-left"></i> Back</a>
    </form>
    <br>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script>
    $(() => {
        $('#btn-signup').click(() => {
            $('.form-signin').toggle();
            $('.form-signup').toggle();
        });
        $('#cancel_signup').click(() => {
            $('.form-signin').toggle();
            $('.form-signup').toggle();
        });
    });
</script>
</body>
</html>
