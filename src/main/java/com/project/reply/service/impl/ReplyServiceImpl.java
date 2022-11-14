package com.project.reply.service.impl;

import com.project.reply.dao.ReplyDao;
import com.project.reply.service.ReplyService;
import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public List<RiderReplyVo> getRiderReplylist(int board_number) {
        List<RiderReplyVo> readReply = replyDao.getRiderReplylist(board_number);

        return readReply;
    }

    @Override
    public void writeReply(ReplyVo replyVo) {
        replyDao.writeReply(replyVo);
    }

    @Override
    public void RiderwriteReply(RiderReplyVo riderReplyVo) {
        replyDao.RiderwriteReply(riderReplyVo);
    }

    @Override
    public void UpdateReply(HashMap<String, Object> map) {
        replyDao.UpdateReply(map);
    }

    @Override
    public void UpdateR_Reply(HashMap<String, Object> map) {
        replyDao.UpdateR_Reply(map);
    }

    @Override
    public int replyCount(HashMap<String, Object> map) { return replyDao.ReplyCount(map); }

    @Override
    public List<ReplyVo> replyList(HashMap<String, Object> map) {
        return replyDao.ReplyList(map);
    }

    @Override
    public void DeleteReply(int reply_number) {
        replyDao.DeleteReply(reply_number);
    }

    @Override
    public void DeleteR_Reply(int reply_number) {
        replyDao.DeleteR_Reply(reply_number);
    }
}
