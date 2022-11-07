package com.project.board.service;

import com.project.board.vo.BoardVo;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
    List<BoardVo> getBoardList(HashMap<String, Object> map);

    List<BoardVo> getBoardView(int board_number);

    void insertboard(BoardVo boardVo);

}
