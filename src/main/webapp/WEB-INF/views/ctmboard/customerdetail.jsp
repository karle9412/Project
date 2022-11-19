<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>Banana Quick</title>
<meta charset="UTF-8">

<!-- css -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Oswald">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open Sans">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
</style>
<!-- css 불러오기 끝 -->

  <script>
//댓글 리스트
$(document).ready(function(){ replylist(); });

//게시글 삭제
function DeleteBoard(e){
    let ans = confirm("삭제하시겠습니까?");
    if(ans){
        if("${nickName}" != "${boardVo.writer}"){
            alert("본인이 작성한 게시글만 삭제 가능합니다");
        }
        else{
            $.ajax({
                type:"get",
                url:"/Board/CBoardDelete?board_number=${boardVo.board_number}&menu_id=${menu_id}",
                success:function(result){
                    alert("삭제되었습니다");
                    location.href='/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10';
                }
            });
        }
    }
}

//댓글 수정하는 폼 불러오기
function updateReplyForm(reply_number,writer){
    const writer_check =confirm("수정하시겠습니까?");
        if( writer_check ===true){
            if("${nickName}" != writer){
                alert("본인이 작성한 댓글만 수정 가능합니다.");
            }
            else{
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
                $("[name=replyupdateBtn]").css("display", "none");
                $("[name=replydeleteBtn]").css("display", "none");
        }
    }
}

