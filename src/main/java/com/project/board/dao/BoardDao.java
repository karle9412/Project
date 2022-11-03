package com.project.board.dao;

import com.project.board.vo.BoardVo;

import java.util.List;

public interface BoardDao {

    List<BoardVo> getBoardList(String menu_id);

    List<BoardVo> getBoardView(int board_number);

    void insertboard(BoardVo boardVo);

}
