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
$(function (){

    $('#passwd').keyup(function(){
        $("#passwdDoubleCheck").empty();
    })

    $('#passwdCheck').on('focusout', function(e){
        let passwd = $('#passwd').val();
        let passwdCheck = $('#passwdCheck').val();
        let userid = $('[name=userid]').val();

        console.log(passwd);

        let passwdChange = ""

        if (passwd == passwdCheck){
            passwdChange = '<form action="/changePasswd" id="changePasswd" class="w3-container w3-card-4">';
            passwdChange += "<div class=\"w3-container w3-center\">";
            passwdChange += "<p>Passwd Check<br>";
            passwdChange += "Complite</p>";
            passwdChange += "</div>";
            passwdChange += '<input type="hidden" name="userid" value=' + userid + '></input>';
            passwdChange += '<input type="hidden" name="passwd" value=' + passwd + '></input>';
            passwdChange += '<button type="submit" id="send" class="w3-button w3-section w3-teal w3-ripple w3-right">비밀번호변경</input>';
            passwdChange += '</form>';
            $("#passwdDoubleCheck").html(passwdChange);
        } else {
            $("#passwdDoubleCheck").html("비밀번호가 다릅니다.");
            alert('비밀번호를 다시 확인하세요.')
            return false;
        }
    })

});

</script>
</head>
<body>
<header class="w3-container w3-teal w3-center">
    <h1>Passwd 변경</h1>
</header>
<input type="hidden" name="userid" value="${userVo.userid}"> </input>

<div class="w3-container w3-half w3-margin-top w3-display-middle" style="height:70%">
    <p>
        <input class="w3-input" id="passwd" type="password" style="width:100%">
        <label>passwd</label>
    </p>
    <p>
    <input class="w3-input" id="passwdCheck" type="password" style="width:100%">
        <label>passwd Check</label>
    </p>
<div id="passwdDoubleCheck"></div>
</div>
</body>
</html>