package com.project.reply.service;

import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;

import java.util.List;

public interface ReplyService {

    List<ReplyVo> getReplylist(int board_number);

    List<ReplyVo> getRiderReplylist(int board_number);



    void writeReply(ReplyVo replyVo);

    void RiderwriteReply(RiderReplyVo riderReplyVo);
}
