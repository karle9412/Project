<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>



</head>
<body>
<form method="post" id="smsForm">
      <input type="hidden" name="from" value="01048005799"/></li>
       <input type="hidden" name="text" value=""/>
  </form>

<script>
function sendSMS(){


$("#smsForm").attr("action", "/Board/SMS");
$("#smsForm").submit();
      }
    </script>
</body>
</html>