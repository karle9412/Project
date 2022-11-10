package com.project.board.dao.impl;

import com.project.board.dao.BoardDao;
import com.project.board.vo.BoardVo;
import com.project.board.vo.ReviewVo;
import com.project.board.vo.RiderBoardVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLPermission;
import java.util.HashMap;
import java.util.List;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

    @Autowired
    private SqlSession sqlSession;


    @Override
    public List<BoardVo> getCustomerBoardList(HashMap<String, Object> map) {
        List<BoardVo> boardList = sqlSession.selectList("Board.CustomerBoardList",map.get("menu_id"));
        return boardList;
    }

    @Override
    public List<RiderBoardVo> getRiderBoardList(HashMap<String, Object> map) {
        List<RiderBoardVo> boardList = sqlSession.selectList("Board.RiderBoardList",map.get("menu_id"));
        return boardList;
    }

    @Override
    public List<ReviewVo> getReviewBoardList(HashMap<String, Object> map) {

        List<ReviewVo> boardList = sqlSession.selectList("Board.ReviewBoardList",map.get("menu_id"));

        return boardList;
    }

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
    public List<BoardVo> customerList(HashMap<String, Object> map) {
        List<BoardVo> boardList = sqlSession.selectList("Board.CustomerList",map);
        return boardList;
    }
    @Override
    public List<BoardVo> reviewList(HashMap<String, Object> map) {
        List<BoardVo> boardList = sqlSession.selectList("Board.ReviewList",map);
        return boardList;
    }    @Override
    public List<BoardVo> riderList(HashMap<String, Object> map) {
        List<BoardVo> boardList = sqlSession.selectList("Board.RiderList",map);
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


}
