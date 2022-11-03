package com.project.board.service;

import com.project.board.vo.BoardVo;

import java.util.List;

public interface BoardService {
    List<BoardVo> getBoardList(String menu_id);

    List<BoardVo> getBoardView(int board_number);
}