//댓글 수정
function updateReply(reply_number, writer){
    let reply_content = $("#replycontent").val();
    let replynumber = reply_number;
    let reply_writer = writer;
    let updateurl = "/Board/CtmreplyUpdate?reply_number=";
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

//댓글 삭제
function deleteReply(reply_number,writer,endPage){
    let deleturl = "/Board/ReplyDelete?reply_number=" + reply_number + "&endPage=" + endPage +"&board_number=${boardVo.board_number}"
    let ans = confirm("삭제하시겠습니까?");
    console.log(ans);
    if("${nickName}" != writer){
        alert("본인이 작성한 댓글만 삭제 가능합니다");
    }
    else{
        if(ans === true){
            $.ajax({
                type: "POST",
                url: deleturl,
                success: function(deleteresult){
                    alert("댓글이 삭제되었습니다");
                    replylist();
                }
            });
        }
    }
}
</script>
</head>

<!-- html 시작 -->
<body class="w3-light-grey">
<header class="w3-container w3-center w3-padding-48 w3-white">
    <h1 class="w3-xxxlarge"><b>Banana Quick</b></h1>
    <h6><span class="w3-tag">delivery's world</span></h6>
</header>

<div class="w3-content" style="max-width:1600px">
    <div class="w3-row w3-padding w3-border">
        <div>
            <div class="w3-container w3-white w3-margin w3-padding-large">
                <div class="w3-center">
                    <h3>${ boardVo.title }</h3>
                    <h5>작성자: ${ boardVo.writer } &nbsp; 작성일: ${ boardVo.indate }</h5>
                    <h5>출발지: ${boardVo.c_start} &nbsp; 목적지: ${boardVo.c_end} &nbsp; 도착일: ${boardVo.delivery_indate}</h5>
                    <h5>비용: ${boardVo.money} &nbsp; 수화물: ${boardVo.luggage} &nbsp; 접수여부:
                        <c:if test="${boardVo.board_check == 0}"> 접수대기 </c:if>
                        <c:if test="${boardVo.board_check == 1}"> 접수중 </c:if>
                        <c:if test="${boardVo.board_check == 2}"> 접수완료 </c:if></h5>
                </div>
                <div class="w3-justify" style="border-width: 2px 0px 0px 0px; border-style: solid; border-color: rgba(224, 221, 221, 0.8);">
                    <p style="margin-top: 30px; margin-left: 15px; ">${ boardVo.cont }</p>
                    <div style="height: 45px; padding-bottom: 50px; border-width: 0px 0px 2px 0px; border-style: solid; border-color: rgba(224, 221, 221, 0.8);">
                        <table class="w3-right">
                            <tr>
                                <td>
                                    <form name = "UpdateBoard" method = "get">
                                        <input type = "hidden" name ="board_number" value= "${boardVo.board_number}"/>
                                        <input type = "hidden" name = "menu_id" value= "${menu_id}"/>
                                        <input type = "hidden" name=  "writer"  value = "${boardVo.writer}"/>
                                        <a href= "/Board/CBoardUpdateForm?board_number=${boardVo.board_number}&menu_id=${menu_id}"
                                         class="w3-button"  id = "update" onclick="UpdateBoard_()"
                                         style="background-color: #ffffff; color: #212529; border-style: solid; border-color: #c4c9cf; border-width: 1px; border-radius: 10%">
                                         <b>수정</b></button>
                                    </form>
                                </td>
                                <td>
                                    <b><input type = "button" style="background-color: #ffffff; color: #212529;border-style: solid;
                                     border-color: #c4c9cf; border-width: 1px; border-radius: 10%"
                                      id = "delete" value= "삭제" onclick = "DeleteBoard()" class="w3-button"/></b>
                                </td>
                                <td>
                                    <b><a href="/Board/customerList?menu_id=MENU_01&pageNum=${boardPager.getPageNum()+1}&contentNum=${(boardPager.getPageNum()+1)*10}"
                                            class="w3-button" style="background-color: #ffffff;
                                             color: #212529;border-style: solid; border-color: #c4c9cf;
                                              border-width: 1px;border-radius: 10%">목록으로</a></b>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div style="margin-top: 3px;">
                        <p class="w3-right"><button style="background-color: #ffffff; color: #212529;border-style: solid;
                         border-color: #c4c9cf; border-width: 1px; border-radius: 10%"
                          class="w3-button" onclick="myFunction('demo')" id="myBtn"><b>댓글</b> </button></p>
                        <p class="w3-clear"></p>
                        <div class="w3-row w3-margin-bottom" id="demo" style="display:none">
                        </div>
                        <div id="ReplyPa"></div>
                        <div class="bg-light p-2">
                            <div class="d-flex flex-row align-items-start">
                                <textarea class="form-control ml-1 shadow-none textarea" type="textarea" id="replytext" placeholder="댓글을 작성하세요"></textarea>
                            </div>
                            <div class="mt-2 text-right">
                                <button type="button" id="btnReply" style="background-color: #ffffff; color: #212529;border-style: solid;
                                 border-color: #c4c9cf; border-width: 1px; border-radius: 10%" class="btnReply w3-button">작성</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
// Toggle between hiding and showing blog replies/comments
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
 let board_number = "${boardVo.board_number }";
 let menu_id = "${menu_id}";
 let writer = "${nickName}"
 let param = {"cont":cont, "board_number":board_number, "menu_id":menu_id, "writer":writer};

 $.ajax({
  type: "post",
  url: "/Board/CtmreplyWrite",
  data: param,
  success: function(result){
   alert("댓글이 등록되었습니다");
    $("#replytext").val('');
     replylist();
   },
   error: function(xhr){
    if($("#replytext").val() == ''){
      alert('댓글을 입력해주세요.')
     }

  }

  });

 });

