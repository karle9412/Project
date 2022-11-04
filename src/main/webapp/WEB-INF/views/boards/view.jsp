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
 <table id="menu">
  <tr>
  <c:forEach var="menu"  items="${ menuList }" >
   <td>

      <a href="/Board/List?menu_id=${menu.menu_id}"> ${ menu.menu_id }</a>
      ${ menu.menu_name }

   </td>
   </tr>
    </c:forEach>

  <div id="main">
  <%@ include file="/WEB-INF/include/menus.jsp" %>
  <table id="boardList">
    <h2>요청 게시판</h2>
    <tr>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일</th
      <th>위치</th>
      <th>접수상태</th>
    </tr>
    <c:forEach var="board" items="${boardList}">
    <tr>
       <td>${board.title}</td>
       <td>${board.writer}</td>
       <td>${board.indate}</td>
       <td>${board.board_local}</td>
    </tr>
    </c:forEach>

    <td>   <a href="/board/WriteForm">글쓰기</td>

</body>
</html>