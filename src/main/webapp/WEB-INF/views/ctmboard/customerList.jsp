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
<script>
function btnSearch(e){
  e.preventDefault();
  var url = "/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10";
  url += "&searchType=" + $("#searchType").val();
  url += "&keyword=" + $("#keyword").val();
  if ($("#keyword").val() === ""){
    alert("검색 할 키워드를 입력해주세요.");
  }else{
    location.href = url;
  }
}
let urlParams = new URL(location.href).searchParams;
if (urlParams != ''){
console.log(urlParams);
console.log(window.location.href);
}else{
console.log(urlParams);
console.log(window.location.href);
}
</script>
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
                        픽업 해주세요
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

            <c:forEach var="board" items="${customerList}">
                <tr>
                    <td>${board.board_number}</td>
                    <td><a href="/Board/CustomerDetail?board_number=${board.board_number}&menu_id=${board.menu_id}&pageNum=1&contentNum=10&board_check=0">${board.title}</a></td>
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
            <tr>
            <td colspan="6">
              <c:set var="url" value="http://localhost:8080/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10"/>
              <c:choose>
                <c:when test="${ url eq 'http://localhost:8080/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10'}">
                  <div id="paging" class="w3-bar w3-center">
                    <c:if test="${boardPager.prev}">
                      <a href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getStartPage()-1}&contentNum=${(boardPager.getStartPage()-1)*10}" class="w3-button">< 이전</a>
                    </c:if>
                    <c:forEach begin="${boardPager.getStartPage()}" end="${boardPager.getEndPage()}" var="idx">
                      <a href="/Board/customerList?menu_id=MENU_01&pageNum=${idx}&contentNum=${idx*10}" class="w3-button">${idx}</a>
                    </c:forEach>
                    <c:if test="${boardPager.next}">
                      <a href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getEndPage()+1}&contentNum=${(boardPager.getEndPage()+1)*10}" class="w3-button">다음 ></a>
                    </c:if>
                  </div>
                </c:when>
                <c:otherwise>
                  <div id="paging" class="w3-bar w3-center">
                    <c:if test="${boardPager.prev}">
                      <a href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getStartPage()-1}&contentNum=${(boardPager.getStartPage()-1)*10}&searchType=${map.searchType}&keyword=${map.keyword}" class="w3-button">< 이전</a>
                    </c:if>
                    <c:forEach begin="${boardPager.getStartPage()}" end="${boardPager.getEndPage()}" var="idx">
                      <a href="/Board/customerList?menu_id=MENU_01&pageNum=${idx}&contentNum=${idx*10}&searchType=${map.searchType}&keyword=${map.keyword}" class="w3-button">${idx}</a>
                    </c:forEach>
                    <c:if test="${boardPager.next}">
                      <a href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getEndPage()+1}&contentNum=${(boardPager.getEndPage()+1)*10}&searchType=${map.searchType}&keyword=${map.keyword}" class="w3-button">다음 ></a>
                    </c:if>
                  </div>
                </c:otherwise>
              </c:choose>
            </td>
          </tr>
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
                  <a href="/Board/CBoardWriteForm?menu_id=MENU_01&pageNum=${boardPager.getEndPage()+1}&contentNum=${(boardPager.getEndPage()+1)*10}"
                    class="w3-button w3-right w3-border">해주세요 새글쓰기</a>
                </td>
              </tr>
            </table>
    </div>
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

document.getElementById("btnSearch").addEventListener('click',btnSearch);

</script>

 <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; BananaQuick Website 2022</div>

                        </div>
                    </div>
                </footer>


</body>
</html>
