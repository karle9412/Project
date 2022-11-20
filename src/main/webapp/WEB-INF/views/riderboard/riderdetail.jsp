<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open Sans">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>

<style>


h1,h2,h3,h4,h5,h6 {font-family: "Oswald"}
body {font-family: "Open Sans"}
.date{font-size: 11px}
.comment-text{font-size: 12px}
.fs-12{font-size: 12px}
.shadow-none{box-shadow: none}
.name{color: #007bff}
.cursor:hover{color: blue}
.cursor{cursor: pointer}
.textarea{resize: none}
.textarea.form-control { height: auto; }
.headerB{ font-size: 80px!important }
.headerD{ font-size: 25px!important; background-color: #000; color: #fff; padding: 0px 8px 4px 8px; text-align: center; }
.page-linkA {
    position: relative;
    padding: 10px 15px;
    margin-left: 5px;
    line-height: 1.25;
    color: #000;
    background-color: #fff;
    border: 1px solid #a0a0a0;
    text-decoration: none;
    text-align:center;
    font-size: 15px!important;
    border-radius: 10%;
}
.ReplyPa { text-align: center; padding-bottom: 10px; margin: 30px 0px;}
.PageNum { color: #4c72db; text-decoration: underline; font-weight: bold;}

a { text-decoration:none; }
a:hover { text-decoration:underline; color:#007bff; }
a.page-linkA:hover  { font-weight: bold; text-decoration: none; background: rgba(210,210,210,1); color: #4c72db; border: 1px solid #000; }

</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
window.onload = function(){
replylist();

}



function RRFU(reply_number, i){
console.log(i);
let html="";
html += '<form action="RRF/RRFU" method="POST" enctype="multipart/form-data">';
html += '<input type="hidden" name="board_number" value="${riderBoardVo.board_number}"></input>'
html += '<input type="hidden" name="menu_id" value="${menu_id}"></input>'
html += '<input type="hidden" name="rider_reply_number" value=' + reply_number + '></input>'
html += '<input type="file" name="filename" ></input>';
html += '<button type="submit">파일보내기</input>';
html += '</form>';
$('[name=fileUpload'+i+']').html(html);

}

function DeleteBoard(){
  let ans = confirm("삭제하시겠습니까?");
  if(ans){
    if("${nickName}" != "${riderBoardVo.writer}"){
      alert("본인이 작성한 게시글만 삭제 가능합니다");
    }
    else{
      $.ajax({
        type:"get",
        url:"/Board/RBoardDelete?board_number=${riderBoardVo.board_number}&menu_id=${menu_id}",
        success:function(result){
          alert("삭제되었습니다");
          location.href='/Board/riderList?menu_id=MENU_02&pageNum=1&contentNum=10';
        }
      });
    }
  }
}

function updateReplyForm(reply_number,writer){
  let k = document.getElementById("R"+reply_number);
  if("${nickName}" != writer){
    alert("본인이 작성한 댓글만 수정 가능합니다.");
  }
  else{
    const writer_check =confirm("수정하시겠습니까?");
    let k = document.getElementById("R"+reply_number);
    let form = "";

    form += '<div>';
    form += '<input type= "hidden" name="reply_numbery" id ="reply_number" value= '+reply_number+'>';
    form += '<input type= "hidden"  name="writer" id= "writer" value='+ writer +'>'
    form += '<textarea class = "replyclass" id= "replycontent" cols="80" rows="3">';
    form += k.textContent;
    form += "</textarea>";
    form += "<br/>";
    form +='<button type = "button" class="Updatebtn" onClick="updateReply(' + reply_number +',\'' + writer + '\')"> 완료 </button>';
    form +='<button type = "button" class="DeleteBtn" onClick="replylist()" >';
    form += '취소';
    form += '</button>';
    form += '</div>';
    form += '</br>';
    document.getElementById("R"+reply_number).innerHTML = form;
    $("[name=replyupdateBtn]").css('display', 'none');
    $("[name=replydeleteBtn]").css('display', 'none');
  }
}

function updateReply(reply_number, writer){
  let reply_content = $("#replycontent").val();
  let replynumber = reply_number;
  let reply_writer = writer;
  let updateurl = "/Board/R_replyUpdate?reply_number=";
  let updateurl1= "&cont="
  let param = {"cont":reply_content, "reply_number":replynumber, "writer":reply_writer};

  $.ajax({
    type: "POST",
    url: updateurl + replynumber + updateurl1 + reply_content,
    data: param,
    success: function(result){
      alert("댓글이  수정되었습니다");
      replylist();
    },
    error: function(error_){
      if($('#replycontent').val() == ''){
        alert('댓글을 입력해주세요.')
      }
    }
  });
}

function deleteReply(reply_number,writer){
  let deleturl = "/Board/R_ReplyDelete?reply_number="
  let DeleteReply_number = reply_number
  let ans = confirm("삭제하시겠습니까?");
  if("${nickName}" != writer){
    alert("본인이 작성한 댓글만 삭제 가능합니다");
  }
  else{
    if(ans === true){
      $.ajax({
        type: "POST",
        url: deleturl + DeleteReply_number,
        success: function(deleteresult){
          alert("댓글이 삭제되었습니다");
          let total   = ${replyPager.totalCount} - 1;
          let contentnum = ${replyPager.pageNum+1} * 10;
          if ((contentnum - total) == 10 ){
            location.href='/Board/riderDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum='+ ${replyPager.pageNum} +'&contentNum='+ contentnum +'';
          }
          else{
            location.href='/Board/riderDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum=${replyPager.pageNum+1}&contentNum=${replyPager.contentNum}';
          }
        }
      });
    }
  }
}
</script>
</head>
<%@ include file="/WEB-INF/include/menus.jsp" %>
<body class="w3-light-grey">
<header class="w3-container w3-center w3-white" style="padding-top: 80px; padding-bottom: 80px;">
  <h1 class="headerB"><b>Banana Quick</b></h1>
  <h6><span class="headerD">delivery's world</span></h6>
</header>
<div class="w3-content" style="max-width:1600px; margin:auto;">
  <div class="w3-row w3-padding w3-border" style="margin: 50px 0px;">
    <div>
      <div class="w3-container w3-white w3-margin w3-padding-large"  style="border: 1px solid #ccc;">
        <div class="w3-center">
          <h3 style="font-size:40px; border:1px solid #ccc!important"> 제목: ${ riderBoardVo.title }</h3>
          <table id="board" style="border:1px solid #ccc!important">
            <tr style="border:1px solid #ccc!important">
              <td width= 300px; style="text-align: left; padding: 10px 15px;"><strong>작성자&nbsp;:</strong> &nbsp; ${ riderBoardVo.writer }</td>
              <td width= 300px; style="text-align: left"><strong>비용&nbsp:</strong> &nbsp; ${riderBoardVo.money}</td>
              <td width= 300px; style="text-align: left"><strong>수화물&nbsp;:</strong> &nbsp; ${riderBoardVo.luggage}</td>
              <td width= 300px; style="text-align: left"><strong>접수여부&nbsp;:</strong> &nbsp;
                <c:if test="${riderBoardVo.board_check == 0}"> 접수대기 </c:if>
                <c:if test="${riderBoardVo.board_check == 1}"> 접수중 </c:if>
                <c:if test="${riderBoardVo.board_check == 2}"> 접수완료 </c:if></td>
              <td width= 300px; style="text-align: left"><strong>작성일&nbsp;:</strong> &nbsp ${ riderBoardVo.indate }</td>
            </tr>
            <tr>
              <td width= 300px; style="text-align: left; padding: 10px 15px;"><strong>출발지&nbsp;: &nbsp; ${riderBoardVo.r_start}</td>
              <td width= 300px; style="text-align: left"><strong>목적지:</strong> &nbsp; ${riderBoardVo.r_end}</td>
              <td width= 300px; style="text-align: left"><strong>도착일:</strong> &nbsp; ${riderBoardVo.delivery_indate}</td>
            </tr>
          </table>
        </div>
        <div class="w3-justify" >
          <p style="margin: 30px 0px; border: 1px solid #ccc; padding: 20px 20px;">${ riderBoardVo.cont }</p>
          <div style="height: 45px; padding-bottom: 50px; border-width: 0px 0px 2px 0px; border-style: solid; border-color: rgba(224, 221, 221, 0.8);">
            <table class="w3-right">
              <tr>
                <td>
                  <form name = "RUpdateBoard" method = "get">
                    <input type = "hidden" name ="board_number" value= "${riderBoardVo.board_number}"/>
                    <input type = "hidden" name = "menu_id" value= "${menu_id}"/>
                    <input type = "hidden" name=  "writer"  value = "${riderBoardVo.writer}"/>
                    <button type = "button" id = "update" onClick = "UpdateBoard_()" class="w3-button"
                      style="background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px;
                        border-radius: 10%"><b>수정</b></button>
                  </form>
                </td>
                <td>
                  <b>
                    <input type = "button" style="background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%" id = "delete" value= "삭제" onclick = "DeleteBoard()" class="w3-button"/>
                  </b>
                </td>
                <td>
                  <b>
                    <a href="/Board/riderList?menu_id=MENU_02&pageNum=${boardPager.getPageNum()+1}&contentNum=${(boardPager.getPageNum()+1)*10}" class="w3-button"
                       style="background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px;border-radius: 10%">목록으로
                    </a>
                  </b>
                </td>
                 <td>
                <b>
                <button type="button" class="w3-button" name="checkbtn" onclick="checkbuttonbtn()" style = "background-color: #ffffff; color: #212529; border-style: solid; border-color: #c4c9cf; border-width: 1px;border-radius: 10%">접수완료</button>
                </b>
                </td>
              </tr>
            </table>
          </div>
          <div style="margin-top: 3px;">
            <p class="w3-right">
              <button style="background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%" class="w3-button" onclick="myFunction('reply')" id="myBtn"><b>댓글</b></button>
            </p>
            <p class="w3-clear"></p>
            <div id="reply" style="display:none"></div>
            <div class="bg-light p-2">
              <div class="d-flex flex-row align-items-start">
                <textarea class="form-control ml-1 shadow-none textarea" type="textarea" id="replytext" placeholder="댓글을 작성하세요"></textarea>
              </div>
              <div class="mt-2 text-right">
                <button type="button" id="btnReply" style="background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%" class="btnReply w3-button">작성</button>
              </div>
            </div>
            <div id="ReplyPa" class="ReplyPa"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script>
document.getElementById("myBtn").click();

//댓글 누르면 댓글창이 나오는 함수
function myFunction(id) {
  var x = document.getElementById(id);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else {
    x.className = x.className.replace(" w3-show", "");
  }
}

$("#btnReply").click(function(){
  let cont  = $("#replytext").val();
  let board_number = "${riderBoardVo.board_number }";
  let menu_id = "${menu_id}";
  let writer = "${nickName}"
  let param = {"cont":cont, "board_number":board_number, "menu_id":menu_id, "writer":writer};
  $.ajax({
    type: "post",
    url: "/Board/RidreplyWrite",
    data: param,
    success: function(result){
      alert("댓글이 등록되었습니다");
      $("#replytext").val('');
      window.location.reload();
      replylist();
    }
  });
});

function replylist(list){
  $.ajax({
    type:"get",
    url: "/Board/RReplyList?board_number=${riderBoardVo.board_number}&menu_id=${menu_id}&pageNum=${map.pageNum}&contentNum=${map.contentNum}",
    success: function(resultList){
      let html = "";
      let RPager = "";
      let replyLen = resultList.length;
      let urlParams = new URL(location.href).searchParams;
      let nowPN = urlParams.get('pageNum');
      if (replyLen != 0){
        let end = parseInt(resultList[0].rend_page)
        let startP = parseInt("${replyPager.getStartPage()}");
        if (resultList.length >0){
          html += '<table>';
          if (replyLen >=10){
            replyLen = 10;
            for(var i = 0; i<resultList.length; i++){
              html += '<tbody style="border-bottom:1px solid #ccc!important; ">';
              html += '<tr>';
              html += '<td>';
              html += resultList[i].writer;
              html += '</td>';
              html +='<td>';
              html += resultList[i].indate;
              html +='</td>';
              html +='<td>';
              html +='<button type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" name = "FW" onclick="fileWatch('+ resultList[i].reply_number + ','+ i +')">사진 보기</button>';
              html +='<span name="picture' + [i] + '"></span>'
              html += '</td>';
              html +='<td>';
              html +='<button type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" name = "RRFU" onclick="RRFU('+ resultList[i].reply_number + ','+ i +')">사진 올리기</button>';
              html +='<span name="fileUpload' + [i] + '"></span>'
              html += '</td>';
              html +='<td>';
              html +='<button type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" name = "replyupdateBtn" onclick="updateReplyForm('+ resultList[i].reply_number + ',\'' + resultList[i].writer +'\')">수정</button>';
              html += '</td>';
              html += '<td>';
              html +='<button type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" name = "replydeleteBtn" onclick="deleteReply('+ resultList[i].reply_number + ',\'' + resultList[i].writer +'\',${replyPager.getEndPage()})">삭제</button>';
              html +='</td>'
              html += '<td>';
              html += '<button type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" name="checkbtnbtn" onclick="checkbutton()">접수하기</button>';
              html += '</td>';
              html += '<td>';
              html += '<button type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" name="checkbtn" onclick="checkdelitebtn()">접수취소</button>';
              html += '</td>';
              html += '<td>';
              html +=  '<input type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" onclick="sendSMS()" value="전송하기" />'
              html += '</td>';
              html += '</tr>';
              html += '<tr>';
              html += '<td id="R'+ resultList[i].reply_number +'">';
              html += resultList[i].cont;
              html += '</td>';
              html += '</tr>';
              html += '</tbody>';
            }
          }
          else{
            for(var i=0; i<replyLen; i++){
              html += '<tbody style="border-bottom:1px solid #ccc!important; ">';
              html += '<tr>';
              html += '<td>';
              html += '<input type="hidden" name="aa" value='+ resultList[i].reply_number + '></input>'
              html += resultList[i].writer;
              html += '</td>';
              html +='<td>';
              html += resultList[i].indate;
              html +='</td>';
              html +='<td>';
              html +='<button type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" name = "FW" onclick="fileWatch('+ resultList[i].reply_number + ','+ i +')">사진 보기</button>';
              html +='<span name="picture' + [i] + '"></span>'
              html += '</td>';
              html +='<td>';
              html +='<button type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" name = "RRFU" onclick="RRFU('+ resultList[i].reply_number + ','+ i +')">사진 올리기</button>';
              html +='<span name="fileUpload' + [i] + '"></span>'
              html += '</td>';
              html +='<td>';
              html +='<button type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" ame = "replyupdateBtn" onclick="updateReplyForm('+ resultList[i].reply_number + ',\'' + resultList[i].writer +'\')">수정</button>';
              html += '</td>';
              html += '<td>';
              html +='<button type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" name = "replydeleteBtn" onclick="deleteReply('+ resultList[i].reply_number + ',\'' + resultList[i].writer +'\',${replyPager.getEndPage()})">삭제</button>';
              html +='</td>'
              html += '<td>';
              html += '<button type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" name="checkbtnbtn" onclick="checkbutton()">접수하기</button>';
              html += '</td>';
              html += '<td>';
              html += '<button type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" name="checkbtn" onclick="checkdelitebtn()">접수취소</button>';
              html += '</td>';
              html += '<td>';
              html +=  '<input type="button" class="w3-button"  style= "background-color: #ffffff; color: #212529;border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%; padding-top: 3px;padding-bottom: 3px;" onclick="sendSMS()" value="전송하기" />'
              html += '</td>';
              html += '</tr>';
              html += '<tr>';
              html += '<td id="R'+ resultList[i].reply_number +'">';
              html += resultList[i].cont;
              html += '</td>';
              html += '</tr>';
              html += '</tbody>';
            }
          }
          html += '</table>';
        }
        $('#reply').html(html);
        RPager += '<c:if test="${replyPager.prev}">';
        RPager += '<a class="page-linkA" href="/Board/riderDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum=${replyPager.getStartPage()-1}&contentNum=${(replyPager.getStartPage()-1)*10}">< 이전</a>';
        RPager += '</c:if>';
        for (var j=startP; j<=end; j++){
          RPager += '<a class="page-linkA" href="/Board/riderDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum='+j+'&contentNum='+j*10+'">';
          if(nowPN == j){
            RPager += '<span class="PageNum">'+j+'</span></a>';
          }else{
            RPager += j+'</a>';
          }
        }
        if("${replyPager.next}"=="true"){
           RPager += '<a class="page-linkA" href="/Board/riderDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum=${replyPager.getEndPage()+1}&contentNum=${(replyPager.getEndPage()+1)*10}">다음 ></a>';
        }
        $('#ReplyPa').html(RPager);
      }
    }
  });
}

function UpdateBoard_(){
  if("${nickName}" != "${riderBoardVo.writer}"){
    alert("본인이 작성한 게시글만 수정 가능합니다");
  }
  else{
    $("#update").on("click", function(){
      let formobj = $("form[name='RUpdateBoard']");
      formobj.attr("action", "/Board/RBoardUpdateForm");
      formobj.submit();
    });
  }
}

function checkbutton(){
 let checkcheck = 1
 let ggg = {"board_check": checkcheck}
 let ans = confirm("접수하시겠습니까?");
 let a = "${riderBoardVo.writer}"
 let b = "${nickName}"

 if (ans === false){
   return false;
 }
 if("${riderBoardVo.board_check}" == 2){
   alert("이미 접수완료된 게시글입니다.")
   return false;
 }
 if(a != b){
   alert("본인이 작성한 게시글만 접수 가능합니다")
 }
 else{
   $.ajax({
     type:"get",
     url:"/Board/Rcheck?board_number=${riderBoardVo.board_number}&menu_id=${menu_id}",
     data: ggg,
     success:function(resultcheck){
       alert("접수완료")
       location.href='/Board/riderDetail?board_number=${riderBoardVo.board_number}&menu_id=MENU_02&pageNum=1&contentNum=10&board_check=1';
     }
   })
 }
}

function checkbuttonbtn(){
  let checkcheck = 2;
  let ggg = {"board_check": checkcheck}
  let ans = confirm("접수완료 시 취소가 불가능합니다.");
  let a = "${riderBoardVo.writer}"
  let b = "${nickName}"
  if(ans === true){
    if(a != b){
      alert("본인이 작성한 게시글만 접수 가능합니다")
    }
    else{
      $.ajax({
        type:"get",
        url:"/Board/Rcheck?board_number=${riderBoardVo.board_number}&menu_id=${menu_id}",
        data: ggg,
        success:function(resultcheck){
          alert("접수완료")
          location.href='/Board/riderDetail?board_number=${riderBoardVo.board_number}&menu_id=MENU_02&pageNum=1&contentNum=10&board_check=2';
        }
      })
    }
  }
}


// 접수취소버튼
function  checkdelitebtn(){
  let checkcheck = 0;
  let ggg = {"board_check": checkcheck}
  let ans = confirm("접수취소 하시겠습니까?");
  let c  = "${riderBoardVo.board_check}"
  let a = "${riderBoardVo.writer}"
  let b = "${nickName}"
  if("${riderBoardVo.board_check}" == 2 ){
  alert("접수완료가 되어 취소가 되지 않습니다.");
  return false;
  }
  if(ans === false){
    return false;
  }
  if("${riderBoardVo.board_check}" == 0 ){
    alert("접수가 되지 않아 취소할 수 없습니다")
    return false;
  }
  if(ans === true){
    if(a != b){
      alert("본인이 작성한 게시글만 접수 가능합니다")
    }
    else{
      $.ajax({
        type:"get",
        url:"/Board/Rcheck?board_number=${riderBoardVo.board_number}&menu_id=${menu_id}",
        data: ggg,
        success:function(resultcheck){
          alert("접수취소 되었습니다")
          location.href='/Board/riderDetail?board_number=${riderBoardVo.board_number}&menu_id=MENU_02&pageNum=1&contentNum=10&board_check=1';
        }
      })
    }
  }
}

function fileWatch(reply_number, i){
console.log(reply_number);
console.log(i);

let ggg={"rider_reply_number" : reply_number};

$.ajax({
    type:"get",
    url:"/RiderWatch",
    data: ggg,
    success:function(resultcheck){
    console.log(resultcheck);

    if(resultcheck == null){
        return false;
    } else{
        html = "";
        html += '<img src="/img/rider/reply/'+reply_number +'/' + resultcheck+'" style="width:100px; height:100px;"></img>'

        $('[name=picture'+i+']').html(html)


    }

    }
                  })
}
</script>
</body>
</html>