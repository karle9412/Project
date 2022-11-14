package com.project.user.service.impl;

import com.project.user.dao.UserDao;
import com.project.user.service.UserService;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public void userInsert(UserVo vo) {
        userDao.userInsert(vo);

    }

    @Override
    public UserVo login(HashMap<String, Object> map) {
        UserVo vo = userDao.login(map);
        return vo;
    }

    @Override
    public Object getUser(Object login) {
        Object getUser = userDao.getUser(login);
        return getUser;
    }

    @Override
    public void userUpdate(UserVo userVo) {

    }

    @Override
    public void userDelete(UserVo userVo) {

    }

    @Override
    public String getUserid(UserVo userVo) {
        String getUserid = userDao.getUserid(userVo);
        return getUserid;
    }

    @Override
    public String useridCheck(UserVo userVo) {
        String useridCheck = this.userDao.useridCheck(userVo);
        return useridCheck;
    }
}
