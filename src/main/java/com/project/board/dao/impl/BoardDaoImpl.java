package com.project.board.dao.impl;

import com.project.board.dao.BoardDao;
import com.project.board.vo.BoardVo;
import com.project.board.vo.RiderBoardVo;
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
    public List<BoardVo> getCustomerBoardList(HashMap<String, Object> map) {
        List<BoardVo> boardList = sqlSession.selectList("Board.CustomerBoardList",map.get("menu_id"));
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
    public BoardVo getBoard(HashMap<String, Object> map) {
        BoardVo boardVo = sqlSession.selectOne("Board.Board", map);
        return boardVo;
    }

    @Override
    public List<BoardVo> getRiderBoardList(HashMap<String, Object> map) {
        List<BoardVo> boardList = sqlSession.selectList("Board.RiderBoardList",map.get("menu_id"));
        return boardList;
    }

    @Override
    public List<BoardVo> getlist(String menu_id) {
        List<BoardVo> boardlist = sqlSession.selectList("Board.BoardList", menu_id);
        return boardlist;
    }

}
