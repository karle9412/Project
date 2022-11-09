package com.project.reply.service.impl;

import com.project.reply.dao.ReplyDao;
import com.project.reply.service.ReplyService;
import com.project.reply.vo.ReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    ReplyDao replyDao;

    public List<ReplyVo> getReplylist(int board_number) {
        List<ReplyVo> readReply = replyDao.getReplylist(board_number);

        return readReply;

    }

    @Override
    public void writeReply(ReplyVo replyVo) {
        replyDao.writeReply(replyVo);
    }

    @Override
    public void RiderwriteReply(ReplyVo replyVo) {
        replyDao.RiderwriteReply(replyVo);
    }
}
