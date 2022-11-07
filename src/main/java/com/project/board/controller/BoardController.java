package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import com.project.menus.service.MenuService;
import com.project.menus.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/Board")
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    MenuService menuService;

    @RequestMapping("/RequestList")
    public String boardList(Model model, @RequestParam HashMap<String,Object> map){

        List<MenuVo>  menuList  = menuService.getMenuList();
        List<BoardVo> boardList = boardService.getBoardList(map);
        model.addAttribute("boardList", boardList);
        model.addAttribute("menuList", menuList);

        String menu_id = (String) map.get("menu_id");


        return "boards/requestList";
    }

    @RequestMapping("/LatterList")
    public String latterList(Model model, @RequestParam HashMap<String,Object> map){

        List<MenuVo>  menuList  = menuService.getMenuList();
        List<BoardVo> boardList = boardService.getBoardList(map);
        model.addAttribute("boardList", boardList);
        model.addAttribute("menuList", menuList);

        return "boards/latterList";

    }

    @RequestMapping("/View")
    public String view(Model model, int board_number){

        List<MenuVo>  menuList  = menuService.getMenuList();
        List<BoardVo> boardList = boardService.getBoardView(board_number);
        model.addAttribute("boardList", boardList);
        model.addAttribute("menuList", menuList);

        return "boards/view";
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
