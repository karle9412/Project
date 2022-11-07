package com.project.board.service.impl;

import com.project.board.dao.BoardDao;
import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDao boardDao;


    @Override
    public List<BoardVo> getlist(String menu_id) {

        List<BoardVo> boardlist = boardDao.getlist(menu_id);
        return boardlist;
    }

    @Override


    public void insertboard(BoardVo boardVo) {
        boardDao.insertboard(boardVo);
    }

    @Override
    public BoardVo getboardlist(HashMap<String, Object> map) {
        BoardVo boardVo = boardDao.getBoard(map);
        return boardVo;
    }
}
