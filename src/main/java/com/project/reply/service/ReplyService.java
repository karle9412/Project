package com.project.reply.service;

import com.project.board.vo.ReplyPager;
import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;

import java.util.HashMap;
import java.util.List;

public interface ReplyService {

    List<ReplyPager> getReplylist(HashMap<String, Object> map);

    void writeReply(ReplyVo replyVo);

    void RiderwriteReply(RiderReplyVo riderReplyVo);

    void UpdateReply(HashMap<String, Object> map);

    void DeleteReply(HashMap<String, Object> map);

    void DeleteR_Reply(int reply_number);

    void UpdateR_Reply(HashMap<String, Object> map);

    int replyCount(HashMap<String, Object> map);

    List<ReplyVo> replyList(HashMap<String, Object> map);

    int CReplyCount(int board_number);

    void updateEndPage(HashMap<String, Object> map);

    void DUpdateEndPage(HashMap<String, Object> map);

    int RReplyCount(int board_number);

    void RUpdateEndPage(HashMap<String, Object> map);

    List<ReplyPager> getRReplylist(HashMap<String, Object> map);
}
