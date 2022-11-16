<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none" id="mySidebar">
  <button class="w3-bar-item w3-button w3-large"
  onclick="w3_close()">Close &times;</button>
  <a href="/Board/customerList?menu_id=MENU_01" class="w3-bar-item w3-button">메인(일단 해주세요로감)</a>
  <a href="/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10" class="w3-bar-item w3-button">해주세요</a>
  <a href="/Board/riderList?menu_id=MENU_02&pageNum=1&contentNum=10" class="w3-bar-item w3-button">할게요</a>
  <a href="/Board/reviewList?menu_id=MENU_03&pageNum=1&contentNum=10" class="w3-bar-item w3-button">후기</a>
  <a href="/logout" class="w3-bar-item w3-button">로그아웃</a>
  <a href="/getUser" class="w3-bar-item w3-button">내 정보</a>
</div>
