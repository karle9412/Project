<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>
<body>
    <header class="w3-container w3-teal w3-center">
        <h1>내 정보</h1>
    </header>
<ul>
<li>
id ${userVo.userid}
</li>
<li>
nickname ${userVo.nickname}
</li>
<li>
email ${userVo.email}
</li>
<li>
local ${userVo.user_local}
</li>
<li>
rider ${userVo.rider}
</li>
<li>
indate ${userVo.indate}
</li>
</ul>
</body>
</html>
