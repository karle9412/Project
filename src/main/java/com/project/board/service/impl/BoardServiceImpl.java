package com.project.board.service.impl;

import com.project.board.dao.BoardDao;
import com.project.board.service.BoardService;
import com.project.board.vo.BoardVo;
import com.project.board.vo.ReviewVo;
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
    public void C_insertboard(BoardVo boardVo) {
        boardDao.C_insertboard(boardVo);
    }

    public void R_insertboard(RiderBoardVo riderboardVo) {
        boardDao.R_insertboard(riderboardVo);
    }

    @Override
    public void RV_insertboard(ReviewVo reviewVo) {
        boardDao.RV_insertboard(reviewVo);
    }


    @Override
    public BoardVo DetailCustomer(HashMap<String, Object> map) {
        BoardVo boardVo = boardDao.DetailCustomer(map);
        return boardVo;
    }

    @Override
    public RiderBoardVo DetailRider(HashMap<String, Object> map) {
        RiderBoardVo riderBoardVo = boardDao.DetailRider(map);
        return riderBoardVo;
    }

    @Override
    public ReviewVo DetailReview(HashMap<String, Object> map) {
        ReviewVo reviewVo = boardDao.DetailReview(map);
        return reviewVo;
    }

    @Override
    public void CBoardUpdate(HashMap<String, Object> map) {
            boardDao.CBoardUpdate(map);

    }

    @Override
    public void RBoardUpdate(HashMap<String, Object> map) {
        boardDao.RBoardUpdate(map);
    }

    @Override
    public void RVBoardUpdate(HashMap<String, Object> map) {
        boardDao.RVBoardUpdate(map);
    }

    @Override
    public void CBOardDelete(HashMap<String, Object> map) {
        boardDao.CBoardDelete(map);
    }

    @Override
    public void RBoardDelete(HashMap<String, Object> map) {
        boardDao.RBoardDelete(map);
    }

    @Override
    public void RVBoardDelete(HashMap<String, Object> map) {
        boardDao.RVBoardDelete(map);

    }

    @Override
    public int customerCount() {
        return boardDao.customerCount();
    }

    @Override
    public int reviewCount() {
        return boardDao.reviewCount();
    }
   @Override
    public int riderCount() {
        return boardDao.riderCount();
    }

    @Override
    public List<BoardVo> customerList(HashMap<String, Object> map) {
        List<BoardVo> boardList = boardDao.customerList(map);
        return boardList;
    }
    @Override
    public List<BoardVo> reviewList(HashMap<String, Object> map) {
        List<BoardVo> boardList = boardDao.reviewList(map);
        return boardList;
    }
    @Override
    public List<RiderBoardVo> riderList(HashMap<String, Object> map) {
        List<RiderBoardVo> boardList = boardDao.riderList(map);
        return boardList;
    }

    @Override
        public int testCount() {
            return boardDao.testCount();
        }


    @Override
    public List<BoardVo> testList(HashMap<String, Object> map) {
        List<BoardVo> boardList = boardDao.testList(map);
        return boardList;
    }
}


