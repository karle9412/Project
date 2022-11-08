package com.project.board.service.impl;

import com.project.board.dao.BoardDao;
import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import com.project.board.vo.RiderBoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardDao boardDao;


    @Override
    public List<BoardVo> getCustomerBoardList(HashMap<String, Object> map) {
        List<BoardVo> boardList = boardDao.getCustomerBoardList(map);
        return boardList;
    }

    @Override
    public void C_insertboard(BoardVo boardVo) {
        boardDao.C_insertboard(boardVo);
    }

    public void R_insertboard(RiderBoardVo riderboardVo) {
        boardDao.R_insertboard(riderboardVo);
    }




    @Override
    public BoardVo getboardlist(HashMap<String, Object> map) {
        BoardVo boardVo = boardDao.getBoard(map);
        return boardVo;
    }

    @Override
    public List<BoardVo> getRiderBoardList(HashMap<String, Object> map) {
        List<BoardVo> boardList = boardDao.getRiderBoardList(map);

        return boardList;
    }

    @Override
    public List<BoardVo> getlist(String menu_id) {

        List<BoardVo> boardlist = boardDao.getlist(menu_id);
        return boardlist;
    }
}
