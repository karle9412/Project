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

    <a href="/User/getUser"> 내 정보</a>


</body>
</html>