package com.project.user.controller;
import com.project.user.service.UserService;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

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
        System.out.println("write"+vo);
        userService.userInsert(vo);
        return "redirect:/login";
    }

    @RequestMapping("/loginProcess")
    public String loginProcess(HttpSession httpSession,
                             @RequestParam HashMap<String, Object> map){
        UserVo vo = userService.login(map);
        System.out.println(vo);
        String returnURL = "";
        if(httpSession.getAttribute("login") != null){
            httpSession.removeAttribute("login");
        }

        if(vo != null) {
            httpSession.setAttribute("login", vo);
            returnURL = "redirect:/boards/home";
        }else{
            returnURL = "redirect:/login";
        }
        return returnURL;

    }



}
