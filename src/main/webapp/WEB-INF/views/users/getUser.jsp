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
<link rel="stylesheet" href="/css/common.css">

</head>
<body>
    <%@ include file="/WEB-INF/include/menus.jsp" %>
<div id="main">

    <div class="w3-teal1">
        <table>
            <tr>
                <td>
                    <button id="openNav" class="w3-button w3-teal1 w3-xlarge" onclick="w3_open()">&#9776;</button>
                </td>
                <td>
                    <div class="w3-container w3-center">
                        <h1>내 정보</h1>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <div class="w3-row-padding">
        <div class="w3-third">
        <img src="/img/userProfile/${userVo.userid}/${filesVo.sFileName}" class="w3-circle" alt="UserProfile" style="width : 100%"/>
        </div>

        <div class="w3-twothird">
            <p> id : ${userVo.userid} </p>
            <p> nickname : ${userVo.nickname}</p>
            <p> email : ${userVo.email}</p>
            <p> local : ${userVo.user_local}</p>
            <p> rider : ${userVo.rider}</p>
            <p> indate : ${userVo.indate}</p>
            <p> phoneNumber : ${userVo.phoneNumber}</p>

            <a href="/updateForm" class="w3-button w3-section w3-teal w3-ripple" enc-type = "multipart/form-data"> 회원정보 수정 </a>
            <a href="/delete" class="w3-button w3-section w3-teal w3-ripple" >회원탈퇴</a>
            <a href="javascript:void(window.open('pds/profileUpdateForm', '아이디 찾기','width=500, height=500'))"
                class="w3-button w3-section w3-teal w3-ripple"> 프로필 사진 업데이트</a>
        </div>
    </div
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
</script>
</body>
</html>
