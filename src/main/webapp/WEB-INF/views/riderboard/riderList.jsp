<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>
function btnSearch(e){
  e.preventDefault();
  var url = "/Board/riderList?menu_id=MENU_01&pageNum=1&contentNum=10";
  url += "&searchType=" + $("#searchType").val();
  url += "&keyword=" + $("#keyword").val();
  if ($("#keyword").val() === ""){
    alert("검색 할 키워드를 입력해주세요.");
  }else{
    location.href = url;
  }
}
</script>
<title>Insert title here</title>
</head>
<body>
  <div id="main">
  <%@ include file="/WEB-INF/include/menus.jsp" %>
  <table class="table riderList">
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
       <td>${board.board_local}</td>
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
  </div>
        <div id="paging">
          <tr>
            <td>
            <c:choose>
              <c:when test="${map.keyword eq ''}">
                <div id="paging" class="w3-bar w3-center">
                  <c:if test="${boardPager.prev}">
                    <a href="/Board/riderList?menu_id=MENU_01&pageNum=${boardPager.getStartPage()-1}&contentNum=${(boardPager.getStartPage()-1)*10}" class="w3-button">< 이전</a>
                  </c:if>
                  <c:forEach begin="${boardPager.getStartPage()}" end="${boardPager.getEndPage()}" var="idx">
                    <a href="/Board/riderList?menu_id=MENU_01&pageNum=${idx}&contentNum=${idx*10}" class="w3-button">${idx}</a>
                  </c:forEach>
                  <c:if test="${boardPager.next}">
                    <a href="/Board/riderList?menu_id=MENU_01&pageNum=${boardPager.getEndPage()+1}&contentNum=${(boardPager.getEndPage()+1)*10}" class="w3-button">다음 ></a>
                  </c:if>
                </div>
              </c:when>
              <c:otherwise>
                <div id="paging" class="w3-bar w3-center">
                  <c:if test="${boardPager.prev}">
                    <a href="/Board/riderList?menu_id=MENU_01&pageNum=${boardPager.getStartPage()-1}&contentNum=${(boardPager.getStartPage()-1)*10}&searchType=${map.searchType}&keyword=${map.keyword}" class="w3-button">< 이전</a>
                  </c:if>
                  <c:forEach begin="${boardPager.getStartPage()}" end="${boardPager.getEndPage()}" var="idx">
                    <a href="/Board/riderList?menu_id=MENU_01&pageNum=${idx}&contentNum=${idx*10}&searchType=${map.searchType}&keyword=${map.keyword}" class="w3-button">${idx}</a>
                  </c:forEach>
                  <c:if test="${boardPager.next}">
                    <a href="/Board/riderList?menu_id=MENU_01&pageNum=${boardPager.getEndPage()+1}&contentNum=${(boardPager.getEndPage()+1)*10}&searchType=${map.searchType}&keyword=${map.keyword}" class="w3-button">다음 ></a>
                  </c:if>
                </div>
              </c:otherwise>
            </c:choose>
            </td>
          </tr>
        </div>

  </table>
    <table class="w3 table w3-bordered">
      <tr>
        <td>
          <select id="searchType">
            <option value="title">제목</option>
            <option value="board_local">지역</option>
            <option value="writer">작성자</option>
            <option value="board_check">접수상태</option>
          </select>
          <input id="keyword" type="text">
          <button id="btnSearch">검색</button>
        </td>
        <td>
        <a href="/Board/RBoardWriteForm?menu_id=MENU_02&pageNum=${boardPager.getEndPage()}&contentNum=${(boardPager.getEndPage())*10}">할게요 새글쓰기</a>
        </td>
      </tr>
    </table>
</body>
<script>
// 검색 클릭하면 호출 body 아래 script 안에 있어야 함 위에 있는 script 로 이동 금지
document.getElementById("btnSearch").addEventListener('click',btnSearch);
</script>
</html>