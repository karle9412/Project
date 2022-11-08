package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
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

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    MenuService menuService;


    @Autowired
    ReplyService replyService;

    //메뉴 리스트
    @RequestMapping("/list")
    public String list(Model model){
        List<MenuVo>  menuList =  menuService.getMenuList();
        model.addAttribute("menuList", menuList);

        return "boards/list";
    }

   // 게시판 글 전체 조회

    @RequestMapping("/Board/RequestList")
    public String boardList(Model model, @RequestParam HashMap<String,Object> map){

        List<MenuVo>  menuList  = menuService.getMenuList();
        List<BoardVo> boardList = boardService.getBoardList(map);
        model.addAttribute("boardList", boardList);
        model.addAttribute("menuList", menuList);

        String menu_id = (String) map.get("menu_id");

        return "boards/requestList";
    }


    // 후기 게시판
    @RequestMapping("/Board/LatterList")
    public String latterList(Model model, @RequestParam HashMap<String,Object> map){


        List<MenuVo>  menuList  = menuService.getMenuList();
        List<BoardVo> boardList = boardService.getBoardList(map);
        model.addAttribute("boardList", boardList);
        model.addAttribute("menuList", menuList);

        return "boards/latterList";
    }

    // 글 작성 페이지

    @RequestMapping("/Board/WriteForm")
    public String writeform(BoardVo boardVo,Model model){
        String menu_id = boardVo.getMenu_id();
        System.out.println(menu_id);

        model.addAttribute("menu_id",menu_id);
        return "boards/write";
    }

    // 글 작성

    @RequestMapping("/Board/Write")
    public String wrtie(BoardVo boardVo) {
        System.out.println(boardVo);
        boardService.insertboard(boardVo);
        System.out.println(boardVo);

        return "redirect:/list";
    }



    // 게시글 상세조회, 댓글 리스트 조회
    @RequestMapping("/Board/Detail")
    public String detail(	@RequestParam HashMap<String, Object> map, Model model){
        String menu_id = (String) map.get("menu_id");
        BoardVo boardVo =  boardService.getboardlist(map);

        model.addAttribute("boardVo", boardVo);
        model.addAttribute("menu_id",menu_id);

        List<ReplyVo> replylist = replyService.getReplylist(boardVo.getBoard_number());
        model.addAttribute("replylist", replylist);

        return "boards/detail";
    }


    // 댓글 작성
    @RequestMapping("/Board/replyWrite")
    public String replyWrite(ReplyVo replyVo,BoardVo boardVo){
        System.out.println(replyVo.getCont());
        System.out.println(replyVo);
        replyService.writeReply(replyVo);
     return "redirect:/Board/Detail?board_number=" + boardVo.getBoard_number() ;
    }



}
