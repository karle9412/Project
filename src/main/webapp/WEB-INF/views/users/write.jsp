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
function email_check( email ) {

    var regex=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    return (email != '' && email != 'undefined' && regex.test(email));

}

const autoHyphen = (target) => {
 target.value = target.value
   .replace(/[^0-9]/g, '')
   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}


$(function(){

    $('[name=email]').on('focusout',function(){

            var email = $(this).val();

            if( email == '' || email == 'undefined') return;

            if(! email_check(email) ) {
                $('#emailCheck').html('잘못된 형식의 이메일 주소입니다.');
            } else {
                $('#emailCheck').html('정확한 이메일입니다.');
            }
        });

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

        if($('#passwdCheck').html()== "비밀번호가 일치하지 않습니다."){
            alert('비밀번호가 일치 않네요!');
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

        if($('#emailCheck').html()== "잘못된 형식의 이메일 주소입니다."){
            alert('이메일이 틀렸어요!');
            return false;
        }

        if($('[name=phoneNumber]').val() == ''){
            alert('전화번호를 입력해주세요');
            return false;
        }

        if($('[name=phoneNumber]').val().length != 13){
            alert('전화번호는 -포함 13자리어야 해요');
            return false;
        }

        if($('[name=user_local]').val()==''){
            alert('지역을 선택해주세요');
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
    <header class="w3-container w3-teal1 w3-center">
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
                <input class="w3-input w3-border" name="email" type="text" placeholder="EMail"/>
            </div>
            <div class="w3-rest">
                <span id="emailCheck"></span>
            </div>
        </div>
        <div class="w3-row w3-section">
            <div class="w3-col" style="width:50px"></div>
            <div class="w3-rest">
                <input class="w3-input w3-border" name="phoneNumber" type="text"
                    oninput="autoHyphen(this)" maxlength="13" placeholder="000-0000-0000" autofocus/>
            </div>
        </div>
        <select class="w3-select" id="LOACTION" name="user_local">
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
