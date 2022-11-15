<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>

<script>
$(function(){

    $('form').on('submit',function(e){

        if($('[name=userid]').val()==''){
            alert('아이디를 입력하세요');
            return false;
        }

        if($('[name=idCheckResult]').html()== "중복된 아이디입니다."){
            alert('중복확인을 다시 해주세요');
            return false;
        }

        if($('[name=passwd]').val()==''){
            alert('비밀번호를 입력하세요');
            return false;
        }

        if($('[name=nickname]').val()==''){
            alert('닉네임을 입력하세요');
            return false;
        }

        if($('[name=email]').val()==''){
            alert('이메일을 입력하세요');
            return false;
        }

        if($('[name=user_local]').val()==''){
            alert('지역을 선택해주세요');
            return false;
        }
        if($('[name=phoneNumber]').val()==''){
            alert('전화번호를 입력해주세요');
            return false;
        }

    });

    $('#idCheck').on('click', function(e){

        let userid = $('[name=userid]').val();

        $.ajax({
            type : 'POST',
            url : "useridCheck",
            dataType : "text",
            data : {
                userid : userid
            },
            success : function(useridCheck){
                $("#idCheckResult").html(useridCheck);
            }
        })
        e.preventDefault();
        e.stopPropagation();
    });

    $('[name=passwdCheck]').keyup(function(){
        let passwd = $('[name=passwd]').val();
        let passwdCheck = $('[name=passwdCheck]').val();

        if (passwd == passwdCheck){
            $('#passwdCheck').html("비밀번호가 일치합니다.")
        } else{
            $('#passwdCheck').html("비밀번호가 일치하지 않습니다.")
        }
    })

});

</script>
</head>
<body>
    <header class="w3-container w3-teal w3-center">
        <h1>Register</h1>
    </header>
    <form action="/userProfileUploadForm" method="POST" class="w3-container w3-card-4 w3-light-grey w3-margin">
        <div class="w3-row w3-section">
            <div class="w3-col" style="width:50px"></div>
            <div class="w3-rest">
                <input class="w3-input w3-border" name="userid" type="text" placeholder="ID">
            </div>
            <div class="w3-rest">
                <div>
                    <span id="idCheckResult" name="idCheckResult"></span>
                    <button id="idCheck" class="w3-button w3-section w3-light-green w3-ripple w3-text-white w3-right"
                     style=" margin-top: 10px; padding-top: 4px; padding-bottom: 4px; padding-left: 8px; padding-right: 8px;">중복확인</button>
                </div>
            </div>
        </div>
        <div class="w3-row w3-section">
            <div class="w3-col" style="width:50px"></div>
            <div class="w3-rest">
                <input class="w3-input w3-border" name="passwd" type="password" placeholder="Password"/>
            </div>
        </div>
            <div class="w3-col" style="width:50px"></div>
            <div class="w3-rest">
                <input class="w3-input w3-border" name="passwdCheck" type="password" placeholder="passwordCheck"/>
            </div>
            <div class="w3-rest">
                <span id="passwdCheck"></span>
            </div>
        </div>
        <div class="w3-row w3-section">
            <div class="w3-col" style="width:50px"></div>
            <div class="w3-rest">
                <input class="w3-input w3-border" name="nickname" type="text" placeholder="NickName">
            </div>
        </div>
        <div class="w3-row w3-section">
            <div class="w3-col" style="width:50px"></div>
            <div class="w3-rest">
                <input class="w3-input w3-border" name="email" type="email" placeholder="EMail">
            </div>
        </div>
        <div class="w3-row w3-section">
            <div class="w3-col" style="width:50px"></div>
            <div class="w3-rest">
                <input class="w3-input w3-border" name="phoneNumber" type="text" placeholder="000-0000-0000"/>
            </div>
        </div>
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
        </select>
        <br>
        <br>
        <input class="w3-radio w3-text-black" type="radio" name="rider" value="normal" checked>
            <label>Normal User</label>
            <input class="w3-radio" type="radio" name="rider" value="rider">
            <label>Service User</label></p>
        <p class="w3-center">
            <button class="w3-button w3-section w3-light-green w3-ripple w3-text-white"> REGISTER </button>
        </p>
    </form>
</body>
</html>
