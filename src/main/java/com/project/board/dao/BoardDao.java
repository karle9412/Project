package com.project.board.dao;

import com.project.board.vo.BoardVo;

import java.util.HashMap;
import java.util.List;

public interface BoardDao {

    List<BoardVo> getBoardList(HashMap<String, Object> map);

    List<BoardVo> getBoardView(int board_number);

    void insertboard(BoardVo boardVo);


}
