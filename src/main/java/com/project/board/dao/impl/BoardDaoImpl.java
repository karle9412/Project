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
    public List<BoardVo> getBoardList(String menu_id) {
       List<BoardVo> boardList = sqlSession.selectList("Board.BoardList",menu_id);
       return boardList;
    }

    @Override
    public List<BoardVo> getBoardView(int board_number) {
        List<BoardVo> boardList = sqlSession.selectList("Board.BoardView",board_number);
        return boardList;
    }
}
