package com.project.board.dao;

import com.project.board.vo.BoardVo;
import com.project.board.vo.ReviewVo;
import com.project.board.vo.RiderBoardVo;
import com.project.reply.vo.ReplyVo;

import java.util.HashMap;
import java.util.List;

public interface BoardDao {

    List<BoardVo> getCustomerBoardList(HashMap<String, Object> map);

    List<RiderBoardVo> getRiderBoardList(HashMap<String, Object> map);

    List<ReviewVo> getReviewBoardList(HashMap<String, Object> map);

    void C_insertboard(BoardVo boardVo);
    void R_insertboard(RiderBoardVo riderboardVo);
    void RV_insertboard(ReviewVo reviewVo);

    BoardVo DetailCustomer(HashMap<String, Object> map);

    RiderBoardVo DetailRider(HashMap<String, Object> map);

    ReviewVo DetailReview(HashMap<String, Object> map);

    void CBoardUpdate(HashMap<String, Object> map);

    void RBoardUpdate(HashMap<String, Object> map);

    void RVBoardUpdate(HashMap<String, Object> map);

    void CBoardDelete(HashMap<String, Object> map);

    void RBoardDelete(HashMap<String, Object> map);
    void RVBoardDelete(HashMap<String, Object> map);

    public List<BoardVo> customerList(HashMap<String, Object> map);
    public List<BoardVo> reviewList(HashMap<String, Object> map);
    public List<BoardVo> riderList(HashMap<String, Object> map);

    public int customerCount();
    public int reviewCount();
    public int riderCount();

    int testCount();

    List<BoardVo> testList(HashMap<String, Object> map);

    List<ReplyVo> replyList(HashMap<String, Object> map);

    int replyCount(HashMap<String, Object> map);
}
