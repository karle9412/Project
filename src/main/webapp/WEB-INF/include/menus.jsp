<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">

 <!--  메뉴목록  -->
  <table id="menu">
  <tr>
    <td>
    <a href="/Board/RequestList?menu_id=MENU_01">요청</a>
    </td>
  </tr>
  <tr>
    <td>
    <a href="/Board/LatterList?menu_id=MENU_02">후기</a>
    </td>
  </tr>
  <tr>
    <td>
    <a href="/UserView?userid=${userid}">내 정보</a>
    </td>
  </tr>
  </table>