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
                    changePasswd += getUserid;
                    changePasswd += "</br>"
                    changePasswd += "<button id=\"changePasswd\" class=\"w3-button w3-section w3-teal w3-ripple\">비밀번호 변경</button>";
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
<form>
닉네임<input type="text" name="nickname" id="nickname"></input></br>
이메일<input type="email" name="email" id="email"></input></br>
<button id="findUserid" class="w3-button w3-section w3-teal w3-ripple"> 아이디 찾기 </button></br>
</form>
<div id="userid_check"></div></br>

</body>
</html>