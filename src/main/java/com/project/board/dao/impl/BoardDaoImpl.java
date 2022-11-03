package com.project.board.dao.impl;

import com.project.board.dao.BoardDao;
import com.project.board.vo.BoardVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("boardDao")
public class BoardDaoImpl implements BoardDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<BoardVo> getBoardList() {
        List<BoardVo> boardList = sqlSession.selectList("Board.BoardList");
        System.out.println(boardList);
        return boardList;
    }
}
