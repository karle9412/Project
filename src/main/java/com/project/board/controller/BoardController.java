package com.project.board.controller;

import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

    BoardService boardService;

    @RequestMapping("/board/detail")
    public String detail(){
        BoardVo boardVo = boardService.Detail;

        return "boards/Detail";

    }


}
