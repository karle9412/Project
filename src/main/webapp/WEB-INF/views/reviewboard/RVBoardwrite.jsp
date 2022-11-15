<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<style>
body {

  padding-top: 70px;

  padding-bottom: 30px;

}

#title{
  width: 1500px;
  margin-left: 100px;
}

#cont{
  margin-left:100px;
  width: 1500px;
  height: 500px;
}
</style>

</head>
<body>

     <h2>글쓰기</h2>
     <form action="/Board/RVBoardWrite" method="POST">
     <input type = "hidden" name = "menu_id" value = "${menu_id}"/>
     <input type = "hidden" name = "writer" value= "${writer}"/>
     <input type = "hidden" name = "pageNum" value =  "${cPageNum}"/>
     <input type=  "hidden" name = "contentNum" value = "${cContentNum}"/>
     	<label for="title"></label>

         <input type="text" class="form-control wid1" name="title" id="title" placeholder="제목을 입력해 주세요">

   </div>
      <div class="mb-3">

                        <label for="cont"></label>

                        <textarea class="form-control" rows="5" name="cont" id="cont" placeholder="내용을 입력해 주세요" ></textarea>

                      </div>
     <div>
      <input class = "btn btn-sm btn-primary" type="submit" value="저장" />
     </div
     >
     </form>
   </div>

</body>
</html>