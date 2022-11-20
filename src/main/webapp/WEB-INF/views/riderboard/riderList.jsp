<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/css/common.css">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<title>Insert title here</title>

<style>
.pickup{
text-align:left;
font-family:"S-Core Dream 6";
font-size:38px;
}
.oooo{
border:1px solid #ccc!important;
margin:40px 40px 40px 40px;
}
</style>
</head>
<body class="w3-light-grey">
<%@ include file="/WEB-INF/include/menus.jsp" %>
<header class="w3-container w3-center w3-padding-48 w3-white">
    <h1 class="w3-xxxlarge"><b>Banana Quick</b></h1>
    <h6><span class="w3-tag">delivery's world</span></h6>
</header>
<div class="oooo">
<div id="main">
              <div class="pickup">
                        픽업 할게요
                    </div>
    </div>

    <div class="w3-container">
        <table class="w3 table w3-bordered">
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일</th>
      <th>지역</th>
      <th>접수상태</th>
    </tr>
    <c:forEach var="board" items="${riderList}">
    <tr>
       <td>${board.board_number}</td>
       <td><a href="/Board/riderDetail?board_number=${board.board_number}&menu_id=${board.menu_id}&pageNum=1&contentNum=10">${board.title}</a></td>
       <td>${board.writer}</td>
       <td>${board.indate}</td>
        <td>${board.rider_local}</td>
       <c:set var="check" value="${board.board_check}"/>
       <c:if test="${check == 0}">
         <td>접수대기<td>
       </c:if>
       <c:if test="${check == 1}">
         <td>접수중<td>
       </c:if>
       <c:if test="${check == 2}">
                <td>접수완료<td>
              </c:if>
    </tr>
    </c:forEach>
          <tr>
                    <td colspan="6">
                        <div id="paging" class="w3-bar w3-center">
              <c:if test="${boardPager.prev}">
                <a href="/Board/riderList?menu_id=MENU_02&pageNum=${boardPager.getStartPage()-1}&contentNum=${(boardPager.getStartPage()-1)*10}">< 이전</a>
              </c:if>
              <c:forEach begin="${boardPager.getStartPage()}" end="${boardPager.getEndPage()}" var="idx">
                <a href="/Board/riderList?menu_id=MENU_02&pageNum=${idx}&contentNum=${idx*10}">${idx}</a>
              </c:forEach>
              <c:if test="${boardPager.next}">
                <a href="/Board/riderList?menu_id=MENU_02&pageNum=${boardPager.getEndPage()+1}&contentNum=${(boardPager.getEndPage()+1)*10}">다음 ></a>
              </c:if>
        </div>
       </td>
        </tr>
       <tr>
       <td colspan="6">
          <a href="/Board/RBoardWriteForm?menu_id=MENU_02&pageNum=${boardPager.getEndPage()}&contentNum=${(boardPager.getEndPage())*10}"  class="w3-button w3-right w3-border w3-white">할게요 새글쓰기</a>
          </td>
        </tr>
  </table>
</div>
</div>
<script>
function w3_open() {
  document.getElementById("main").style.marginLeft = "15%";
  document.getElementById("mySidebar").style.width = "15%";
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("openNav").style.display = 'none';
}
function w3_close() {
  document.getElementById("main").style.marginLeft = "0%";
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("openNav").style.display = "inline-block";
}
</script>
</body>
</html>