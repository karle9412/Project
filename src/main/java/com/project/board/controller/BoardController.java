package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import com.project.menu.service.MenuService;
import com.project.menu.vo.MenuVo;
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
    public String boardlist(Model model){

        List<MenuVo>  menuList =  menuService.getmenulist();
        List<BoardVo> boardlist = boardService.getlist();
        model.addAttribute("boardList", boardlist);
        model.addAttribute("menuList", menuList);



        return "boards/list";


    }

    @RequestMapping("/board/WriteForm")
    public String writeform(){




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
