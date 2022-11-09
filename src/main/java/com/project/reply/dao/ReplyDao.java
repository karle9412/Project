package com.project.reply.dao;

import com.project.reply.vo.ReplyVo;

import java.util.List;

public interface ReplyDao {


    List<ReplyVo> getReplylist(int board_number);

    void writeReply(ReplyVo replyVo);

    void RiderwriteReply(ReplyVo replyVo);
}
