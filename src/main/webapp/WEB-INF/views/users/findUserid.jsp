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
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>

function goChangePasswd(){}

$(function(){

    $('#findUserid').on('click', function(e){

        let nickname = $('#nickname').val();
        let email = $('#email').val();

        $.ajax({
            type : 'POST',
            url : "getUserid",
            dataType : "text",
            data : {
                nickname : nickname,
                email : email},
            success : function(getUserid){
                if (getUserid =="닉네임과 이메일을 다시 확인해주세요"){
                    $("#userid_check").html(getUserid);
                } else {
                    let changePasswd = "";
                    changePasswd += "<form action=\"/changePasswdForm\" method=\"POST\">";
                    changePasswd += '<input type="hidden" name="userid" value=' + getUserid + '></input>';
                    changePasswd += "<p> userid : " + getUserid + "</p>";
                    changePasswd += "<button id=\"changePasswd\">비밀번호 변경</button>";
                    changePasswd += "</form>";
                    $("#userid_check").html(changePasswd);
                }
            }
        })
        e.preventDefault();
        e.stopPropagation();
    })
});

</script>
</head>
<body>
<header >
    <h1>Userid 찾기</h1>
</header>
    <form>
        <input id="nickname" name="nickname" type="text">
        <label>nickname</label>
        <input id="email" name="email" type="text">
        <label>email</label>
        <input type="button" id="findUserid" value="아이디 찾기"></input>
        <div id="userid_check"></div>
    </form>
            <a href="changePasswdForm" type="button" id="changePasswd">비밀번호 변경</a>


</body>
</html>


