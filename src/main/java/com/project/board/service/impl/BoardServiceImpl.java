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
    public List<BoardVo> getCustomerBoardList(HashMap<String, Object> map) {
        List<BoardVo> boardList = boardDao.getCustomerBoardList(map);
        return boardList;
    }

    @Override
    public List<RiderBoardVo> getRiderBoardList(HashMap<String, Object> map) {
        List<RiderBoardVo> boardList = boardDao.getRiderBoardList(map);

        return boardList;
    }

    @Override
    public List<ReviewVo> getReviewBoardList(HashMap<String, Object> map) {
        List<ReviewVo> boardList = boardDao.getReviewBoardList(map);

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


}
