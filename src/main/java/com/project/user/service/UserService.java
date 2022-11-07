package com.project.user.service;

import com.project.user.vo.UserVo;

import java.util.HashMap;


public interface UserService {
    void userInsert(UserVo vo);

    UserVo login(HashMap<String, Object> map);
    Object getUser(Object login);
}
