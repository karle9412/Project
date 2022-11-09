package com.project.board.service;

import com.project.board.vo.BoardVo;
import com.project.board.vo.ReviewVo;
import com.project.board.vo.RiderBoardVo;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
    List<BoardVo> getCustomerBoardList(HashMap<String, Object> map);
    List<RiderBoardVo> getRiderBoardList(HashMap<String, Object> map);
    List<ReviewVo> getReviewBoardList(HashMap<String, Object> map);
    void C_insertboard(BoardVo boardVo);
    void R_insertboard(RiderBoardVo riderboardVo);
    void RV_insertboard(ReviewVo reviewVo);

    BoardVo DetailCustomer(HashMap<String, Object> map);

    RiderBoardVo DetailRider(HashMap<String, Object> map);

    ReviewVo DetailReview(HashMap<String, Object> map);
}
