<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
      body {font-family: "Roboto", sans-serif}
      .w3-bar-block .w3-bar-item {
        padding: 16px;
        font-weight: bold;
      }
      .container {
        position: relative;
        text-align: center;
        color: white;
      }
      .centered-up {
        position: absolute;
        top: 40%;
        left: 50%;
        transform: translate(-50%, -50%);
      }
      .light-bottom {
        position: absolute;
        top: 70%;
        left: 50%;
        transform: translate(-50%, -50%);
      }
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, height=devive-height, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

    <!-- 헤더 -->
    <header class="w3-container w3-theme w3-center" style="height:20%">
        <h1 class="w3-xxxlarge">TITLE</h1>
    </header>

    <div class="container">
        <img src="https://cdn.pixabay.com/photo/2016/05/28/00/06/gift-1420830_640.jpg"  style="width:100%">
        <div class="w3-center centered-up w3-xxlarge">
            배달의<br>새로운<br>패러다임
        </div>
        <a href="/login" class="light-bottom w3-button w3-section w3-light-green w3-ripple">시작하기</a>
    </div>


<a href="/Board/RequestList?menu_id=MENU_01&nowpage=1&pagecount=5&pagegrpnum=1" class="btn btn-primary">요청페이지</a>
<a href="/Board/LatterList?menu_id=MENU_02&nowpage=1&pagecount=5&pagegrpnum=1" class="btn btn-primary">후기페이지</a>


</body>
</html>
