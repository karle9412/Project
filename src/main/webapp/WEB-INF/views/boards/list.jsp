<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div id="main">
  <table id="boardList">
    <h2>요청 게시판</h2>
    <tr>
      <td colspan="5" class="right">
         <a href="/Board/WriteForm?menu_id=${list.menu_id}">요청게시글 쓰기</a>
      </td>
    </tr>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>위치</th>
      <th>접수상태</th>
    </tr>

</body>
</html>