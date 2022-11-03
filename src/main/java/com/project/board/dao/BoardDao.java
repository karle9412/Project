package com.project.board.dao;

import com.project.board.vo.BoardVo;
import com.project.menu.vo.MenuVo;

import java.util.List;

public interface BoardDao {

    List<BoardVo> getlist();

    void insertboard(BoardVo boardVo);
}
