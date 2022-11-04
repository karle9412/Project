package com.project.user.controller;

import com.project.user.vo.UserVo;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class UserController {


    @RequestMapping("/")
    public String index() {
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "users/login";
    }

    @RequestMapping("/writeForm")
    public String writeForm(){
        return "users/write";
    }

    @RequestMapping("/write")
    public String write(UserVo vo){
        return "redirect:/login";
    }

    @RequestMapping("/loginProcess")
    public String loginProcess(UserVo vo){
        return "boards/list";
    }

}
