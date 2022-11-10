package com.project.board.dao;

import com.project.board.vo.BoardVo;
import com.project.board.vo.RiderBoardVo;

import java.util.HashMap;
import java.util.List;

public interface BoardDao {
    List<BoardVo> getCustomerBoardList(HashMap<String, Object> map);
    List<BoardVo> getRiderBoardList(HashMap<String, Object> map);
    void C_insertboard(BoardVo boardVo);
    void R_insertboard(RiderBoardVo riderboardVo);
    BoardVo DetailCustomer(HashMap<String, Object> map);
    RiderBoardVo DetailRider(HashMap<String, Object> map);
    public List<BoardVo> testList(HashMap<String, Object> map);
    public int testCount();
}
