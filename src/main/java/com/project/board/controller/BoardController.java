package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardPager;
import com.project.board.vo.BoardVo;
import com.project.board.vo.ReviewVo;
import com.project.board.vo.RiderBoardVo;
import com.project.menus.service.MenuService;
import com.project.menus.vo.MenuVo;
import com.project.reply.service.ReplyService;
import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.Writer;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    MenuService menuService;


    @Autowired
    ReplyService replyService;


    BoardPager boardPager = new BoardPager();
    // 해주세요 게시판 글 전체 조회

    @RequestMapping("/Board/customerList")
    public String CustomerBoardList(Model model, @RequestParam HashMap<String,Object> map) {
        List<MenuVo> menuList = menuService.getMenuList();

        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

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
            customerList = boardService.customerList(map);
        } else if (boardPager.getPageNum() != 0) {
            map.put("pageNum", boardPager.getPageNum() * 10 + 1);
            customerList = boardService.customerList(map);
        }

        model.addAttribute("customerList", customerList);
        model.addAttribute("boardPager", boardPager);
        model.addAttribute("menuList", menuList);

        return "ctmboard/customerList";

    }
    // 할게여 게시판 글 전체 조회

    @RequestMapping("/Board/riderList")
    public String RiderBoardList(Model model, @RequestParam HashMap<String,Object> map){

        List<MenuVo>  menuList  = menuService.getMenuList();

        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        List<BoardVo> riderList = null;

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
            riderList = boardService.riderList(map);
        } else if (boardPager.getPageNum() != 0) {
            map.put("pageNum", boardPager.getPageNum() * 10 + 1);
            riderList = boardService.riderList(map);
        }


        model.addAttribute("riderList", riderList);
        model.addAttribute("boardPager", boardPager);
        model.addAttribute("menuList", menuList);

        return "riderboard/riderList";
    }

    // 후기 게시판 글 전체 조회
    @RequestMapping("/Board/reviewList")
    public String reviewList(Model model, @RequestParam HashMap<String,Object> map){

        List<MenuVo>  menuList  = menuService.getMenuList();
        List<BoardVo> reviewList = null;

        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        boardPager.setTotalCount(boardService.reviewCount()); // board 전체 게시글 개수를 지정
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
            reviewList = boardService.reviewList(map);
        } else if (boardPager.getPageNum() != 0) {
            map.put("pageNum", boardPager.getPageNum() * 10 + 1);
            reviewList = boardService.reviewList(map);
        }

        model.addAttribute("reviewList", reviewList);
        model.addAttribute("menuList", menuList);
        model.addAttribute("boardPager", boardPager);

        return "reviewboard/reviewList";
    }

    //해주세요 게시판 글 작성 페이지

    @RequestMapping("/Board/CBoardWriteForm")
    public String CBoardwriteform(BoardVo boardVo, Model model, HttpSession httpSession, @RequestParam HashMap<String, Object> map) {
        String menu_id = boardVo.getMenu_id();
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();
        System.out.println(nickName);







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
        System.out.println(cPageNum);



        boardService.C_insertboard(boardVo);



        return "redirect:/Board/customerList?menu_id=" + boardVo.getMenu_id() + "&pageNum=" + cPageNum + "&contentNum=" + cContentNum;
    }


    //할게요 게시판 글 작성 페이지
    @RequestMapping("/Board/RBoardWriteForm")
    public String RBoardwriteform(RiderBoardVo riderboardVo, Model model,@RequestParam HashMap<String,Object> map) {
        String menu_id = riderboardVo.getMenu_id();
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        model.addAttribute("cPageNum", cPageNum);
        model.addAttribute("cContentNum",cContentNum);

        model.addAttribute("menu_id", menu_id);
        return "riderboard/RBoardwrite";
    }


    //할게요 글 작성
    @RequestMapping("/Board/RBoardWrite")
    public String RBoardwrite(RiderBoardVo riderboardVo,@RequestParam HashMap<String,Object> map) {
        boardService.R_insertboard(riderboardVo);
        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        return "redirect:/Board/riderList?menu_id=" + riderboardVo.getMenu_id() + "&pageNum=" + cPageNum + "&contentNum=" + cContentNum;
    }


    //리뷰게시판 글 작성 페이지
    @RequestMapping("/Board/RVBoardWriteForm")
    public String RvBoardwriteform(ReviewVo reviewVo, Model model) {
        String menu_id = reviewVo.getMenu_id();

        model.addAttribute("menu_id", menu_id);
        return "reviewboard/RVBoardwrite";
    }


    //리뷰게시판 글 작성
    @RequestMapping("/Board/RVBoardWrite")
    public String RvVBoardwrite(ReviewVo reviewVo) {

        boardService.RV_insertboard(reviewVo);


        return "redirect:/Board/reviewList?menu_id=" + reviewVo.getMenu_id();
    }


    // 해주세요 게시글 상세조회
    @RequestMapping("/Board/CustomerDetail")
    public String Customerdetail(@RequestParam HashMap<String, Object> map, Model model, MenuVo menuVo, ReplyVo replyVo, UserVo userVo,HttpSession httpSession) {
        String menu_id = (String) map.get("menu_id");
        BoardVo boardVo = boardService.DetailCustomer(map);
        String nickName = ((UserVo) httpSession.getAttribute("login")).getNickname();






        model.addAttribute("boardVo", boardVo);
        model.addAttribute("menu_id", menu_id);
        model.addAttribute("writer",nickName);


        return "ctmboard/customerdetail";
    }


    //해주세요 댓글 조회
    @RequestMapping("/Board/CReplyList")
    @ResponseBody
    public List<ReplyVo> replylist(BoardVo boardVo,Model model){
        List<ReplyVo> replylist = replyService.getReplylist(boardVo.getBoard_number());



        return replylist;
    }

    // 할게요 게시글 상세조회

    @RequestMapping("/Board/riderDetail")
    public String riderdetail(@RequestParam HashMap<String, Object> map, Model model) {
        String menu_id = (String) map.get("menu_id");
        RiderBoardVo riderBoardVo = boardService.DetailRider(map);

        model.addAttribute("riderBoardVo", riderBoardVo);
        model.addAttribute("menu_id", menu_id);



        return "riderboard/riderdetail";
    }

    //할게요 댓글 조회
    @RequestMapping("/Board/RReplyList")
    @ResponseBody
    public List<RiderReplyVo> Rreplylist(RiderBoardVo riderBoardVo){
        List<RiderReplyVo> replylist = replyService.getRiderReplylist(riderBoardVo.getBoard_number());
        return replylist;
    }

    // 후기 게시글 상세조회

    @RequestMapping("/Board/ReviewDetail")
    public String reviewdetail(@RequestParam HashMap<String, Object> map, Model model) {
        String menu_id = (String) map.get("menu_id");
        ReviewVo reviewBoardVo = boardService.DetailReview(map);

        model.addAttribute("reviewBoardVo", reviewBoardVo);
        model.addAttribute("menu_id", menu_id);

        return "reviewboard/reviewdetail";

    }


    //해주세요 게시글 수정 페이지
    @RequestMapping("/Board/CBoardUpdateForm")
    public String updateform(@RequestParam HashMap<String, Object> map, Model model) {

        BoardVo boardVo = boardService.DetailCustomer(map);
        String menu_id = (String) map.get("menu_id");

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
        System.out.println(riderBoardVo);
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
    public String CDelete(@RequestParam HashMap<String, Object> map, BoardVo boardVo) {
        boardService.CBOardDelete(map);
        String menu_id = (String) map.get("menu_id");

        return "redirect:/Board/customerList?menu_id=" + boardVo.getMenu_id();


    }

    //할게요 게시판 삭제

    @RequestMapping("/Board/RBoardDelete")
    public String RDelete(@RequestParam HashMap<String, Object> map, RiderBoardVo riderBoardVo) {
        boardService.RBoardDelete(map);
        String menu_id = (String) map.get("menu_id");

        return "redirect:/Board/riderList?menu_id=" + riderBoardVo.getMenu_id();

    }

    //후기 게시판 삭제

    @RequestMapping("/Board/RVBoardDelete")
    public String RVDelete(@RequestParam HashMap<String, Object> map, ReviewVo reviewVo) {
        boardService.RVBoardDelete(map);
        String menu_id = (String) map.get("menu_id");

        return "redirect:/Board/reviewList?menu_id=" + reviewVo.getMenu_id();
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
        System.out.println(map);
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
    public void ctm_replyDelete(@RequestParam int reply_number){
        replyService.DeleteReply(reply_number);
    }

    //할게요 게시판 댓글 삭제
    @RequestMapping("/Board/R_ReplyDelete")
    @ResponseBody
    public void R_replyDelete(@RequestParam int reply_number){
        replyService.DeleteR_Reply(reply_number);
    }






}
