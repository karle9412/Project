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
      <th>번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>위치</th>
      <th>접수상태</th>
    </tr>
    <c:forEach var="board" items="${boardList}">
    <tr>
       <td>${board.board_number}</td>
       <td>${board.menu_id}</td>
       <td>${board.userid}</td>
       <td>${board.title}</td>
       <td>${board.writer}</td>
       <td>${board.board_local}</td>
       <td>${board.cont}</td>
       <td>${board.indate}</td>
    </tr>
    </c:forEach>

</body>
</html>