package com.project.reply.service;

import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;

import java.util.HashMap;
import java.util.List;

public interface ReplyService {

    List<ReplyVo> getReplylist(int board_number);

    List<RiderReplyVo> getRiderReplylist(int board_number);



    void writeReply(ReplyVo replyVo);

    void RiderwriteReply(RiderReplyVo riderReplyVo);

    void UpdateReply(HashMap<String, Object> map);

    void DeleteReply(int reply_number);
}