function replylist(){
      $.ajax({
        type:"GET",
        url: "/Board/CReplyList?board_number=${boardVo.board_number}&menu_id=${menu_id}&pageNum=${map.pageNum}&contentNum=${map.contentNum}",
        success: function(resultList){
          let html = "";
          let pager = "";
          let RPager = "";
          if (resultList.length >0){
            let end = parseInt(resultList[0].rend_page)
            let startP = parseInt("${replyPager.getStartPage()}");
                      html+= '<table>';
                      for(var i=0; i<resultList.length; i++){
                        html+= '<tr>';
                        html+= '<td>';
                        html+= resultList[i].writer;
                        html+= '</td>';
                        html+= '</tr>';
                        html+= '<tr>';
                        html+= '<td id="R'+ resultList[i].reply_number +'">';
                        html+= resultList[i].cont;
                        html+= '</td>';
                        html+= '</tr>';
                        html+= '<tr>';
                        html+= '<td>';
                        html+= resultList[i].indate;
                        html+= '</td>';
                        html+= '<td>';
                        html+= '<button type="button" class="btn" name = "replyupdateBtn" onclick="updateReplyForm('+ resultList[i].reply_number + ',\'' + resultList[i].writer +'\')">수정</button>';
                        html+= '</td>';
                        html+= '<td>';
                        html+= '<button type="button" class="btndelte" name="replydeleteBtn"';
                        html+= 'onclick="deleteReply('+ resultList[i].reply_number+',\''+ resultList[i].writer +'\',${replyPager.getEndPage()})">삭제</button>';
                        html+= '</td>';
                        html+= '<td>';
                        html+= '<button type="button" class="checkbtn" name="checkbtnbtn" onclick="checkbutton()">접수하기</button>';
                        html+= '</td>';
                        html+= '<td>';
                        html+= '<button type="button" class="checkbtnbtn" name="checkbtn" onclick="checkbuttonbtn()">접수완료</button>';
                        html+= '</td>';
                        html+= '<td>';
                        html+= '<button type="button" class="checkbtnbtn" name="checkbtn" onclick="checkdelitebtn()">접수취소</button>';
                        html+= '</td>';
                        html+= '<td>';
                        html+=  '<input type="button" onclick="sendSMS()" value="전송하기" />'
                        html+= '</td>';
                        html+= '</tr>';
                      }
                      $('#demo').html(html);
                      RPager += '</table>';
                      RPager += '<table id="pager">';
                      RPager += '<tr>';
                      RPager += '<td>';
                      RPager += '<c:if test="${replyPager.prev}">';
                      RPager += '<a href="/Board/CustomerDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum=${replyPager.getStartPage()-1}&contentNum=${(replyPager.getStartPage()-1)*10}">< 이전</a>';
                      RPager += '</c:if>';
                      RPager += '</td>';
                      RPager += '<td>';
                      for (var j=startP; j<=end; j++){
                        RPager += '<a href="/Board/CustomerDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum='+j+'&contentNum='+j*10+'">'+j+'</a>';
                      }
                      RPager += '</td>';
                      RPager += '<td>';
                      if("${replyPager.next}"=="true"){
                        RPager += '<a href="/Board/CustomerDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum=${replyPager.getEndPage()+1}&contentNum=${(replyPager.getEndPage()+1)*10}">다음 ></a>';
                      }
                      RPager += '</td>';
                      RPager += '</tr>';
                      RPager += '</table>';
                      $('#ReplyPa').html(RPager);

          }else{ let end ="";

          let startP = parseInt("${replyPager.getStartPage()}");
          html+= '<table>';
          for(var i=0; i<resultList.length; i++){
            html+= '<tr>';
            html+= '<td>';
            html+= resultList[i].writer;
            html+= '</td>';
            html+= '</tr>';
            html+= '<tr>';
            html+= '<td id="R'+ resultList[i].reply_number +'">';
            html+= resultList[i].cont;
            html+= '</td>';
            html+= '</tr>';
            html+= '<tr>';
            html+= '<td>';
            html+= resultList[i].indate;
            html+= '</td>';
            html+= '<td>';
            html+= '<button type="button" class="btn" name = "replyupdateBtn" onclick="updateReplyForm('+ resultList[i].reply_number + ',\'' + resultList[i].writer +'\')">수정</button>';
            html+= '</td>';
            html+= '<td>';
            html+= '<button type="button" class="btndelte" name="replydeleteBtn"';
            html+= 'onclick="deleteReply('+ resultList[i].reply_number+',\''+ resultList[i].writer +'\',${replyPager.getEndPage()})">삭제</button>';
            html+= '</td>';
            html+= '<td>';
            html+= '<button type="button" class="checkbtn" name="checkbtnbtn" onclick="checkbutton()">접수완료</button>';
            html+= '</td>';
            html+= '</tr>';
          }
          $('#Replyli').html(html);
          RPager += '</table>';
          RPager += '<table id="pager">';
          RPager += '<tr>';
          RPager += '<td>';
          RPager += '<c:if test="${replyPager.prev}">';
          RPager += '<a href="/Board/CustomerDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum=${replyPager.getStartPage()-1}&contentNum=${(replyPager.getStartPage()-1)*10}">< 이전</a>';
          RPager += '</c:if>';
          RPager += '</td>';
          RPager += '<td>';
          for (var j=startP; j<=end; j++){
            RPager += '<a href="/Board/CustomerDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum='+j+'&contentNum='+j*10+'">'+j+'</a>';
          }
          RPager += '</td>';
          RPager += '<td>';
          if("${replyPager.next}"=="true"){
            RPager += '<a href="/Board/CustomerDetail?board_number=${replyPager.board_number}&menu_id=${menu_id}&pageNum=${replyPager.getEndPage()+1}&contentNum=${(replyPager.getEndPage()+1)*10}">다음 ></a>';
          }
          RPager += '</td>';
          RPager += '</tr>';
          RPager += '</table>';
          $('#ReplyPa').html(RPager);
        }
      }
      });
    }

