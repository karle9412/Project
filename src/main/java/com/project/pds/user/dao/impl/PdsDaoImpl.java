package com.project.pds.user.dao.impl;

import com.project.pds.user.dao.PdsDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository("PdsDao")
public class PdsDaoImpl implements PdsDao {
    @Autowired
    private SqlSession sqlSession;
    @Override
    public void setWrite(HashMap<String, Object> map) {
        System.out.println("dao map: " + map);
        String Check = sqlSession.selectOne("UserFile.getUserProfile", map);
        System.out.println(Check);

        if (Check != null){
            sqlSession.update("UserFile.updateUserProfile",map);
        } else {
            sqlSession.insert("UserFile.insertUserProfile", map);
        }


    }
}
