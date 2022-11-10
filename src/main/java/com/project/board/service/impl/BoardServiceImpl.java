package com.project.board.service.impl;

import com.project.board.dao.BoardDao;
import com.project.board.service.BoardService;
import com.project.board.vo.BoardPager;
import com.project.board.vo.BoardVo;
import com.project.board.vo.RiderBoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
    public List<BoardVo> getRiderBoardList(HashMap<String, Object> map) {
        List<BoardVo> boardList = boardDao.getRiderBoardList(map);
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
    public int testCount() {
        return boardDao.testCount();
    }

    @Override
    public List<BoardVo> testList(HashMap<String, Object> map) {
        List<BoardVo> boardList = boardDao.testList(map);
        return boardList;
    }

/*    @Override
    public List<BoardVo> execute(HashMap<String, Object> map, Model model) {

        BoardPager boardPager = new BoardPager();

        int cPageNum = Integer.parseInt((String) map.get("pageNum"));
        int cContentNum = Integer.parseInt((String) map.get("contentNum"));

        List<BoardVo> testList = null;

        boardPager.setTotalCount(boardDao.testCount()); // board 전체 게시글 개수를 지정
        boardPager.setPageNum(cPageNum - 1); // 현제 페이지를 페이지 객체에 지정한다 -1을 해야 쿼리에서 사용가능
        boardPager.setContentNum(cContentNum); // 한 페이지에 몇개씩 게시글을 보여줄지 정함
        boardPager.setCurrentBlock(cPageNum); // 현재 페이지 블록이 몇번인지 현재 페이지번호를 통해 지정
        boardPager.setLastBlock(boardPager.getTotalCount()); // 마지막 블록 번호를 전체 게시글 수를 통해서 정함
        boardPager.prevNext(cPageNum); // 현재 페이지 번호로 화살표를 나타낼지 정함
        boardPager.setStartPage(boardPager.getCurrentBlock()); // 시작 페이지를 페이지 블록번호로 지정
        boardPager.setEndPage(boardPager.getLastBlock(),boardPager.getCurrentBlock()); // 마지막 페이지

        map.put("pageNum",boardPager.getPageNum());
        map.put("contentNum",boardPager.getContentNum());

        if(cContentNum == 10){ // 선택 게시글 수
            map.put("pageNum",boardPager.getPageNum() * 10);
            testList = boardDao.testList(map);
        }else if(cContentNum == 20){
            map.put("pageNum",boardPager.getPageNum() * 20);
            testList = boardDao.testList(map);
        }else if(cContentNum == 30){
            map.put("pageNum",boardPager.getPageNum() * 30);
            testList = boardDao.testList(map);
        }
        model.addAttribute("testList",testList);
        model.addAttribute("boardPager",boardPager);
        return testList;
    }
*/

}
