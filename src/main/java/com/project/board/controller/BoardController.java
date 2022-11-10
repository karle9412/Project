package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import com.project.board.vo.ReviewVo;
import com.project.board.vo.RiderBoardVo;
import com.project.menus.service.MenuService;
import com.project.menus.vo.MenuVo;
import com.project.reply.service.ReplyService;
import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLOutput;
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


   // 해주세요 게시판 글 전체 조회

    @RequestMapping("/Board/customerList")
    public String CustomerboardList(Model model, @RequestParam HashMap<String,Object> map){

        List<MenuVo>  menuList  = menuService.getMenuList();
        List<BoardVo> boardList = boardService.getCustomerBoardList(map);
        model.addAttribute("boardList", boardList);
        model.addAttribute("menuList", menuList);

        return "ctmboard/customerList";
    }

    // 할게여 게시판 글 전체 조회

    @RequestMapping("/Board/riderList")
    public String RiderboardList(Model model, @RequestParam HashMap<String,Object> map){

        List<MenuVo>  menuList  = menuService.getMenuList();
        List<RiderBoardVo> boardList = boardService.getRiderBoardList(map);
        model.addAttribute("boardList", boardList);
        model.addAttribute("menuList", menuList);

        return "riderboard/riderList";
    }

    // 후기 게시판 글 전체 조회
    @RequestMapping("/Board/reviewList")
    public String latterList(Model model, @RequestParam HashMap<String,Object> map){


        List<MenuVo>  menuList  = menuService.getMenuList();
        List<ReviewVo> boardList = boardService.getReviewBoardList(map);
        model.addAttribute("boardList", boardList);
        model.addAttribute("menuList", menuList);

        return "reviewboard/reviewList";
    }


    //해주세요 게시판 글 작성 페이지

    @RequestMapping("/Board/CBoardWriteForm")
    public String CBoardwriteform(BoardVo boardVo, Model model){
        String menu_id = boardVo.getMenu_id();System.out.println(menu_id);


        model.addAttribute("menu_id",menu_id);
        return "ctmboard/CBoardwrite";
    }

    //해주세요 게시판 글 작성

    @RequestMapping("/Board/CBoardWrite")
    public String write(BoardVo boardVo) {
        boardService.C_insertboard(boardVo);

        return "redirect:/Board/customerList?menu_id=" + boardVo.getMenu_id();
    }


    //할게요 게시판 글 작성 페이지
    @RequestMapping("/Board/RBoardWriteForm")
    public String RBoardwriteform(RiderBoardVo riderboardVo, Model model){
        String menu_id = riderboardVo.getMenu_id();

        model.addAttribute("menu_id",menu_id);
        return "riderboard/RBoardwrite";
    }


    //할게요 글 작성
    @RequestMapping("/Board/RBoardWrite")
    public String RBoardwrite(RiderBoardVo riderboardVo) {
        boardService.R_insertboard(riderboardVo);

        return "redirect:/Board/riderList?menu_id=" + riderboardVo.getMenu_id();
    }


    //리뷰게시판 글 작성 페이지
    @RequestMapping("/Board/RVBoardWriteForm")
    public String RvBoardwriteform(ReviewVo reviewVo, Model model){
        String menu_id = reviewVo.getMenu_id();

        model.addAttribute("menu_id",menu_id);
        return "reviewboard/RVBoardwrite";
    }


    //리뷰게시판 글 작성
    @RequestMapping("/Board/RVBoardWrite")
    public String RvVBoardwrite(ReviewVo reviewVo) {

        boardService.RV_insertboard(reviewVo);


       return "redirect:/Board/reviewList?menu_id=" + reviewVo.getMenu_id();
    }



    // 해주세요 게시글 상세조회, 댓글 리스트 조회
    @RequestMapping("/Board/CustomerDetail")
    public String Customerdetail(	@RequestParam HashMap<String, Object> map, Model model, MenuVo menuVo){
        String menu_id = (String) map.get("menu_id");
        BoardVo boardVo =  boardService.DetailCustomer(map);

        model.addAttribute("boardVo", boardVo);
        model.addAttribute("menu_id",menu_id);

        List<ReplyVo> replylist = replyService.getReplylist(boardVo.getBoard_number());
        model.addAttribute("replylist", replylist);

        return "ctmboard/customerdetail";
    }

    // 할게요 게시글 상세조회, 댓글 리스트 조회

    @RequestMapping("/Board/riderDetail")
    public String riderdetail(	@RequestParam HashMap<String, Object> map, Model model){
        String menu_id = (String) map.get("menu_id");
        RiderBoardVo riderBoardVo =  boardService.DetailRider(map);

        model.addAttribute("riderBoardVo", riderBoardVo);
        model.addAttribute("menu_id",menu_id);

        List<RiderReplyVo> replylist = replyService.getRiderReplylist(riderBoardVo.getBoard_number());
        model.addAttribute("replylist", replylist);

        return "riderboard/riderdetail";
    }

    @RequestMapping("/Board/ReviewDetail")
    public String reviewdetail(	@RequestParam HashMap<String, Object> map, Model model) {
        String menu_id = (String) map.get("menu_id");
        ReviewVo reviewBoardVo = boardService.DetailReview(map);

        model.addAttribute("reviewBoardVo", reviewBoardVo);
        model.addAttribute("menu_id", menu_id);

        return "reviewboard/reviewdetail";

    }
    // 고객게시판 댓글 작성
    @RequestMapping("/Board/CtmreplyWrite")
    public String ctm_replyWrite (ReplyVo replyVo,BoardVo boardVo){
        replyService.writeReply(replyVo);
     return "redirect:/Board/CustomerDetail?board_number=" + boardVo.getBoard_number();
    }

    //배달게시판 댓글 작성
    @RequestMapping("/Board/RidreplyWrite")
    public String rider_replyWrite(RiderReplyVo riderReplyVo, RiderBoardVo riderBoardVo){

        replyService.RiderwriteReply(riderReplyVo);
        return "redirect:/Board/riderDetail?board_number=" + riderBoardVo.getBoard_number();
    }

    //해주세요 게시글 수정 페이지
    @RequestMapping("/Board/CBoardUpdateForm")
    public String updateform(@RequestParam HashMap<String, Object> map, Model model){

        BoardVo boardVo   =  boardService.DetailCustomer(map);
        String menu_id = (String) map.get("menu_id");

        model.addAttribute("boardVo", boardVo);
        model.addAttribute("menu_id", menu_id);


        return "ctmboard/CBoardupdate";
    }

    //해주세요 게시글 수정
    @RequestMapping("/Board/CBoardUpdate")
    public String update(@RequestParam HashMap<String, Object> map, Model model,BoardVo boardVo){
        String menu_id = (String) map.get("menu_id");
            boardService.CBoardUpdate(map);

            return "redirect:/Board/CustomerDetail?board_number=" + boardVo.getBoard_number() + "&menu_id=" + menu_id;

    }

    //할게요 게시글 수정 페이지

    @RequestMapping("/Board/RBoardUpdateForm")
    public String RUpdateForm(@RequestParam HashMap<String, Object> map, Model model){
       RiderBoardVo riderBoardVo = boardService.DetailRider(map);
        System.out.println(riderBoardVo);
        String menu_id = (String) map.get("menu_id");

        model.addAttribute("riderBoardVo", riderBoardVo);
        model.addAttribute("menu_id",menu_id);

        return "riderboard/RBoardUpdate";
    }

    //할게요 게시글 수정
    @RequestMapping("/Board/RBoardUpdate")
    public String RBoardUpdate(@RequestParam HashMap<String, Object> map, Model model,RiderBoardVo riderBoardVo){
        String menu_id = (String) map.get("menu_id");
        boardService.RBoardUpdate(map);

        return "redirect:/Board/riderDetail?board_number=" + riderBoardVo.getBoard_number() + "&menu_id=" + menu_id;


    }

    //후기 게시판 게시글 수정 페이지

    @RequestMapping("/Board/RVUpdateForm")
   public String RVUpdateForm(@RequestParam HashMap<String, Object>map, Model model){
        ReviewVo reviewVo =  boardService.DetailReview(map);

        String menu_id = (String) map.get("menu_id");

        model.addAttribute("reviewVo", reviewVo);
        model.addAttribute("menu_id",menu_id);

        return "reviewboard/RVBoardUpdate";

    }

    //후기 게시판 게시글 수정

    @RequestMapping("/Board/RVBoardUpdate")
    public String RVUpdate(@RequestParam HashMap<String, Object> map, Model model, ReviewVo reviewVo){
        String menu_id = (String) map.get("menu_id");
           boardService.RVBoardUpdate(map);

           return  "redirect:/Board/ReviewDetail?board_number=" + reviewVo.getBoard_number() + "&menu_id=" + menu_id;

    }

    @RequestMapping("/Board/CBoardDelete")
    public String CDelete(@RequestParam HashMap<String, Object> map, Model model,BoardVo boardVo){
        boardService.CBOardDelete(map);
        String menu_id = (String) map.get("menu_id");

        return "redirect:/Board/customerList?menu_id=" + boardVo.getMenu_id();


    }



}
