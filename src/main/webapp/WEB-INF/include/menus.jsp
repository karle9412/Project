<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">

 <!--  메뉴목록  -->
  <table id="menu">
  <tr>
    <td>
    <a href="/">메인</a>
    </td>
  </tr>
  <tr>
    <td>
    <a href="/Board/RequestList?menu_id=MENU_01">해주세요</a>
    </td>
  </tr>
  <tr>
    <td>
    <a href="/Board/RequestList?menu_id=MENU_02">할게요</a>
    </td>
  </tr>
    <td>
    <a href="/Board/LatterList?menu_id=MENU_03">후기</a>
    </td>
  </tr>
  <tr>
    <td>
    <a href="/UserView?userid=${userid}">내 정보</a>
    </td>
  </tr>
  </table>