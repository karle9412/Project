<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
    <header class="w3-container w3-teal w3-center">
        <h1>Login</h1>
    </header>

    <div class="w3-container w3-half w3-margin-top w3-display-middle" style="height:70%">
        <!--form action 조정 필요-->
        <form action="/loginProcess" method="POST" class="w3-container w3-card-4">
            <p>
            <input class="w3-input" id="userid" type="text" style="width:100%" required>
            <label>ID</label></p>
            <p>
            <input class="w3-input" id="passwd" type="password" style="width:100%" required>
            <label>Password</label></p>

            <p>
            <button type="submit" class="w3-button w3-section w3-teal w3-ripple w3-right"> Log In </button></p>
        </form>

        <div class="w3-container w3-border-top w3-padding-16">
            <!-- href 조정 필요 -->
            <span class="w3-right w3-padding"><a href="/writeForm">회원가입하기</a></span>
        </div>
    </div>
</body>
</html>
