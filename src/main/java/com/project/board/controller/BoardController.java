package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardPager;
import com.project.board.vo.BoardVo;
import com.project.board.vo.RiderBoardVo;
import com.project.menus.service.MenuService;
import com.project.menus.vo.MenuVo;
import com.project.reply.service.ReplyService;
import com.project.reply.vo.ReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Spliterator;

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

        /*
        List<BoardVo> boardList = boardService.getCustomerBoardList(map);
        model.addAttribute("boardList", boardList);
        */

        BoardPager boardPager = new BoardPager();

        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        List<BoardVo> testList = null;

        boardPager.setTotalCount(boardService.testCount()); // board 전체 게시글 개수를 지정
        boardPager.setPageNum(cPageNum - 1); // 현제 페이지를 페이지 객체에 지정한다 -1을 해야 쿼리에서 사용가능
        boardPager.setContentNum(cContentNum); // 한 페이지에 몇개씩 게시글을 보여줄지 정함
        boardPager.setCurrentBlock(cPageNum); // 현재 페이지 블록이 몇번인지 현재 페이지번호를 통해 지정
        boardPager.setLastBlock(); // 마지막 블록 번호를 전체 게시글 수를 통해서 정함
        boardPager.prevNext(cPageNum); // 현재 페이지 번호로 화살표를 나타낼지 정함
        boardPager.setStartPage(boardPager.getCurrentBlock()); // 시작 페이지를 페이지 블록번호로 지정
        boardPager.setEndPage(); // 마지막 페이지

        map.put("pageNum",boardPager.getPageNum());
        map.put("contentNum",boardPager.getContentNum());

        if(boardPager.getPageNum() == 0){
            testList = boardService.testList(map);
        }else if (boardPager.getPageNum() != 0){
            map.put("pageNum",boardPager.getPageNum() * 10 + 1);
            testList = boardService.testList(map);
        }

        model.addAttribute("testList",testList);
        model.addAttribute("boardPager",boardPager);
        model.addAttribute("menuList", menuList);

        return "ctmboard/customerList";
    }

    // 할게여 게시판 글 전체 조회

    @RequestMapping("/Board/riderList")
    public String RiderboardList(Model model, @RequestParam HashMap<String,Object> map){
        List<MenuVo>  menuList  = menuService.getMenuList();
        List<BoardVo> boardList = boardService.getRiderBoardList(map);
        model.addAttribute("boardList", boardList);
        model.addAttribute("menuList", menuList);
        return "riderboard/riderList";
    }


    //게시글 수정
    @RequestMapping("/Board/UpdateForm")
    public String updateform(@RequestParam HashMap<String, Object> map, Model model){

        BoardVo boardVo   =  boardService.DetailCustomer(map);
        model.addAttribute("boardVo", boardVo);

        return "ctmboard/update";
    }


    // 후기 게시판
    @RequestMapping("/Board/reviewList")
    public String latterList(Model model, @RequestParam HashMap<String,Object> map){


        List<MenuVo>  menuList  = menuService.getMenuList();
        List<BoardVo> boardList = boardService.getCustomerBoardList(map);
        model.addAttribute("boardList", boardList);
        model.addAttribute("menuList", menuList);

        return "reviewboard/reviewList";
    }

    //해주세요 게시판 글 작성 페이지

    @RequestMapping("/Board/CBoardWriteForm")
    public String CBoardwriteform(BoardVo boardVo, Model model){
        String menu_id = boardVo.getMenu_id();

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


    //리뷰게시판 글 작성 페이지
    @RequestMapping("/Board/RBoardWrite")
    public String RBoardwrite(RiderBoardVo riderboardVo) {
        boardService.R_insertboard(riderboardVo);

        return "redirect:/Board/riderList?menu_id=" + riderboardVo.getMenu_id();
    }


    //리뷰게시판 글 작성
    @RequestMapping("/Board/RVBoardWriteForm")
    public String RvBoardwriteform(RiderBoardVo riderboardVo, Model model){
        String menu_id = riderboardVo.getMenu_id();

        model.addAttribute("menu_id",menu_id);
        return "reviewboard/RVBoardwrite";
    }

//    @RequestMapping("/Board/RVBoardWrite")
//    public String RvVBoardwrite(BoardVo boardVo) {
//
//        boardService.RV_insertboard(riderboardVo);
//
//
//        return "redirect:/Board/customerList?menu_id=" + riderboardVo.getMenu_id();
//    }



    // 게시글 상세조회, 댓글 리스트 조회
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

    @RequestMapping("/Board/riderDetail")
    public String riderdetail(	@RequestParam HashMap<String, Object> map, Model model){
        String menu_id = (String) map.get("menu_id");
        RiderBoardVo riderBoardVo =  boardService.DetailRider(map);

        model.addAttribute("riderBoardVo", riderBoardVo);
        model.addAttribute("menu_id",menu_id);

        List<ReplyVo> replylist = replyService.getReplylist(riderBoardVo.getBoard_number());
        model.addAttribute("replylist", replylist);

        return "riderboard/riderdetail";
    }


    // 고객게시판 댓글 작성
    @RequestMapping("/Board/CtmreplyWrite")
    public String ctm_replyWrite(ReplyVo replyVo,BoardVo boardVo){
        replyService.writeReply(replyVo);
     return "redirect:/Board/CustomerDetail?board_number=" + boardVo.getBoard_number();
    }

    @RequestMapping("/Board/RidreplyWrite")
    public String rider_replyWrite(ReplyVo replyVo,RiderBoardVo riderBoardVo){
        replyService.RiderwriteReply(replyVo);
        return "redirect:/Board/riderdetail?board_number=" + riderBoardVo.getBoard_number();
    }



}
