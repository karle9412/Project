<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        body{
         background-image: url(./img/test3.jpg);
         background-repeat: no-repeat;
         background-size : cover ;
        }

    </style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h2> 배달의 새로운 패러다임을 제시합니다</h2>
<a href="/login" class="btn btn-primary">시작하기</a>
<a href="/Board/RequestList?menu_id=MENU_01" class="btn btn-primary">요청페이지</a>
<a href="/Board/LatterList?menu_id=MENU_02" class="btn btn-primary">후기페이지</a>


</body>
</html>
