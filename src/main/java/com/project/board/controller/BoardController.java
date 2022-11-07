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
    @RequestMapping("/list")
    public String list(Model model){
        List<MenuVo>  menuList =  menuService.getmenulist();
        model.addAttribute("menuList", menuList);

        return "boards/list";
    }

    @RequestMapping("Board/List")
    public String boardlist(Model model, String menu_id){

        System.out.println(menu_id);
        List<MenuVo>  menuList =  menuService.getmenulist();
        List<BoardVo> boardlist = boardService.getlist(menu_id);
        model.addAttribute("boardList", boardlist);
        model.addAttribute("menuList", menuList);
        model.addAttribute("menu_id",menu_id);
        System.out.println(boardlist);


        return "boards/boardlist";


    }

    @RequestMapping("/board/WriteForm")
    public String writeform(BoardVo boardVo,Model model){
        String menu_id = boardVo.getMenu_id();
        System.out.println(menu_id);


       model.addAttribute("menu_id",menu_id);


        return "boards/write";

    }

    @RequestMapping("/board/Write")
    public String wrtie(BoardVo boardVo) {
        System.out.println(boardVo);
        boardService.insertboard(boardVo);
        System.out.println(boardVo);


        return "redirect:/list";
    }

    @RequestMapping("/board/detail")
    public String detail(	@RequestParam HashMap<String, Object> map, Model model){
        String menu_id = (String) map.get("menu_id");
        BoardVo boardVo =  boardService.getboardlist(map);

        model.addAttribute("boardVo", boardVo);
        model.addAttribute("menu_id",menu_id);

        List<ReplyVo> replylist = replyService.getReplylist(boardVo.getBoard_number());
        model.addAttribute("replylist", replylist);

        return "boards/detail";
    }


}
