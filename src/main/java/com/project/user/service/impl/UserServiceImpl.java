package com.project.user.service.impl;

import com.project.user.dao.UserDao;
import com.project.user.service.UserService;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void userInsert(UserVo vo) {
        this.userDao.userInsert(vo);

    }

    @Override
    public UserVo login(HashMap<String, Object> map) {
        UserVo vo = this.userDao.login(map);
        return vo;
    }

    @Override
    public Object getUser(Object login) {
        Object getUser = this.userDao.getUser(login);
        return getUser;
    }

    @Override
    public void userUpdate(UserVo userVo) {
        this.userDao.userUpdate(userVo);
    }

    @Override
    public void userDelete(UserVo userVo) {
        this.userDao.userDelete(userVo);

    }
}
