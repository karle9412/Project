package com.project.user.dao.impl;

import com.project.user.dao.UserDao;
import com.project.user.vo.UserVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public UserVo login(HashMap<String, Object> map) {
        UserVo vo = sqlSession.selectOne("User.login", map);
        return vo;
    }

    @Override
    public void userInsert(UserVo userVo) {
        sqlSession.insert("User.UserInsert", userVo);
    }

    @Override
    public Object getUser(Object login) {
        Object getUser = sqlSession.selectOne("User.GetUser", login);
        return getUser;
    }

    @Override
    public void userUpdate(UserVo userVo) {
        sqlSession.update("User.UserUpdate",userVo);
    }
}
