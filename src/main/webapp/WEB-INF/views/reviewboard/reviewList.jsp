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
  <table class="table reviewList">
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일</th>
      <th>지역</th>
    </tr>
    <c:forEach var="board" items="${reviewList}">
    <tr>
       <td>${board.board_number}</td>
       <td><a href="/Board/ReviewDetail?board_number=${board.board_number}&menu_id=${board.menu_id}">${board.title}</a></td>
       <td>${board.writer}</td>
       <td>${board.indate}</td>
       <td>${board.board_local}</td>
    </tr>
  </div>
    </c:forEach>
        <div id="paging">
          <tr>
            <td>
              <c:if test="${boardPager.prev}">
                <a href="/Board/reviewList?menu_id=MENU_03&pageNum=${boardPager.getStartPage()-1}&contentNum=${(boardPager.getStartPage()-1)*10}">< 이전</a>
              </c:if>
              <c:forEach begin="${boardPager.getStartPage()}" end="${boardPager.getEndPage()}" var="idx">
                <a href="/Board/reviewList?menu_id=MENU_03&pageNum=${idx}&contentNum=${idx*10}">${idx}</a>
              </c:forEach>
              <c:if test="${boardPager.next}">
                <a href="/Board/reviewList?menu_id=MENU_03&pageNum=${boardPager.getEndPage()+1}&contentNum=${(boardPager.getEndPage()+1)*10}">다음 ></a>
              </c:if>
            </td>
          </tr>
        </div>
        <tr>
          <td>
          <a href="/Board/RVBoardWriteForm?menu_id=MENU_03&pageNum=1&contentNum=10">후기 새글쓰기</a>
          </td>
        </tr>
  </table>
</body>
</html>