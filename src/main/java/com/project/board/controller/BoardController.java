package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.*;
import com.project.menus.service.MenuService;
import com.project.menus.vo.MenuVo;
import com.project.reply.service.ReplyService;
import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;
import com.project.user.vo.UserVo;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class BoardController {


    @Autowired
    BoardService boardService;
    @Autowired
    MenuService menuService;


    @Autowired
    ReplyService replyService;


    BoardPager boardPager = new BoardPager();
    ReplyPager replyPager = new ReplyPager();
    // 해주세요 게시판 글 전체 조회

    @RequestMapping("/Board/customerList")
    public String CustomerBoardList(Model model, @RequestParam HashMap<String,Object> map) {
        List<MenuVo> menuList = this.menuService.getMenuList();

        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        List<BoardVo> customerList = null;

        this.boardPager.setTotalCount(this.boardService.customerCount()); // board 전체 게시글 개수를 지정
        this.boardPager.setPageNum(cPageNum -1); // 현제 페이지를 페이지 객체에 지정한다 -1을 해야 쿼리에서 사용가능
        this.boardPager.setContentNum(cContentNum); // 한 페이지에 몇개씩 게시글을 보여줄지 정함
        this.boardPager.setCurrentBlock(cPageNum); // 현재 페이지 블록이 몇번인지 현재 페이지번호를 통해 지정
        this.boardPager.setLastBlock(); // 마지막 블록 번호를 전체 게시글 수를 통해서 정함
        this.boardPager.prevNext(cPageNum); // 현재 페이지 번호로 화살표를 나타낼지 정함
        this.boardPager.setStartPage(this.boardPager.getCurrentBlock()); // 시작 페이지를 페이지 블록번호로 지정
        this.boardPager.setEndPage(); // 마지막 페이지

        map.put("pageNum", this.boardPager.getPageNum());
        map.put("contentNum", this.boardPager.getContentNum());

        if (this.boardPager.getPageNum() == 0) {
            customerList = this.boardService.customerList(map);
        } else if (this.boardPager.getPageNum() != 0) {
            map.put("pageNum", this.boardPager.getPageNum() * 10 + 1);
            customerList = this.boardService.customerList(map);
        }

        model.addAttribute("customerList", customerList);
        model.addAttribute("boardPager", this.boardPager);
        model.addAttribute("menuList", menuList);

        return "ctmboard/customerList";

    }
    // 할게여 게시판 글 전체 조회

    @RequestMapping("/Board/riderList")
    public String RiderBoardList(Model model, @RequestParam HashMap<String,Object> map){

        List<MenuVo>  menuList  = this.menuService.getMenuList();

        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        List<BoardVo> riderList = null;

        this.boardPager.setTotalCount(this.boardService.riderCount()); // board 전체 게시글 개수를 지정
        this.boardPager.setPageNum(cPageNum - 1); // 현제 페이지를 페이지 객체에 지정한다 -1을 해야 쿼리에서 사용가능
        this.boardPager.setContentNum(cContentNum); // 한 페이지에 몇개씩 게시글을 보여줄지 정함
        this.boardPager.setCurrentBlock(cPageNum); // 현재 페이지 블록이 몇번인지 현재 페이지번호를 통해 지정
        this.boardPager.setLastBlock(); // 마지막 블록 번호를 전체 게시글 수를 통해서 정함
        this.boardPager.prevNext(cPageNum); // 현재 페이지 번호로 화살표를 나타낼지 정함
        this.boardPager.setStartPage(this.boardPager.getCurrentBlock()); // 시작 페이지를 페이지 블록번호로 지정
        this.boardPager.setEndPage(); // 마지막 페이지

        map.put("pageNum", this.boardPager.getPageNum());
        map.put("contentNum", this.boardPager.getContentNum());

        if (this.boardPager.getPageNum() == 0) {
            riderList = this.boardService.riderList(map);
        } else if (this.boardPager.getPageNum() != 0) {
            map.put("pageNum", this.boardPager.getPageNum() * 10 + 1);
            riderList = this.boardService.riderList(map);
        }


        model.addAttribute("riderList", riderList);
        model.addAttribute("boardPager", this.boardPager);
        model.addAttribute("menuList", menuList);

        return "riderboard/riderList";
    }

    // 후기 게시판 글 전체 조회
    @RequestMapping("/Board/reviewList")
    public String reviewList(Model model, @RequestParam HashMap<String,Object> map){

        List<MenuVo>  menuList  = this.menuService.getMenuList();
        List<BoardVo> reviewList = null;

        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        this.boardPager.setTotalCount(this.boardService.reviewCount()); // board 전체 게시글 개수를 지정
        this.boardPager.setPageNum(cPageNum - 1); // 현제 페이지를 페이지 객체에 지정한다 -1을 해야 쿼리에서 사용가능
        this.boardPager.setContentNum(cContentNum); // 한 페이지에 몇개씩 게시글을 보여줄지 정함
        this.boardPager.setCurrentBlock(cPageNum); // 현재 페이지 블록이 몇번인지 현재 페이지번호를 통해 지정
        this.boardPager.setLastBlock(); // 마지막 블록 번호를 전체 게시글 수를 통해서 정함
        this.boardPager.prevNext(cPageNum); // 현재 페이지 번호로 화살표를 나타낼지 정함
        this.boardPager.setStartPage(this.boardPager.getCurrentBlock()); // 시작 페이지를 페이지 블록번호로 지정
        this.boardPager.setEndPage(); // 마지막 페이지

        map.put("pageNum", this.boardPager.getPageNum());
        map.put("contentNum", this.boardPager.getContentNum());

        if (this.boardPager.getPageNum() == 0) {
            reviewList = this.boardService.reviewList(map);
        } else if (this.boardPager.getPageNum() != 0) {
            map.put("pageNum", this.boardPager.getPageNum() * 10 + 1);
            reviewList = this.boardService.reviewList(map);
        }

        model.addAttribute("reviewList", reviewList);
        model.addAttribute("menuList", menuList);
        model.addAttribute("boardPager", this.boardPager);

        return "reviewboard/reviewList";
    }

    //해주세요 게시판 글 작성 페이지

    @RequestMapping("/Board/CBoardWriteForm")
    public String CBoardwriteform(BoardVo boardVo, Model model, HttpSession httpSession, @RequestParam HashMap<String, Object> map) {
        String menu_id = boardVo.getMenu_id();
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();







        model.addAttribute("menu_id", menu_id);
        model.addAttribute("cPageNum", cPageNum);
        model.addAttribute("cContentNum",cContentNum);
        model.addAttribute("writer", nickName);

        return "ctmboard/CBoardwrite";
    }

    //해주세요 게시판 글 작성

    @RequestMapping("/Board/CBoardWrite")
    public String write(BoardVo boardVo, BoardPager boardPager, @RequestParam HashMap<String,Object> map) {
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));


        this.boardService.C_insertboard(boardVo);



        return "redirect:/Board/customerList?menu_id=" + boardVo.getMenu_id() + "&pageNum=" + (cPageNum)+ "&contentNum=" + cContentNum;
    }


    //할게요 게시판 글 작성 페이지
    @RequestMapping("/Board/RBoardWriteForm")
    public String RBoardwriteform(RiderBoardVo riderboardVo, Model model,HttpSession httpSession,@RequestParam HashMap<String,Object> map) {
        String menu_id = riderboardVo.getMenu_id();
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));
        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();

        model.addAttribute("cPageNum", cPageNum);
        model.addAttribute("cContentNum",cContentNum);
        model.addAttribute("menu_id", menu_id);
        model.addAttribute("writer",nickName);
        return "riderboard/RBoardwrite";
    }


    //할게요 글 작성
    @RequestMapping("/Board/RBoardWrite")
    public String RBoardwrite(RiderBoardVo riderboardVo,@RequestParam HashMap<String,Object> map) {
        this.boardService.R_insertboard(riderboardVo);
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        return "redirect:/Board/riderList?menu_id=" + riderboardVo.getMenu_id() + "&pageNum=" + cPageNum + "&contentNum=" + cContentNum;
    }


    //리뷰게시판 글 작성 페이지
    @RequestMapping("/Board/RVBoardWriteForm")
    public String RvBoardwriteform(ReviewVo reviewVo, Model model, HttpSession httpSession,@RequestParam HashMap<String, Object> map) {
        String menu_id = reviewVo.getMenu_id();
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));
        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();


        model.addAttribute("menu_id", menu_id);
        model.addAttribute("writer", nickName);
        model.addAttribute("cPageNum", cPageNum);
        model.addAttribute("cContentNum",cContentNum);
        return "reviewboard/RVBoardwrite";
    }


    //리뷰게시판 글 작성
    @RequestMapping("/Board/RVBoardWrite")
    public String RvVBoardwrite(ReviewVo reviewVo,@RequestParam HashMap<String,Object> map) {

        this.boardService.RV_insertboard(reviewVo);
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));


        return "redirect:/Board/reviewList?menu_id=" + reviewVo.getMenu_id() + "&pageNum=" + cPageNum + "&contentNum=" + cContentNum;
    }


    // 해주세요 게시글 상세조회
    @RequestMapping("/Board/CustomerDetail")
    public String Customerdetail(@RequestParam HashMap<String, Object> map, Model model, MenuVo menuVo,ReplyVo replyVo,HttpSession httpSession) {
        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();
        String menu_id = (String) map.get("menu_id");
        BoardVo boardVo = this.boardService.DetailCustomer(map);

        model.addAttribute("boardVo", boardVo);
        model.addAttribute("menu_id", menu_id);
        model.addAttribute("boardPager", this.boardPager);

        ReplyPager replyPager = new ReplyPager();
        model.addAttribute("nickName",nickName);

        int rPageNum = Integer.parseInt((String) map.get("pageNum"));
        int rContentNum = Integer.parseInt((String) map.get("contentNum"));
        int Board_number = Integer.parseInt((String) map.get("board_number"));

        replyPager.setBoard_number(Board_number);
        replyPager.setTotalCount(this.replyService.CReplyCount(Board_number)); // board 전체 댓글 개수를 지정
        replyPager.setPageNum(rPageNum-1); // 현재 페이지를 페이지 객체에 지정한다 -1을 해야 쿼리에서 사용가능
        replyPager.setContentNum(rContentNum); // 한 페이지에 몇개씩 댓글을 보여줄지 정함
        replyPager.setCurrentBlock(rPageNum); // 현재 페이지 블록이 몇번인지 현재 페이지번호를 통해 지정
        replyPager.setLastBlock(); // 마지막 블록 번호를 전체 댓글 수를 통해서 정함
        replyPager.prevNext(rPageNum); // 현재 페이지 번호로 화살표를 나타낼지 정함
        replyPager.setStartPage(replyPager.getCurrentBlock()); // 시작 페이지를 페이지 블록번호로 지정
        replyPager.setEndPage(); //
        // 마지막 페이지
        map.put("pageNum", replyPager.getPageNum());
        map.put("contentNum", replyPager.getContentNum());

        model.addAttribute("map",map);
        model.addAttribute("replyPager",replyPager);




        return "ctmboard/customerdetail";
    }
    
    
    //해주세요 댓글 조회
    @RequestMapping("/Board/CReplyList")
    @ResponseBody
    public List<ReplyPager> replylist(@RequestParam(required=false) HashMap<String,Object> map, Model model){

        List<ReplyPager> replylist = null;

        int rPageNum = Integer.parseInt((String) map.get("pageNum"));
        int rContentNum = Integer.parseInt((String) map.get("contentNum"));
        int Board_number = Integer.parseInt((String) map.get("board_number"));

        this.replyPager.setBoard_number(Board_number);
        this.replyPager.setTotalCount(this.replyService.CReplyCount(Board_number)); // board 전체 댓글 개수를 지정
        this.replyPager.setPageNum(rPageNum); // 현제 페이지를 페이지 객체에 지정한다 -1을 해야 쿼리에서 사용가능
        this.replyPager.setContentNum(rContentNum); // 한 페이지에 몇개씩 댓글을 보여줄지 정함
        this.replyPager.setCurrentBlock(rPageNum+1); // 현재 페이지 블록이 몇번인지 현재 페이지번호를 통해 지정
        this.replyPager.setLastBlock(); // 마지막 블록 번호를 전체 댓글 수를 통해서 정함
        this.replyPager.prevNext(rPageNum); // 현재 페이지 번호로 화살표를 나타낼지 정함
        this.replyPager.setStartPage(this.replyPager.getCurrentBlock()); // 시작 페이지를 페이지 블록번호로 지정
        this.replyPager.setEndPage();
        this.replyPager.setRend_page();

        map.put("pageNum", this.replyPager.getPageNum());
        map.put("contentNum", this.replyPager.getContentNum());
        map.put("endPage", this.replyPager.getEndPage());

        if (this.replyPager.getPageNum() == 0) {
            this.replyService.updateEndPage(map);
            replylist = this.replyService.getReplylist(map);
        } else if (this.replyPager.getPageNum() != 0) {
            map.put("pageNum", this.replyPager.getPageNum()*10+1);
            this.replyService.updateEndPage(map);
            replylist = this.replyService.getReplylist(map);
        }


        return replylist;
    }

    @RequestMapping("/Board/ReplyPager")
    @ResponseBody
    public HashMap<String, Object> ReplyPager(Model model, @RequestParam HashMap<String,Object> map){
        HashMap<String, Object> replyVo = map;
        model.addAttribute("map",map);
        return replyVo;
    }


    // 할게요 게시글 상세조회

    @RequestMapping("/Board/riderDetail")
    public String riderdetail(@RequestParam HashMap<String, Object> map, Model model,HttpSession httpSession) {
        String menu_id = (String) map.get("menu_id");
        RiderBoardVo riderBoardVo = this.boardService.DetailRider(map);
        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();



        model.addAttribute("riderBoardVo", riderBoardVo);
        model.addAttribute("menu_id", menu_id);
        model.addAttribute("nickName", nickName);

        return "riderboard/riderdetail";
    }

    //할게요 댓글 조회
    @RequestMapping("/Board/RReplyList")
    @ResponseBody
    public List<RiderReplyVo> Rreplylist(RiderBoardVo riderBoardVo){
        List<RiderReplyVo> replylist = this.replyService.getRiderReplylist(riderBoardVo.getBoard_number());
        return replylist;
    }

    // 후기 게시글 상세조회

    @RequestMapping("/Board/ReviewDetail")
    public String reviewdetail(@RequestParam HashMap<String, Object> map, Model model,HttpSession httpSession) {
        String menu_id = (String) map.get("menu_id");
        ReviewVo reviewBoardVo = this.boardService.DetailReview(map);
        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();


        model.addAttribute("reviewBoardVo", reviewBoardVo);
        model.addAttribute("menu_id", menu_id);
        model.addAttribute("nickName", nickName);

        return "reviewboard/reviewdetail";

    }


    //해주세요 게시글 수정 페이지
    @RequestMapping("/Board/CBoardUpdateForm")
    public String updateform(@RequestParam HashMap<String, Object> map, Model model, HttpSession httpSession) {

        BoardVo boardVo = this.boardService.DetailCustomer(map);
        String menu_id = (String) map.get("menu_id");
        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();


        if(!boardVo.getWriter().equals(nickName)){
            return "redirect:/Board/CustomerDetail?board_number="+ boardVo.getBoard_number() + "&menu_id=MENU_01&pageNum=1&contentNum=10&board_check=0";
        }


        model.addAttribute("boardVo", boardVo);
        model.addAttribute("menu_id", menu_id);


        return "ctmboard/CBoardupdate";
    }

    //해주세요 게시글 수정
    @RequestMapping("/Board/CBoardUpdate")
    public String update(@RequestParam HashMap<String, Object> map, Model model, BoardVo boardVo) {
        String menu_id = (String) map.get("menu_id");
        this.boardService.CBoardUpdate(map);

        return "redirect:/Board/CustomerDetail?board_number=" + boardVo.getBoard_number() + "&menu_id=" + menu_id;

    }

    //할게요 게시글 수정 페이지

    @RequestMapping("/Board/RBoardUpdateForm")
    public String RUpdateForm(@RequestParam HashMap<String, Object> map, Model model) {
        RiderBoardVo riderBoardVo = this.boardService.DetailRider(map);
        String menu_id = (String) map.get("menu_id");

        model.addAttribute("riderBoardVo", riderBoardVo);
        model.addAttribute("menu_id", menu_id);

        return "riderboard/RBoardUpdate";
    }

    //할게요 게시글 수정
    @RequestMapping("/Board/RBoardUpdate")
    public String RBoardUpdate(@RequestParam HashMap<String, Object> map, Model model, RiderBoardVo riderBoardVo) {
        String menu_id = (String) map.get("menu_id");
        this.boardService.RBoardUpdate(map);

        return "redirect:/Board/riderDetail?board_number=" + riderBoardVo.getBoard_number() + "&menu_id=" + menu_id;


    }

    //후기 게시판 게시글 수정 페이지

    @RequestMapping("/Board/RVUpdateForm")
    public String RVUpdateForm(@RequestParam HashMap<String, Object> map, Model model) {
        ReviewVo reviewVo = this.boardService.DetailReview(map);

        String menu_id = (String) map.get("menu_id");

        model.addAttribute("reviewVo", reviewVo);
        model.addAttribute("menu_id", menu_id);

        return "reviewboard/RVBoardUpdate";

    }

    //후기 게시판 게시글 수정

    @RequestMapping("/Board/RVBoardUpdate")
    public String RVUpdate(@RequestParam HashMap<String, Object> map, Model model, ReviewVo reviewVo) {
        String menu_id = (String) map.get("menu_id");
        this.boardService.RVBoardUpdate(map);

        return "redirect:/Board/ReviewDetail?board_number=" + reviewVo.getBoard_number() + "&menu_id=" + menu_id;

    }

    //해주세요 게시판 삭제

    @RequestMapping("/Board/CBoardDelete")
    @ResponseBody

    public String CDelete(@RequestParam HashMap<String, Object> map, BoardVo boardVo) {
        this.boardService.CBOardDelete(map);
        String menu_id = (String) map.get("menu_id");

        return "redirect:/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10";


    }

    //할게요 게시판 삭제

    @RequestMapping("/Board/RBoardDelete")
    public String RDelete(@RequestParam HashMap<String, Object> map, RiderBoardVo riderBoardVo) {
        this.boardService.RBoardDelete(map);
        String menu_id = (String) map.get("menu_id");

        return "redirect:/Board/riderList?menu_id=MENU_02&pageNum=1&contentNum=10";

    }

    //후기 게시판 삭제

    @RequestMapping("/Board/RVBoardDelete")
    public String RVDelete(@RequestParam HashMap<String, Object> map, ReviewVo reviewVo) {
        this.boardService.RVBoardDelete(map);
        String menu_id = (String) map.get("menu_id");

        return "redirect:/Board/reviewList?menu_id=MENU_03&pageNum=1&contentNum=10";
    }

    // 해주세요 댓글 작성
    @RequestMapping("/Board/CtmreplyWrite")
    @ResponseBody
    public void ctm_replyWrite(ReplyVo replyVo, BoardVo boardVo) {
        this.replyService.writeReply(replyVo);
    }

    //할게요 댓글 작성
    @RequestMapping("/Board/RidreplyWrite")
    @ResponseBody
    public void rider_replyWrite(RiderReplyVo riderReplyVo) {
        this.replyService.RiderwriteReply(riderReplyVo);
    }

    //해주세요 게시판 댓글 수정
    @RequestMapping("/Board/CtmreplyUpdate")
    @ResponseBody
    public void ctm_replyUpdate(@RequestParam HashMap<String, Object> map){
        this.replyService.UpdateReply(map);

    };

    //할게요 게시판 댓글 수정
    @RequestMapping("/Board/R_replyUpdate")
    @ResponseBody
    public void r_replyUpdate(@RequestParam HashMap<String, Object> map){
        this.replyService.UpdateR_Reply(map);
    }

    //해주세요 게시판 댓글 삭제
    @RequestMapping("/Board/ReplyDelete")
    @ResponseBody
    public void ctm_replyDelete(@RequestParam int reply_number){
        this.replyService.DeleteReply(reply_number);
    }

    //할게요 게시판 댓글 삭제
    @RequestMapping("/Board/R_ReplyDelete")
    @ResponseBody
    public void R_replyDelete(@RequestParam int reply_number){
        this.replyService.DeleteR_Reply(reply_number);
    }


    //해주세요 게시판 접수하기,접수완료
    @RequestMapping("/Board/check")
    @ResponseBody
    public HashMap<String, Object> check(@RequestParam HashMap<String, Object> map) {
        this.boardService.CBOardCheck(map);
        return map;
    }
    //할게요 게시판 접수하기,접수완료
    @RequestMapping("/Board/Rcheck")
    @ResponseBody
    public HashMap<String, Object> Rcheck(@RequestParam HashMap<String, Object> map){
        this.boardService.RBOardCheck(map);
        return map;

        }

    @Controller
    public class RefundMessageController {
        @PostMapping("/Board/SMS")
        public String sendSms(HttpServletRequest request) throws Exception {

            String api_key = "NCSFK7VPJZONYO8Y";
            String api_secret = "IA0TMBQVKQYV9O3JOOS1AOFIJSI4A25H";
            Message coolsms = new Message(api_key, api_secret);

            HashMap<String, String> set = new HashMap<String, String>();
            set.put("to", "01048005799"); // 수신번호

            set.put("from", (String)request.getParameter("from")); // 발신번호
            set.put("text", (String)request.getParameter("text")); // 문자내용
            set.put("type", "sms"); // 문자 타입
            set.put("app_version", "test app 1.2");

            System.out.println(set);
            try {
                JSONObject result = coolsms.send(set); // 보내기&전송결과받기

                System.out.println(result.toString());
            } catch (CoolsmsException e) {
                System.out.println(e.getMessage());
                System.out.println(e.getCode());
            }

            return "redirect:/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10";
        }

          @RequestMapping("/myWritePage")
         public String myWritePage(@RequestParam String nickname,Model model){
              List<BoardVo> writePage = BoardController.this.boardService.myWritePage(nickname);
              model.addAttribute("writePage", writePage);
              System.out.println(writePage);

              return "ctmboard/CWritePage";
          }

          @RequestMapping("/myReplyPage")
        public String myReplyPage(@RequestParam String nickname,Model model){
            List<ReplyVo> replyPage = BoardController.this.replyService.myReplyPage(nickname);
            model.addAttribute("replylist",replyPage);

            return "users/CReplyPage";

          }

    }







    }






