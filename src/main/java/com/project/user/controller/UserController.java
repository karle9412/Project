package com.project.user.controller;
import com.project.user.service.UserService;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
    @RequestMapping("/findUserid")
    public String findUserid(){return "users/findUserid";}

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
            returnURL = "/ctmboard/customerList";
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


    @RequestMapping("/delete")
    public String delete (HttpSession httpSession) {
        UserVo userVo = (UserVo) httpSession.getAttribute("login");
        this.userService.userDelete(userVo);

        return "users/login";
    }

    @RequestMapping(value = "/logout", method= {RequestMethod.GET})
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/login";
    }

    @RequestMapping(value = "/getUserid", method={RequestMethod.POST}, produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String getUserid (@RequestParam("nickname") String nickname,
                             @RequestParam("email") String email) throws UnsupportedEncodingException {
        UserVo userVo = new UserVo(nickname, email);
        String getUserid = userService.getUserid(userVo);
        if (getUserid == null){
            getUserid = "닉네임과 이메일을 다시 확인해주세요";//"check nickname, email";
        }
        return getUserid;
    }
}
