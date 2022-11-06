<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  #board  td:nth-of-type(1) { width:150px; text-align:center;}
  #board  td:nth-of-type(2) { width:400px; text-align:left;}
  #board  td:nth-of-type(3) { width:150px; text-align:center;}
  #board  td:nth-of-type(4) { width:400px; text-align:left;}

  #board  tr:nth-of-type(4) { height : 400px; vertical-align: top; }


  #board  input     { width:100%; }
  #board  textarea  { width:100%; height: 400px;  }


</style>

</head>
<body>
 <table id="board">
       <caption><h2>내용 보기</h2></caption>
       <tr>
        <td>번호</td>
        <td>테스트 </td>
       </tr>
       <tr>
        <td>작성일</td>
        <td>테스트 </td>
        <td>작성자</td>
        <td>테스트</td>
       </tr>
       <tr>
        <td>제목</td>
        <td colspan="3">테스트 </td>
       </tr>
       <tr>
        <td>내용</td>
        <td colspan="3">테스트</td>
       </tr>

</body>
</html>
