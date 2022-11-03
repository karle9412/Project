package com.project.board.dao;

import com.project.board.vo.BoardVo;

import java.util.List;

public interface BoardDao {
    List<BoardVo> getBoardList(BoardVo boardVo);
}
