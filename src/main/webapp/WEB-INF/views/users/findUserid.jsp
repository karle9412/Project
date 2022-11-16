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
                    changePasswd += "<form action=\"/changePasswdForm\" class=\"w3-container w3-card-4\" method=\"POST\">";
                    changePasswd += '<input type="hidden" name="userid" value=' + getUserid + '></input>';
                    changePasswd += "<div class=\"w3-container w3-center\">";
                    changePasswd += "<p> userid : " + getUserid + "</p>";
                    changePasswd += "</div>";
                    changePasswd += "<button id=\"changePasswd\" class=\"w3-button w3-section w3-teal w3-ripple w3-right\">비밀번호 변경</button>";
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
<header class="w3-container w3-teal w3-center">
    <h1>Userid 찾기</h1>
</header>
    <div class="w3-container w3-half w3-margin-top w3-display-middle" style="height:70%">
        <form class="w3-container w3-card-4">
            <p>
                <input class="w3-input" id="nickname" name="nickname" type="text" style="width:100%">
                <label>nickname</label>
            </p>
            <p>
                <input class="w3-input" id="email" name="email" type="text" style="width:100%">
                <label>email</label>
            </p>
            <p>
                <input type="button" id="findUserid" class="w3-button w3-section w3-teal w3-ripple w3-right" value="아이디 찾기"></button>
            </p>
        </form>
            <p>
                <div id="userid_check"></div>
            </p>
    </div>
</body>
</html>


