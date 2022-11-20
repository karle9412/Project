package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.*;
import com.project.menus.service.MenuService;
import com.project.menus.vo.MenuVo;
import com.project.reply.service.ReplyService;
import com.project.reply.vo.CReplyVo;
import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;
import com.project.user.vo.UserVo;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.apache.ibatis.javassist.compiler.ast.Keyword;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
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


    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/Board/customerList")
    public String CustomerBoardList(Model model, @RequestParam HashMap<String,Object> map, HttpSession httpSession) {
        List<MenuVo> menuList = menuService.getMenuList();

        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));
        String keyword = (String) map.get("keyword");
        String searchType = (String) map.get("searchType");
        String userLocal = ((UserVo) httpSession.getAttribute("login")).getUser_local();




        if(searchType == null){
            keyword = "";
            searchType = "";
        }

        if(searchType.equals("board_check")){
            if (keyword.equals("대기")){
                keyword="0";
                map.put("keyword",keyword);
            }else if (keyword.equals("중")){
                keyword="1";
                map.put("keyword",keyword);
            }else if (keyword.equals("완료")){
                keyword="2";
                map.put("keyword",keyword);
            }
        }
        List<BoardVo> customerList = null;

        boardPager.setTotalCount(boardService.customerCount()); // board 전체 게시글 개수를 지정
        boardPager.setPageNum(cPageNum - 1); // 현제 페이지를 페이지 객체에 지정한다 -1을 해야 쿼리에서 사용가능
        boardPager.setContentNum(cContentNum); // 한 페이지에 몇개씩 게시글을 보여줄지 정함
        boardPager.setCurrentBlock(cPageNum); // 현재 페이지 블록이 몇번인지 현재 페이지번호를 통해 지정
        boardPager.setLastBlock(); // 마지막 블록 번호를 전체 게시글 수를 통해서 정함
        boardPager.prevNext(cPageNum); // 현재 페이지 번호로 화살표를 나타낼지 정함
        boardPager.setStartPage(boardPager.getCurrentBlock()); // 시작 페이지를 페이지 블록번호로 지정
        boardPager.setEndPage(); // 마지막 페이지

        map.put("pageNum", boardPager.getPageNum());
        map.put("contentNum", boardPager.getContentNum());

        if (boardPager.getPageNum() == 0) {
            if(!searchType.equals("초기값") && keyword.length() != 0){
                customerList = boardService.CSList(map);
                boardPager.setTotalCount(boardService.CSCount(map));
                boardPager.setPageNum(cPageNum - 1);
                boardPager.setContentNum(cContentNum);
                boardPager.setCurrentBlock(cPageNum);
                boardPager.setLastBlock();
                boardPager.prevNext(cPageNum);
                boardPager.setStartPage(boardPager.getCurrentBlock());
                boardPager.setEndPage();
            } else{
                customerList = boardService.customerList(map);
            }
        } else if (boardPager.getPageNum() != 0) {
            if(keyword.length() != 0){
              map.put("pageNum", boardPager.getPageNum() * 10 + 1);
              customerList = boardService.CSList(map);
              boardPager.setTotalCount(boardService.CSCount(map));
              boardPager.setPageNum(cPageNum - 1);
              boardPager.setContentNum(cContentNum);
              boardPager.setCurrentBlock(cPageNum);
              boardPager.setLastBlock();
              boardPager.prevNext(cPageNum);
              boardPager.setStartPage(boardPager.getCurrentBlock());
              boardPager.setEndPage();
            }else {
              map.put("pageNum", boardPager.getPageNum() * 10 + 1);
              customerList = boardService.customerList(map);
            }
        }

        model.addAttribute("customerList", customerList);
        model.addAttribute("boardPager", boardPager);
        model.addAttribute("menuList", menuList);
        model.addAttribute("map",map);
        model.addAttribute("userLocal",userLocal);

        return "ctmboard/customerList";

    }
    // 할게여 게시판 글 전체 조회

    @RequestMapping("/Board/riderList")
    public String RiderBoardList(Model model, @RequestParam HashMap<String,Object> map){

        List<MenuVo>  menuList  = menuService.getMenuList();

        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));
        String keyword = (String) map.get("keyword");
        String searchType = (String) map.get("searchType");

        if(searchType == null){
            keyword = "";
            searchType = "";
        }

        if(searchType.equals("board_check")){
            if (keyword.equals("대기")){
                keyword="0";
                map.put("keyword",keyword);
            }else if (keyword.equals("중")){
                keyword="1";
                map.put("keyword",keyword);
            }else if (keyword.equals("완료")){
                keyword="2";
                map.put("keyword",keyword);
            }
        }

        List<RiderBoardVo> riderList = null;

        boardPager.setTotalCount(boardService.riderCount()); // board 전체 게시글 개수를 지정
        boardPager.setPageNum(cPageNum - 1); // 현제 페이지를 페이지 객체에 지정한다 -1을 해야 쿼리에서 사용가능
        boardPager.setContentNum(cContentNum); // 한 페이지에 몇개씩 게시글을 보여줄지 정함
        boardPager.setCurrentBlock(cPageNum); // 현재 페이지 블록이 몇번인지 현재 페이지번호를 통해 지정
        boardPager.setLastBlock(); // 마지막 블록 번호를 전체 게시글 수를 통해서 정함
        boardPager.prevNext(cPageNum); // 현재 페이지 번호로 화살표를 나타낼지 정함
        boardPager.setStartPage(boardPager.getCurrentBlock()); // 시작 페이지를 페이지 블록번호로 지정
        boardPager.setEndPage(); // 마지막 페이지

        map.put("pageNum", boardPager.getPageNum());
        map.put("contentNum", boardPager.getContentNum());


        if (boardPager.getPageNum() == 0) {
            if(!searchType.equals("초기값") && keyword.length() != 0){
                riderList = boardService.RSList(map);
                boardPager.setTotalCount(boardService.RSCount(map));
                boardPager.setPageNum(cPageNum - 1);
                boardPager.setContentNum(cContentNum);
                boardPager.setCurrentBlock(cPageNum);
                boardPager.setLastBlock();
                boardPager.prevNext(cPageNum);
                boardPager.setStartPage(boardPager.getCurrentBlock());
                boardPager.setEndPage();
            }else {
                riderList = boardService.riderList(map);
            }
        } else if (boardPager.getPageNum() != 0) {
            if(keyword.length() != 0){
                map.put("pageNum", boardPager.getPageNum() * 10 + 1);
                riderList = boardService.RSList(map);
                boardPager.setTotalCount(boardService.RSCount(map));
                boardPager.setPageNum(cPageNum - 1);
                boardPager.setContentNum(cContentNum);
                boardPager.setCurrentBlock(cPageNum);
                boardPager.setLastBlock();
                boardPager.prevNext(cPageNum);
                boardPager.setStartPage(boardPager.getCurrentBlock());
                boardPager.setEndPage();
            }else{
              map.put("pageNum", boardPager.getPageNum() * 10 + 1);
              riderList = boardService.riderList(map);
            }
        }

        model.addAttribute("riderList", riderList);
        model.addAttribute("boardPager", boardPager);
        model.addAttribute("menuList", menuList);
        model.addAttribute("map",map);

        return "riderboard/riderList";
    }

    // 후기 게시판 글 전체 조회
    @RequestMapping("/Board/reviewList")
    public String reviewList(Model model, @RequestParam HashMap<String,Object> map){

        List<MenuVo>  menuList  = menuService.getMenuList();
        List<ReviewVo> reviewList = null;

        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));
        String keyword = (String) map.get("keyword");
        String searchType = (String) map.get("searchType");
        if(searchType == null){
            keyword = "";
            searchType = "";
        }

        if(searchType.equals("board_check")){
            if (keyword.equals("대기")){
                keyword="0";
                map.put("keyword",keyword);
            }else if (keyword.equals("중")){
                keyword="1";
                map.put("keyword",keyword);
            }else if (keyword.equals("완료")){
                keyword="2";
                map.put("keyword",keyword);
            }
        }

        boardPager.setTotalCount(boardService.reviewCount());
        boardPager.setPageNum(cPageNum - 1);
        boardPager.setContentNum(cContentNum);
        boardPager.setCurrentBlock(cPageNum);
        boardPager.setLastBlock();
        boardPager.prevNext(cPageNum);
        boardPager.setStartPage(boardPager.getCurrentBlock());
        boardPager.setEndPage();

        map.put("pageNum", boardPager.getPageNum());
        map.put("contentNum", boardPager.getContentNum());
        if (boardPager.getPageNum() == 0) {
            if(!searchType.equals("초기값") && keyword.length() != 0) {
                reviewList = boardService.RVSList(map);
                boardPager.setTotalCount(boardService.RVSCount(map));
                boardPager.setPageNum(cPageNum - 1);
                boardPager.setContentNum(cContentNum);
                boardPager.setCurrentBlock(cPageNum);
                boardPager.setLastBlock();
                boardPager.prevNext(cPageNum);
                boardPager.setStartPage(boardPager.getCurrentBlock());
                boardPager.setEndPage();
            }else {
                reviewList = boardService.reviewList(map);
            }
        } else if (boardPager.getPageNum() != 0) {
            if(keyword.length() != 0){
                map.put("pageNum", boardPager.getPageNum() * 10 + 1);
                reviewList = boardService.RVSList(map);
                boardPager.setTotalCount(boardService.RVSCount(map));
                boardPager.setPageNum(cPageNum - 1);
                boardPager.setContentNum(cContentNum);
                boardPager.setCurrentBlock(cPageNum);
                boardPager.setLastBlock();
                boardPager.prevNext(cPageNum);
                boardPager.setStartPage(boardPager.getCurrentBlock());
                boardPager.setEndPage();
            }else {
                map.put("pageNum", boardPager.getPageNum() * 10 + 1);
                reviewList = boardService.reviewList(map);
            }
        }

        model.addAttribute("reviewList", reviewList);
        model.addAttribute("menuList", menuList);
        model.addAttribute("boardPager", boardPager);
        model.addAttribute("map", map);

        return "reviewboard/reviewList";
    }

    //해주세요 게시판 글 작성 페이지

    @RequestMapping("/Board/CBoardWriteForm")
    public String CBoardwriteform(BoardVo boardVo, Model model, HttpSession httpSession, @RequestParam HashMap<String, Object> map) {
        String menu_id = boardVo.getMenu_id();
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();
        String board_local =  ((UserVo) httpSession.getAttribute("login")).getUser_local();
        System.out.println(board_local);







        model.addAttribute("menu_id", menu_id);
        model.addAttribute("cPageNum", cPageNum);
        model.addAttribute("cContentNum",cContentNum);
        model.addAttribute("writer", nickName);
        model.addAttribute("board_local",board_local);

        return "ctmboard/CBoardwrite";
    }

    //해주세요 게시판 글 작성
    @RequestMapping("/Board/CBoardWrite")
    public String write(BoardVo boardVo, BoardPager boardPager, @RequestParam HashMap<String,Object> map) {
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        boardService.C_insertboard(boardVo);


        return "redirect:/Board/customerList?menu_id=" + boardVo.getMenu_id() + "&pageNum=1&contentNum=10";
    }


    //할게요 게시판 글 작성 페이지
    @RequestMapping("/Board/RBoardWriteForm")
    public String RBoardwriteform(RiderBoardVo riderboardVo, Model model,HttpSession httpSession,@RequestParam HashMap<String,Object> map) {
        String menu_id = riderboardVo.getMenu_id();
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));
        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();
        String rider_local =  ((UserVo) httpSession.getAttribute("login")).getUser_local();
        System.out.println(rider_local);

        model.addAttribute("cPageNum", cPageNum);
        model.addAttribute("cContentNum",cContentNum);
        model.addAttribute("menu_id", menu_id);
        model.addAttribute("writer",nickName);
        model.addAttribute("rider_local",rider_local);
        return "riderboard/RBoardwrite";
    }


    //할게요 글 작성
    @RequestMapping("/Board/RBoardWrite")
    public String RBoardwrite(RiderBoardVo riderboardVo,@RequestParam HashMap<String,Object> map) {
        boardService.R_insertboard(riderboardVo);
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        return "redirect:/Board/riderList?menu_id=" + riderboardVo.getMenu_id() + "&pageNum=1&contentNum=10";
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

        boardService.RV_insertboard(reviewVo);
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));


        return "redirect:/Board/reviewList?menu_id=" + reviewVo.getMenu_id() + "&pageNum=1&contentNum=10";
    }


    // 해주세요 게시글 상세조회
    @RequestMapping("/Board/CustomerDetail")
    public String Customerdetail(@RequestParam HashMap<String, Object> map, Model model,HttpSession httpSession) {
        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();
        String menu_id  = (String)  map.get("menu_id");
        BoardVo boardVo =  boardService.DetailCustomer(map);

        model.addAttribute("boardVo", boardVo);
        model.addAttribute("menu_id", menu_id);
        model.addAttribute("boardPager", boardPager);

        ReplyPager replyPager = new ReplyPager();
        model.addAttribute("nickName",nickName);

        int rPageNum = Integer.parseInt((String) map.get("pageNum"));
        int rContentNum = Integer.parseInt((String) map.get("contentNum"));
        int Board_number = Integer.parseInt((String) map.get("board_number"));

        replyPager.setBoard_number(Board_number);
        replyPager.setTotalCount(replyService.CReplyCount(Board_number)); // board 전체 댓글 개수를 지정
        replyPager.setPageNum(rPageNum-1); // 현제 페이지를 페이지 객체에 지정한다 -1을 해야 쿼리에서 사용가능
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

        replyPager.setBoard_number(Board_number);
        replyPager.setTotalCount(replyService.CReplyCount(Board_number)); // board 전체 댓글 개수를 지정
        replyPager.setPageNum(rPageNum); // 현제 페이지를 페이지 객체에 지정한다 -1을 해야 쿼리에서 사용가능
        replyPager.setContentNum(rContentNum); // 한 페이지에 몇개씩 댓글을 보여줄지 정함
        replyPager.setCurrentBlock(rPageNum+1); // 현재 페이지 블록이 몇번인지 현재 페이지번호를 통해 지정
        replyPager.setLastBlock(); // 마지막 블록 번호를 전체 댓글 수를 통해서 정함
        replyPager.prevNext(rPageNum); // 현재 페이지 번호로 화살표를 나타낼지 정함
        replyPager.setStartPage(replyPager.getCurrentBlock()); // 시작 페이지를 페이지 블록번호로 지정
        replyPager.setEndPage();
        replyPager.setRend_page();

        map.put("pageNum", replyPager.getPageNum());
        map.put("contentNum", replyPager.getContentNum());
        map.put("endPage",replyPager.getEndPage());

        if (replyPager.getPageNum() == 0) {
            replyService.updateEndPage(map);
            replylist = replyService.getReplylist(map);
        } else if (replyPager.getPageNum() != 0) {
            map.put("pageNum", replyPager.getPageNum()*10+1);
            replyService.updateEndPage(map);
            replylist = replyService.getReplylist(map);
        }

        return replylist;
    }

    // 할게요 게시글 상세조회
    @RequestMapping("/Board/riderDetail")
    public String riderdetail(@RequestParam HashMap<String, Object> map, Model model,HttpSession httpSession) {
        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();
        String menu_id = (String) map.get("menu_id");
        RiderBoardVo riderBoardVo = boardService.DetailRider(map);

        model.addAttribute("riderBoardVo", riderBoardVo);
        model.addAttribute("menu_id", menu_id);
        model.addAttribute("nickName", nickName);

        ReplyPager replyPager = new ReplyPager();

        int rPageNum = Integer.parseInt((String) map.get("pageNum"));
        int rContentNum = Integer.parseInt((String) map.get("contentNum"));
        int Board_number = Integer.parseInt((String) map.get("board_number"));

        replyPager.setBoard_number(Board_number);
        replyPager.setTotalCount(replyService.RReplyCount(Board_number));
        replyPager.setPageNum(rPageNum-1);
        replyPager.setContentNum(rContentNum);
        replyPager.setCurrentBlock(rPageNum);
        replyPager.setLastBlock();
        replyPager.prevNext(rPageNum);
        replyPager.setStartPage(replyPager.getCurrentBlock());
        replyPager.setEndPage();

        map.put("pageNum", replyPager.getPageNum());
        map.put("contentNum", replyPager.getContentNum());

        model.addAttribute("map",map);
        model.addAttribute("replyPager",replyPager);

        return "riderboard/riderdetail";
    }

    //할게요 댓글 조회
    @RequestMapping("/Board/RReplyList")
    @ResponseBody
    public List<ReplyPager> Rreplylist(@RequestParam(required=false) HashMap<String,Object> map, Model model){

        List<ReplyPager> replylist = null;

        int rPageNum = Integer.parseInt((String) map.get("pageNum"));
        int rContentNum = Integer.parseInt((String) map.get("contentNum"));
        int Board_number = Integer.parseInt((String) map.get("board_number"));

        replyPager.setBoard_number(Board_number);
        replyPager.setTotalCount(replyService.RReplyCount(Board_number)); // board 전체 댓글 개수를 지정
        replyPager.setPageNum(rPageNum); // 현제 페이지를 페이지 객체에 지정한다 -1을 해야 쿼리에서 사용가능
        replyPager.setContentNum(rContentNum); // 한 페이지에 몇개씩 댓글을 보여줄지 정함
        replyPager.setCurrentBlock(rPageNum+1); // 현재 페이지 블록이 몇번인지 현재 페이지번호를 통해 지정
        replyPager.setLastBlock(); // 마지막 블록 번호를 전체 댓글 수를 통해서 정함
        replyPager.prevNext(rPageNum); // 현재 페이지 번호로 화살표를 나타낼지 정함
        replyPager.setStartPage(replyPager.getCurrentBlock()); // 시작 페이지를 페이지 블록번호로 지정
        replyPager.setEndPage();
        replyPager.setRend_page();

        map.put("pageNum", replyPager.getPageNum());
        map.put("contentNum", replyPager.getContentNum());
        map.put("endPage",replyPager.getEndPage());

        if (replyPager.getPageNum() == 0) {
            replyService.updateREndPage(map);
            replylist = replyService.getRReplyList(map);
        } else if (replyPager.getPageNum() != 0) {
            map.put("pageNum", replyPager.getPageNum()*10+1);
            replyService.updateREndPage(map);
            replylist = replyService.getRReplyList(map);
        }

        return replylist;
    }

    // 후기 게시글 상세조회

    @RequestMapping("/Board/ReviewDetail")
    public String reviewdetail(@RequestParam HashMap<String, Object> map, Model model,HttpSession httpSession) {
        String menu_id = (String) map.get("menu_id");
        ReviewVo reviewBoardVo = boardService.DetailReview(map);
        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();


        model.addAttribute("reviewBoardVo", reviewBoardVo);
        model.addAttribute("menu_id", menu_id);
        model.addAttribute("nickName", nickName);

        return "reviewboard/reviewdetail";

    }


    //해주세요 게시글 수정 페이지
    @RequestMapping("/Board/CBoardUpdateForm")
    public String updateform(@RequestParam HashMap<String, Object> map, Model model, HttpSession httpSession) {

        BoardVo boardVo = boardService.DetailCustomer(map);
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
        boardService.CBoardUpdate(map);

        return "redirect:/Board/CustomerDetail?board_number=" + boardVo.getBoard_number() + "&menu_id=" + menu_id;

    }

    //할게요 게시글 수정 페이지

    @RequestMapping("/Board/RBoardUpdateForm")
    public String RUpdateForm(@RequestParam HashMap<String, Object> map, Model model) {
        RiderBoardVo riderBoardVo = boardService.DetailRider(map);
        String menu_id = (String) map.get("menu_id");

        model.addAttribute("riderBoardVo", riderBoardVo);
        model.addAttribute("menu_id", menu_id);

        return "riderboard/RBoardUpdate";
    }

    //할게요 게시글 수정
    @RequestMapping("/Board/RBoardUpdate")
    public String RBoardUpdate(@RequestParam HashMap<String, Object> map, Model model, RiderBoardVo riderBoardVo) {
        String menu_id = (String) map.get("menu_id");
        boardService.RBoardUpdate(map);

        return "redirect:/Board/riderDetail?board_number=" + riderBoardVo.getBoard_number() + "&menu_id=" + menu_id;


    }

    //후기 게시판 게시글 수정 페이지

    @RequestMapping("/Board/RVUpdateForm")
    public String RVUpdateForm(@RequestParam HashMap<String, Object> map, Model model) {
        ReviewVo reviewVo = boardService.DetailReview(map);

        String menu_id = (String) map.get("menu_id");

        model.addAttribute("reviewVo", reviewVo);
        model.addAttribute("menu_id", menu_id);

        return "reviewboard/RVBoardUpdate";

    }

    //후기 게시판 게시글 수정

    @RequestMapping("/Board/RVBoardUpdate")
    public String RVUpdate(@RequestParam HashMap<String, Object> map, Model model, ReviewVo reviewVo) {
        String menu_id = (String) map.get("menu_id");
        boardService.RVBoardUpdate(map);

        return "redirect:/Board/ReviewDetail?board_number=" + reviewVo.getBoard_number() + "&menu_id=" + menu_id;

    }

    //해주세요 게시판 삭제

    @RequestMapping("/Board/CBoardDelete")
    @ResponseBody

    public String CDelete(@RequestParam HashMap<String, Object> map, BoardVo boardVo) {
        boardService.CBOardDelete(map);
        String menu_id = (String) map.get("menu_id");

        return "redirect:/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10";


    }

    //할게요 게시판 삭제

    @RequestMapping("/Board/RBoardDelete")
    public String RDelete(@RequestParam HashMap<String, Object> map, RiderBoardVo riderBoardVo) {
        boardService.RBoardDelete(map);
        String menu_id = (String) map.get("menu_id");

        return "redirect:/Board/riderList?menu_id=MENU_02&pageNum=1&contentNum=10";

    }

    //후기 게시판 삭제

    @RequestMapping("/Board/RVBoardDelete")
    public String RVDelete(@RequestParam HashMap<String, Object> map, ReviewVo reviewVo) {
        boardService.RVBoardDelete(map);
        String menu_id = (String) map.get("menu_id");

        return "redirect:/Board/reviewList?menu_id=MENU_03&pageNum=1&contentNum=10";
    }

    // 해주세요 댓글 작성
    @RequestMapping("/Board/CtmreplyWrite")
    @ResponseBody
    public void ctm_replyWrite(ReplyVo replyVo, BoardVo boardVo) {
        replyService.writeReply(replyVo);
    }

    //할게요 댓글 작성
    @RequestMapping("/Board/RidreplyWrite")
    @ResponseBody
    public void rider_replyWrite(RiderReplyVo riderReplyVo) {
        replyService.RiderwriteReply(riderReplyVo);
    }

    //해주세요 게시판 댓글 수정
    @RequestMapping("/Board/CtmreplyUpdate")
    @ResponseBody
    public void ctm_replyUpdate(@RequestParam HashMap<String, Object> map){
        replyService.UpdateReply(map);

    };

    //할게요 게시판 댓글 수정
    @RequestMapping("/Board/R_replyUpdate")
    @ResponseBody
    public void r_replyUpdate(@RequestParam HashMap<String, Object> map){
        replyService.UpdateR_Reply(map);
    }

    //해주세요 게시판 댓글 삭제
    @RequestMapping("/Board/ReplyDelete")
    @ResponseBody
    public void ctm_replyDelete(@RequestParam HashMap<String,Object> map){
        replyService.DeleteReply(map);
        replyService.DUpdateEndPage(map);
    }

    //할게요 게시판 댓글 삭제
    @RequestMapping("/Board/R_ReplyDelete")
    @ResponseBody
    public void R_replyDelete(@RequestParam int reply_number){
        replyService.DeleteR_Reply(reply_number);
    }
    //해주세요 게시판 접수하기,접수완료
    @RequestMapping("/Board/check")
    @ResponseBody
    public HashMap<String, Object> check(@RequestParam HashMap<String, Object> map) {
        boardService.CBoardCheck(map);
        return map;
    }
    //할게요 게시판 접수하기,접수완료
    @RequestMapping("/Board/Rcheck")
    @ResponseBody
    public HashMap<String, Object> Rcheck(@RequestParam HashMap<String, Object> map){
        boardService.RBOardCheck(map);
        return map;

        }


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

            try {
                JSONObject result = coolsms.send(set); // 보내기&전송결과받기

            } catch (CoolsmsException e) {
            }

            return "redirect:/Board/customerList?menu_id=MENU_01&pageNum=1&contentNum=10";
        }

          @RequestMapping("/myWritePage")
         public String myWritePage(@RequestParam String nickname,Model model){
              List<BoardVo> writePage = boardService.myWritePage(nickname);
              List<RiderBoardVo>  RwritePqage = boardService.myRWritePage(nickname);
              List<ReviewVo> RVwritePage = boardService.myRVwritePage(nickname);
              model.addAttribute("writePage", writePage);
              model.addAttribute("RwritePqage",RwritePqage);
              model.addAttribute("RVwritePage",RVwritePage);

              return "ctmboard/CWritePage";
          }

          @RequestMapping("/myReplyPage")
        public String myReplyPage(@RequestParam String nickname,Model model){
            List<ReplyVo> replyPage = replyService.myReplyPage(nickname);
            List<CReplyVo> Creplypage = replyService.CreplyPage(nickname);
            List<CReplyVo> Rreplypage = replyService.Rreplypage(nickname);
            List<BoardVo> boardPage = boardService.myWritePage(nickname);
              model.addAttribute("replylist",replyPage);
              model.addAttribute("Creplypage",Creplypage);
              model.addAttribute("RreplyPage", Rreplypage);


            return "users/CReplyPage";

          }

    }














