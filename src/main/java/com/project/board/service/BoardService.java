package com.project.board.service;

import com.project.board.vo.BoardVo;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
    List<BoardVo> getBoardList(HashMap<String, Object> map);
    List<BoardVo> getlist(String menu_id);
    void insertboard(BoardVo boardVo);
    BoardVo getboardlist(HashMap<String, Object> map);

}
