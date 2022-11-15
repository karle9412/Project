<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<title>Insert title here</title>
<style>
body {

  padding-top: 70px;

  padding-bottom: 30px;

}

#title{
  width: 1000px;
  margin-left: 100px;
}

#c_start{
  width: 300px;
  margin-left:100px;
  display: inline-block

}
#c_end{
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

</head>
<body>


        <h2 >글쓰기</h2>
                 <form action="/Board/CBoardWrite" method="POST">
                 <input type = "hidden" name = "menu_id" value = "${menu_id}"/>
                 <input type = "hidden" name = "pageNum" value =  "${cPageNum}"/>
                 <input type=  "hidden" name = "contentNum" value = "${cContentNum}"/>
                 <input type = "hidden" name = "writer" value ="${writer}"
                 <div class="mb-3">

        					<label for="title"></label>

        					<input type="text" class="form-control wid1" name="title" id="title" placeholder="제목을 입력해 주세요">

        				</div>

                 <br>
                <input type="text" class="form-control" name="c_start" id="c_start" placeholder="출발지:부산 북구" >
                <input type="text" class="form-control" name="c_end" id="c_end" placeholder="목적지:부산 진구">
                <input type="text" class="form-control" name="delivery_indate" id="delivery_indate" placeholder="2012-12-12" >
                <br>
                <input type="text" class="form-control" name="money" id="money" placeholder="비용">
                <input type="text" class="form-control" name="luggage" id="luggage" placeholder="컴퓨터" >

              </div>
              <br>
              <br>
              <br>
              <div class="mb-3">

                <label for="cont"></label>

                <textarea class="form-control" rows="5" name="cont" id="cont" placeholder="내용을 입력해 주세요" ></textarea>

              </div>
                 </div>
                 <div>
                 </br>
                   <input class = "btn btn-sm btn-primary" type="submit" value="저장" />
                 </div>
                 </form>
               </div>






</body>
</html>