function UpdateBoard_(e){
      if("${nickName}" != "${boardVo.writer}"){
        alert("본인이 작성한 게시글만 수정 가능합니다");
        return false;
      }
      else{
        $("#update").on("click", function(){
          let formobj = $("form[name='UpdateBoard']");
          formobj.attr("action", "/Board/CBoardUpdateForm");
          formobj.submit();
        });
      }
    }


    function checkbutton(){
      let checkcheck = 1
      let ggg = {"board_check": checkcheck}
      let ans = confirm("접수하시겠습니까?");
      let c  = "${boardVo.board_check}"
      let a = "${boardVo.writer}"
      let b = "${nickName}"
      if(ans === false){
      return false;
      }

      if(c == 1){
        alert("이미 접수 되었습니다.");
        return false;
      }


          if("${boardVo.board_check}" == 2){
            alert("이미 접수된 댓글입니다.")
            return false;
            }
      if(a != b){
      alert("본인이 작성한 게시글만 접수 가능합니다")
      }
      else{
        $.ajax({
        type:"get",
        url:"/Board/check?board_number=${boardVo.board_number}&menu_id=${menu_id}",
        data: ggg,
        success:function(resultcheck){
        alert("접수완료")
        location.href='/Board/CustomerDetail?board_number=${boardVo.board_number}&menu_id=MENU_01&pageNum=1&contentNum=10&board_check=1';
        }
        })
      }
    }

function checkbuttonbtn(){
     let checkcheck = 2;
         let ggg = {"board_check": checkcheck}
         let ans = confirm("접수완료 시 취소가 불가능합니다.");
         let c  = "${boardVo.board_check}"
         let a = "${boardVo.writer}"
         let b = "${nickName}"

         if(ans === false){
         return false;
         }

         if(c == 2 ){
         alert("이미 접수가 끝난 게시글입니다.")
         return false;
         }

         if(ans === true){
         if(a != b){
         alert("본인이 작성한 게시글만 접수 가능합니다")
         }
         else{
           $.ajax({
           type:"get",
           url:"/Board/check?board_number=${boardVo.board_number}&menu_id=${menu_id}",
           data: ggg,
           success:function(resultcheck){
           alert("접수완료")
           location.href='/Board/CustomerDetail?board_number=${boardVo.board_number}&menu_id=MENU_01&pageNum=1&contentNum=10&board_check=2';
           }
           })
           }
           }

       }

function  checkdelitebtn(){
 let checkcheck = 0;
         let ggg = {"board_check": checkcheck}
         let ans = confirm("접수취소 하시겠습니까?");
         let c  = "${boardVo.board_check}"
         let a = "${boardVo.writer}"
         let b = "${nickName}"
         if(ans === false){
         return false;
         }

         if("${boardVo.board_check}" == 0 ){
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
           url:"/Board/check?board_number=${boardVo.board_number}&menu_id=${menu_id}",
           data: ggg,
           success:function(resultcheck){
           alert("접수취소 되었습니다")
           location.href='/Board/CustomerDetail?board_number=${boardVo.board_number}&menu_id=MENU_01&pageNum=1&contentNum=10&board_check=1';
           }
           })
           }
           }

       }

function sendSMS(){
    let ans = confirm("문자 전송 하시겠습니까?");

 let ab = "0104819553" // 내번호
 let ac = "테스트 입니다" // 텍스트
 let param = {"from":ab, "text":ac}
 if(ans === true){
 $.ajax({
 type:"post",
 url:"/Board/SMS",
 data:param,
 success:function(result){
 alert("성공!")
 }
 })
 }else{
 return false;}
  }

</script>

</body>
</html>
