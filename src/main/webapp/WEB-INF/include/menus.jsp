<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">

 <!--  메뉴목록  -->
  <table id="menu">
  <tr>
    <td>
    <a href="/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10">메인(일단 해주세요로감)</a>
    </td>
  </tr>
  <tr>
    <td>
    <a href="/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10">해주세요</a>
    </td>
  </tr>
  <tr>
    <td>
    <a href="/Board/riderList?menu_id=MENU_02&pageNum=1&contentNum=10">할게요</a>
    </td>
  </tr>
    <td>
    <a href="/Board/reviewList?menu_id=MENU_03&pageNum=1&contentNum=10">후기</a>
    </td>
  </tr>
  <tr>
    <td>
     <a href="/logout">로그아웃</a>
    </td>
   </tr>
  <tr>
    <td>
     <a href="/getUser">내 정보</a>
    </td>
  </tr>
  </table>