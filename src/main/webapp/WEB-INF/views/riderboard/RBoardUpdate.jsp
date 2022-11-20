<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/common.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<style>
   body {

      padding-top: 70px;

      padding-bottom: 30px;

    }

    #title{
      width: 1000px;
      margin-left: 100px;
    }

    #r_start{
      width: 300px;
      margin-left:100px;
      display: inline-block

    }
    #r_end{
      width:300px;

      display: inline-block
    }
    #delivery_indate{
      width:300px;
      display: inline-block

    }
    #money{
      width: 300px;
      margin-left:100px;
      display: inline-block

    }
    #luggage{
      width: 300px;
      display: inline-block
    }
    #cont{
      margin-left:100px;
      width: 1500px;
      height: 500px;
    }
</style>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  <div id="main">
    <form action="/Board/RBoardUpdate" method="POST">
    <input type="hidden" name="board_number" value="${ riderBoardVo.board_number}" />
    <input type = "hidden" name =  "menu_id"      value = "${menu_id}"/>
    <input type = "hidden" name = "writer"        value = "${riderBoardVo.writer}"/>
    <div class="mb-3">

            <label for="title"></label>

            <input type="text" class="form-control wid1" name="title" id="title" value="${ riderBoardVo.title}" placeholder="제목을 입력해 주세요">

        </div>

    <br>
    <input type="text" class="form-control" name="r_start" id="r_start" value="${ riderBoardVo.r_start}" placeholder="출발지:부산 북구" >
    <input type="text" class="form-control" name="r_end" id="r_end" value="${ riderBoardVo.r_end}" placeholder="목적지:부산 진구">
    <input type="text" class="form-control" name="delivery_indate" id="delivery_indate" value="${ riderBoardVo.delivery_indate}" placeholder="2012-12-12" >
    <br>
    <input type="text" class="form-control" name="money" id="money" value="${ riderBoardVo.money}" placeholder="비용">
    <input type="text" class="form-control" name="luggage" id="luggage" value="${ riderBoardVo.luggage}" placeholder="컴퓨터" >

 </div>
 <br>
 <br>
 <br>
 <div class="mb-3">

   <label for="cont"></label>

   <textarea class="form-control" rows="5" name="cont" id="cont" placeholder="내용을 입력해 주세요" > ${ riderBoardVo.cont}</textarea>

 </div>
    </div>
    <div>
    </br>
      <input class = "btn btn-sm btn-primary" type="submit" value="수정" />
    </div>
    </form>
  </div>
</body>
</html>














