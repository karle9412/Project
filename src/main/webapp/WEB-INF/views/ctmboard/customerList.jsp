<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		ul {
			list-style: none;
			width : 30%;
			display: inline-block;
		}

		li {
			float: left;
			margin-left : 5px;
		}
	</style>

<!--
<script>
function page(idx){
  var pageNum = idx;
  var contentNum = $("#contentNum option:selected").val();

  if(contentNum == 10){
    location.href="/Board/customerList?menu_id=MENU_01&pageNum="+pageNum+"&contentNum="+contentNum
  }else if(contentNum == 20){
    location.href="/Board/customerList?menu_id=MENU_01&pageNum="+pageNum+"&contentNum="+contentNum
  }else if(contentNum == 30){
    location.href="/Board/customerList?menu_id=MENU_01&pageNum="+pageNum+"&contentNum="+contentNum
  }
}
</script>
-->

</head>
<body>
  <div id="main">
  <%@ include file="/WEB-INF/include/menus.jsp" %>
<!--
  <table id="boardList">
    <h2>해주세요 게시판</h2>
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일</th>
      <th>지역</th>
      <th>접수상태</th>
    </tr>
    <c:forEach var="board" items="${boardList}">
    <tr>
       <td>${board.board_number}</td>
       <td><a href="/Board/CustomerDetail?board_number=${board.board_number}&menu_id=${board.menu_id}">${board.title}</a></td>
       <td>${board.writer}</td>
       <td>${board.indate}</td>
       <td>${board.board_local}</td>
       <c:set var="check" value="${board.board_check}"/>
       <c:if test="${check == 0}">
         <td>접수대기<td>
       </c:if>
       <c:if test="${check == 1}">
         <td>접수완료<td>
       </c:if>
    </tr>
    </c:forEach>
    <tr>
      <td>
      <a href="/Board/CBoardWriteForm?menu_id=MENU_01">해주세요 새글쓰기</a>
      </td>
    </tr>
  </table>
  -->
  </div>
<!--
  <select name="contentNum" id="contentNum" onchange="page(1)">
    <option value="10" <c:if test="${boardPager.getContentNum() == 10 }">selected="selected"</c:if> >10 개</option>
    <option value="20" <c:if test="${boardPager.getContentNum() == 20 }">selected="selected"</c:if> >20 개</option>
    <option value="30" <c:if test="${boardPager.getContentNum() == 30 }">selected="selected"</c:if> >30 개</option>
  </select>
-->
  <table class="table table-bordered">
    <tr>
      <th>제목</th>
      <th>작성자</th>
    </tr>
      <c:forEach items="${testList}" var="board">
        <tr>
          <td>${board.title}</td>
          <td>${board.writer}</td>
        </tr>
      </c:forEach>
        <div id="row">
          <tr>
            <td>
              <c:if test="${boardPager.prev}">
                <a href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getStartPage()-1}&contentNum=${(boardPager.getStartPage()-1)*10}">< 이전</a>
              </c:if>
              <c:forEach begin="${boardPager.getStartPage()}" end="${boardPager.getEndPage()}" var="idx">
                <a href="/Board/customerList?menu_id=MENU_01&pageNum=${idx}&contentNum=${idx*10}">${idx}</a>
              </c:forEach>
              <c:if test="${boardPager.next}">
                <a href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getEndPage()+1}&contentNum=${(boardPager.getEndPage()+1)*10}">다음 ></a>
              </c:if>
            </td>
          </tr>
        </div>

  </table>
</body>
</html>