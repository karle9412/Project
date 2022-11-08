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
public class BoardController {

    @Autowired
    BoardService boardService;
    @Autowired
    MenuService menuService;

    @RequestMapping("/Board/List")
    public String boardlist(Model model, String menu_id){

        List<MenuVo>  menuList =  menuService.getMenuList();
        List<BoardVo> boardlist = boardService.getlist(menu_id);
        model.addAttribute("boardList", boardlist);
        model.addAttribute("menuList", menuList);
        model.addAttribute("menu_id",menu_id);

        return "boards/boardList";
    }

    @RequestMapping("/Board/RequestList")
    public String boardList(Model model, @RequestParam HashMap<String,Object> map){

        List<MenuVo>  menuList  = menuService.getMenuList();
        List<BoardVo> boardList = boardService.getBoardList(map);
        model.addAttribute("boardList", boardList);
        model.addAttribute("menuList", menuList);

        String menu_id = (String) map.get("menu_id");

        return "boards/requestList";
    }

    @RequestMapping("/Board/LatterList")
    public String latterList(Model model, @RequestParam HashMap<String,Object> map){

        List<MenuVo>  menuList  = menuService.getMenuList();
        List<BoardVo> boardList = boardService.getBoardList(map);
        model.addAttribute("boardList", boardList);
        model.addAttribute("menuList", menuList);

        return "boards/latterList";
    }

    @RequestMapping("/Board/WriteForm")
    public String writeform(BoardVo boardVo,Model model){
        String menu_id = boardVo.getMenu_id();
        System.out.println(menu_id);

        model.addAttribute("menu_id",menu_id);
        return "boards/write";
    }

    @RequestMapping("/Board/Write")
    public String write(BoardVo boardVo) {
        System.out.println(boardVo);
        boardService.insertboard(boardVo);
        System.out.println(boardVo);

        return "boards/requestList";
    }

    @RequestMapping("/Board/Detail")
    public String detail(	@RequestParam HashMap<String, Object> map, Model model){
        String menu_id = (String) map.get("menu_id");
        BoardVo boardVo =  boardService.getboardlist(map);

        model.addAttribute("boardVo", boardVo);
        model.addAttribute("menu_id",menu_id);

        return "boards/detail";
    }


}
