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
</head>
<body>
    <header class="w3-container w3-teal w3-center">
        <h1>Register</h1>
    </header>
    <form action="/write" method="POST" class="w3-container w3-card-4 w3-light-grey w3-margin">
        <div class="w3-row w3-section">
            <div class="w3-col" style="width:50px"></div>
            <div class="w3-rest">
                <input class="w3-input w3-border" name="userid" type="text" placeholder="ID">
            </div>
        </div>
        <div class="w3-row w3-section">
            <div class="w3-col" style="width:50px"></div>
            <div class="w3-rest">
                <input class="w3-input w3-border" name="passwd" type="password" placeholder="Password">
            </div>
        </div>
        <div class="w3-row w3-section">
            <div class="w3-col" style="width:50px"></div>
            <div class="w3-rest">
                <input class="w3-input w3-border" name="username" type="text" placeholder="NickName">
            </div>
        </div>
        <div class="w3-row w3-section">
            <div class="w3-col" style="width:50px"></div>
            <div class="w3-rest">
                <input class="w3-input w3-border" name="email" type="text" placeholder="EMail">
            </div>
        </div>
        <select id="LOACTION" name="userLocal">
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
