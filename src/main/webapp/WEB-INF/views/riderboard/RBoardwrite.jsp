<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

     <h2>글쓰기</h2>
     <form action="/Board/RBoardWrite" method="POST">
     <input type = "hidden" name = "menu_id" value = "${menu_id}"/>
      <input type = "hidden" name = "pageNum" value =  "${cPageNum}"/>
              <input type=  "hidden" name = "contentNum" value = "${cContentNum}"/>
      <div>
              제목:<input type="text" name="title" id="title" size=50; placeholder="제목을 입력해주세요"/>
              </div>
              <div>
              작성자:<input type="text" name="writer"/>
              </div>
              <div>
              출발지:<input type="text" name="c_start" />
              </div>
              <div>
               목적지:<input type="text" name="c_end" />
               </div>
               <div>
               일자:<input type="text" name="delivery_indate"/>
               </div>
               <br>
               비용:<input type="text" name="money" />
               수화물:<input type="text" name="luggage" />
              </br>
              <br>
           </div>
              <div>
               <textarea name="cont" cols="80" rows="30">

             </textarea>
              </div>
              <div>
              </br>
                <input type="submit" value="저장" />
              </div>
              </form>
   </div>

</body>
</html>