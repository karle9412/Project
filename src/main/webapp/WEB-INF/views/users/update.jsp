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
        <h1>회원정보 수정</h1>
    </header>
    <form action="/update">
    <input type="hidden" name="userid" value="${userVo.userid}"></input>
    nickname<input type="text" name="nickname" placeholder="nickname" value="${userVo.nickname}"></input></br>
    <select id="LOACTION" name="user_local">
                <option value="">LOCATION</option>
                <option value="seoul">Seoul</option>
                <option value="incheon">Incheon</option>
                <option value="pusan">Pusan</option>
                <option value="daejeon">Daejeon</option>
                <option value="daegu">Daegu</option>
                <option value="ulsan">Ulsan</option>
                <option value="jeju">Jeju</option>
                <option value="kyeonggi">Kyeonggi</option>
                <option value="kangwon">Kangwon</option>
                <option value="kyeonsang">Kyeonsang</option>
                <option value="jeonra">Jeonra</option>
                <option value="choongchung">Choongchung</option>
            </select></br>
    <input class="w3-radio w3-text-black" type="radio" name="rider" value="normal" checked>
                <label>Normal User</label>
                <input class="w3-radio" type="radio" name="rider" value="rider">
                <label>Service User</label></br>
    <button class="w3-button w3-section w3-light-green w3-ripple w3-text-white">수정 완료</a>
    </form>
</body>
</html>
