package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import com.project.menus.service.MenuService;
import com.project.menus.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    MenuService menuService;
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


}
