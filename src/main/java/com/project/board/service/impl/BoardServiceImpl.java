package com.project.board.service.impl;

import com.project.board.dao.BoardDao;
import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDao boardDao;


    @Override
    public List<BoardVo> getlist() {

        List<BoardVo> boardlist = boardDao.getlist();
        System.out.println(boardlist);
        return boardlist;
    }

    @Override


    public void insertboard(BoardVo boardVo) {
        boardDao.insertboard(boardVo);
    }
}
