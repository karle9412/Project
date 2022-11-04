package com.project.board.service;

import com.project.board.vo.BoardVo;

import java.util.List;

public interface BoardService {


    List<BoardVo> getlist(String menu_id);


    void insertboard(BoardVo boardVo);
}
