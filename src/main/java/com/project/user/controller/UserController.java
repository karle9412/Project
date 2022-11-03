package com.project.user.controller;
import com.project.user.service.UserService;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class UserController {

    @Autowired
    private UserService userService;

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
        System.out.println(vo);
        userService.userInsert(vo);
        return "redirect:/login";
    }

    @RequestMapping("/loginProcess")
    public String loginProcess(UserVo vo){
        return "boards/list";
    }



}
