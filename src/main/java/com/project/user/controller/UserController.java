package com.project.user.controller;
import com.project.user.service.UserService;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
        userService.userInsert(vo);
        return "redirect:/login";
    }

    @RequestMapping("/loginProcess")
    public String loginProcess(HttpSession httpSession,
                             @RequestParam HashMap<String, Object> map){

        String returnURL = "";
        if(httpSession.getAttribute("login") != null){
            httpSession.removeAttribute("login");
        }
        UserVo vo = userService.login(map);

        if(vo != null) {
            httpSession.setAttribute("login", vo);
            returnURL = "ctmboard/customerList";
        }else{
            returnURL = "redirect:/login";
        }
        return returnURL;

    }

    @RequestMapping("/User/getUser")
    public ModelAndView userInformation(HttpSession httpSession){
        ModelAndView mv = new ModelAndView();
        Object getUser = userService.getUser(httpSession.getAttribute("login"));

        mv.addObject(getUser);
        mv.setViewName("/users/getUser");
        return mv;
    }

    @RequestMapping("/updateForm")
    public String updateForm(){
        return "/users/update";
    }

}
