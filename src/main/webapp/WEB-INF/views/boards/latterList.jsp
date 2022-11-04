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
  <%@ include file="/WEB-INF/include/menus.jsp" %>
  <table id="latterList">
    <h2>요청 게시판</h2>
    <tr>
      <td>
      <a href="/Board/LatterWriterForm?menu_id=MENU_02">새글쓰기</a>
      </td>
    </tr>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>지역</th>
    </tr>
    <c:forEach var="board" items="${boardList}">
    <tr>
       <td>${board.board_number}</td>
       <td><a href="/">${board.title}</a></td>
       <td>${board.writer}</td>
       <td>${board.board_local}</td>
    </tr>
    </c:forEach>
  </table>
  </div>
</body>
</html>