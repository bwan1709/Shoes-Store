<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css">
    <link href="views/css/login.css" rel="stylesheet" type="text/css" />
    <title>Forgot Password Form</title>
</head>

<body>
    <jsp:include page="Menu.jsp"></jsp:include>
    <div id="logreg-forms">
        <form class="form-signin" action="forgotPassword" method="post">
            <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Forgot Password</h1>
            <p class="text-success">${mess}</p>
            <p class="text-danger">${error}</p>
            <label for="username">Username</label>
            <input name="username" type="text" id="username" class="form-control" placeholder="Username" required="" autofocus="">
            <label for="email">Email</label>
            <input name="email" type="text" id="email" class="form-control" placeholder="Email" required="" autofocus="">
            <button class="btn btn-success btn-block" type="submit"><i class="fas fa-sign-in-alt"></i> Retrieve</button>
        </form>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script>
        window.addEventListener("load", function loadAmountCart() {
            $.ajax({
                url: "/WebsiteBanGiay/loadAllAmountCart",
                type: "get", 
                data: {},
                success: function(responseData) {
                    document.getElementById("amountCart").innerHTML = responseData;
                }
            });
        }, false);
    </script>
</body>
</html>
