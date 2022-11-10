package com.project.board.service;

import com.project.board.vo.BoardVo;
import com.project.board.vo.RiderBoardVo;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;

public interface BoardService {
    List<BoardVo> getCustomerBoardList(HashMap<String, Object> map);
    List<BoardVo> getRiderBoardList(HashMap<String, Object> map);
    void C_insertboard(BoardVo boardVo);
    void R_insertboard(RiderBoardVo riderboardVo);
    BoardVo DetailCustomer(HashMap<String, Object> map);
    RiderBoardVo DetailRider(HashMap<String, Object> map);
    int testCount();
    List<BoardVo> testList(HashMap<String, Object> map);
}
