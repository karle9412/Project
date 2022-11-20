package com.project.pds.rider.reply.dao.impl;

import com.project.pds.rider.reply.dao.RRFPdsDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository("RRFPdsDao")
public class RRFPdsDaoImpl implements RRFPdsDao {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public void setWrite(HashMap<String, Object> map) {
        String Check = this.sqlSession.selectOne("File.getReplyFile", map);

        if (Check != null){
            this.sqlSession.update("File.updateReplyFile",map);
        } else {
            this.sqlSession.insert("File.insertReplyFile", map);
        }

    }

    @Override
    public String getSFileName(HashMap<String, Object> map) {
        String sFileName = this.sqlSession.selectOne("File.getSFileName", map);
        return sFileName;
    }
}
