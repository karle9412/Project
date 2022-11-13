package com.project.reply.dao.impl;

import com.project.reply.dao.ReplyDao;
import com.project.reply.vo.ReplyVo;
import com.project.reply.vo.RiderReplyVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ReplyDaoImpl implements ReplyDao {

    @Autowired
    SqlSession sqlSession;

    public List<ReplyVo> getReplylist(int board_number){
        List<ReplyVo> readReply = sqlSession.selectList("Reply.Replylist", board_number);
        return readReply;
    }

    @Override
    public List<RiderReplyVo> getRiderReplylist(int board_number) {
        List<RiderReplyVo> readReply = sqlSession.selectList("Reply.RiderReplylist", board_number);

        return readReply;
    }

    @Override
    public void writeReply(ReplyVo replyVo) {
        sqlSession.insert("Reply.WriteReply", replyVo);
    }

    @Override
    public void RiderwriteReply(RiderReplyVo riderReplyVo) {
        sqlSession.insert("Reply.RiderReply",riderReplyVo);
    }

    @Override
    public void UpdateReply(HashMap<String, Object> map) {
        sqlSession.update("Reply.UpdateReply", map);
    }

    @Override
    public void DeleteReply(int reply_number) {
        sqlSession.delete("Reply.DeleteReply",reply_number);
    }
}
