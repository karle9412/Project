package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping("/list")
    public String boardlist(Model model){

        List<BoardVo> boardlist = boardService.getlist();
        model.addAttribute("boardList", boardlist);
        System.out.println(boardlist);

        return "boards/list";


    }

    @RequestMapping("/board/detail")
    public String detail(){
        // BoardVo boardVo = boardService.Detail;

        return "boards/Detail";

    }


}
