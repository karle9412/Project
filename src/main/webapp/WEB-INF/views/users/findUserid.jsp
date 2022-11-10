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
        if($('[name=nickname]').val()=='' && $('[name=passwd]').val()==''){
            alert('닉네임과 이메일을 입력하세요');
            return false;
        }
        let nickname = $('#nickname').val();
        let email = $('#email').val();

        $.ajax({
            type : 'POST',
            url : "getUserid",
            dataType : "text",
            data : { nickname : nickname,
                     email : email},
            success : function(getUserid){
                if(getUserid != null){
                    console.log(getUserid);
                    let decode_getUserid = decodeURIComponent(getUserid);
                    console.log(decode_getUserid);
                    $("#userid_check").html(decode_getUserid);
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
<button id="findUserid" class="w3-button w3-section w3-teal w3-ripple"> 아이디 찾기 </button>
<li><span id="userid_check"></span></li><br>

</form>

</body>
</html>