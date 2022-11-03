<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<form action="/write" method="POST">
<input type="text" name="userid"> id </input><br>
<input type="text" name="passwd"> 비밀번호 </input><br>
<input type="text" name="username"> 닉네임 </input><br>
<input type="text" name="email"> 이메일 </input><br>
<input type="text" name="userLocal"> 지역 </input><br>
<input type="text" name="rider"> 서비스 회원 </input><br>
<input type="submit" value="완료"></input>
</form>
</body>
</html>