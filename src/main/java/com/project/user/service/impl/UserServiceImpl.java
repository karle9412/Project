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

    //회원가입
    @Override
    public void userInsert(UserVo vo) {
        this.userDao.userInsert(vo);

    }

    //로그인
    @Override
    public UserVo login(HashMap<String, Object> map) {
        UserVo vo = this.userDao.login(map);
        return vo;
    }

    //회원정보 상세내용
    @Override
    public Object getUser(Object login) {
        Object getUser = this.userDao.getUser(login);
        return getUser;
    }

    //회원정보 수정
    @Override
    public void userUpdate(UserVo userVo) {
        this.userDao.userUpdate(userVo);
    }

    //회원탈퇴
    @Override
    public void userDelete(UserVo userVo) {
        this.userDao.userDelete(userVo);
    }

    //유저아이디 찾기
    @Override
    public String getUserid(UserVo userVo) {
        String getUserid = this.userDao.getUserid(userVo);
        return getUserid;
    }

    //중복 확인
    @Override
    public String useridCheck(UserVo userVo) {
        String useridCheck = this.userDao.useridCheck(userVo);
        return useridCheck;
    }
}
