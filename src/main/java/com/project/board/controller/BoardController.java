package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/List")
    public String list(Model model){

        List<BoardVo> boardList = boardService.getBoardList();
        model.addAttribute("boardList",boardList);

        System.out.println(boardList);

        return "boards/list";
    }

}
