package com.project.reply.service;

import com.project.board.vo.ReplyPager;
import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;

import java.util.HashMap;
import java.util.List;

public interface ReplyService {

    List<ReplyPager> getReplylist(HashMap<String, Object> map);

    List<RiderReplyVo> getRiderReplylist(int board_number);

    void writeReply(ReplyVo replyVo);

    void RiderwriteReply(RiderReplyVo riderReplyVo);

    void UpdateReply(HashMap<String, Object> map);

    void DeleteReply(int reply_number);

    void DeleteR_Reply(int reply_number);

    void UpdateR_Reply(HashMap<String, Object> map);

    int replyCount(HashMap<String, Object> map);

    List<ReplyVo> replyList(HashMap<String, Object> map);

    int CReplyCount(int board_number);

    void updateEndPage(HashMap<String, Object> map);

    List<ReplyVo> myReplyPage(String nickname);
}
