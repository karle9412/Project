package com.project.reply.dao;

import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;

import java.util.List;

public interface ReplyDao {


    List<ReplyVo> getReplylist(int board_number);

    List<RiderReplyVo> getRiderReplylist(int rider_board_number);

    void writeReply(ReplyVo replyVo);

    void RiderwriteReply(RiderReplyVo riderReplyVo);
}
