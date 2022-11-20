package com.project.board.dao.impl;

import com.project.board.dao.BoardDao;
import com.project.board.vo.BoardVo;
import com.project.board.vo.ReviewVo;
import com.project.board.vo.RiderBoardVo;
import com.project.reply.vo.ReplyVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

    @Autowired
    private SqlSession sqlSession;


    @Override
    public void C_insertboard(BoardVo boardVo) {
        sqlSession.insert("Board.C_InsertBoard", boardVo);
    }

    public void R_insertboard(RiderBoardVo riderboardVo) {
        sqlSession.insert("Board.R_InsertBoard", riderboardVo);
    }

    @Override
    public void RV_insertboard(ReviewVo reviewVo) {
        sqlSession.insert("Board.RV_InsertBoard", reviewVo);

    }

    @Override
    public BoardVo DetailCustomer(HashMap<String, Object> map) {
        BoardVo boardVo = sqlSession.selectOne("Board.DetailCustomerBoard", map);
        return boardVo;
    }

    @Override
    public RiderBoardVo DetailRider(HashMap<String, Object> map) {
        RiderBoardVo riderBoardVo = sqlSession.selectOne("Board.DetailRiderBoard",map);
        return riderBoardVo;
    }

    @Override
    public ReviewVo DetailReview(HashMap<String, Object> map) {
        ReviewVo reviewVo = sqlSession.selectOne("Board.DetailReviewBoard", map);
        return reviewVo;
    }

    @Override
    public void CBoardUpdate(HashMap<String, Object> map) {
      sqlSession.update("Board.CBoardUpdate", map);
    }

    @Override
    public void RBoardUpdate(HashMap<String, Object> map) {
        sqlSession.update("Board.RBoardUpdate", map);
    }

    @Override
    public void RVBoardUpdate(HashMap<String, Object> map) {
        sqlSession.update("Board.RVBoardUpdate", map);
    }

    @Override
    public void CBoardDelete(HashMap<String, Object> map) {
        sqlSession.delete("Board.CBoardDelete", map);
    }

    @Override
    public void RBoardDelete(HashMap<String, Object> map) {
        sqlSession.delete("Board.RBoardDelete", map);
    }

    @Override
    public void RVBoardDelete(HashMap<String, Object> map) {
        sqlSession.delete("Board.RVBoardDelete", map);
    }

    @Override
    public List<BoardVo> customerList(HashMap<String, Object> map) {
        List<BoardVo> boardList = sqlSession.selectList("Board.CustomerList",map);
        return boardList;
    }

    @Override
    public List<BoardVo> CSList(HashMap<String, Object> map) {
        List<BoardVo> boardList = sqlSession.selectList("Board.CSList",map);
        return boardList;
    }

    @Override
    public List<ReviewVo> reviewList(HashMap<String, Object> map) {
        List<ReviewVo> boardList = sqlSession.selectList("Board.ReviewList",map);
        return boardList;
    }    @Override
    public List<RiderBoardVo> riderList(HashMap<String, Object> map) {
        List<RiderBoardVo> boardList = sqlSession.selectList("Board.RiderList",map);
        return boardList;
    }

    @Override
    public int customerCount() {
        return sqlSession.selectOne("Board.CustomerCount");
    }
   @Override
    public int reviewCount() {
        return sqlSession.selectOne("Board.ReviewCount");
    }
    @Override
    public int riderCount() {
        return sqlSession.selectOne("Board.RiderCount");
    }

    @Override
    public int testCount() {
        return sqlSession.selectOne("Board.BoardCount");
    }

    @Override
    public List<BoardVo> testList(HashMap<String, Object> map) {
        List<BoardVo> boardList = sqlSession.selectList("Board.BoardPaging",map);
        return boardList;
    }

    @Override
    public List<ReplyVo> replyList(HashMap<String, Object> map) {
        List<ReplyVo> replyList = sqlSession.selectList("Reply.ReplyPaging",map);
        return replyList;
    }

    @Override
    public int replyCount(HashMap<String, Object> map) { return sqlSession.selectOne("Reply.ReplyCount",map) ; }

    @Override
    public void CBoardCheck(HashMap<String, Object> map) {
             sqlSession.update("Board.Check", map);

    }

    @Override
    public void RBoardCheck(HashMap<String, Object> map) {
            sqlSession.update("Board.RCheck", map);
    }

    @Override
    public List<BoardVo> myWritePage(String nickname) {
        List<BoardVo> myWritePage = sqlSession.selectList("Board.myWritePage", nickname);

        return myWritePage;
    }

    @Override
    public List<RiderBoardVo> myRWritePage(String nickname) {
        List<RiderBoardVo> myRwritePage = sqlSession.selectList("Board.myRWritePage", nickname);
        return myRwritePage;
    }

    @Override
    public List<ReviewVo> myRVwritePage(String nickname) {
        List<ReviewVo> myRVwritePage = sqlSession.selectList("Board.myRVwritePage", nickname);
        return myRVwritePage;
    }

    @Override
    public int CSCount(HashMap<String, Object> map) {
        return sqlSession.selectOne("Board.CSCount", map);
    }

    @Override
    public List<RiderBoardVo> RSList(HashMap<String, Object> map) {
        List<RiderBoardVo> boardList = sqlSession.selectList("Board.RSList",map);
        return boardList;
    }

    @Override
    public int RSCount(HashMap<String, Object> map) {
        return sqlSession.selectOne("Board.RSCount", map);
    }

    @Override
    public List<BoardVo> RVSList(HashMap<String, Object> map) {
        List<BoardVo> boardList = sqlSession.selectList("Board.RVSList",map);
        return boardList;
    }

    @Override
    public int RVSCount(HashMap<String, Object> map) {
        return sqlSession.selectOne("Board.RVSCount",map);
    }


}
