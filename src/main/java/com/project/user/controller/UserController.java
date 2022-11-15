package com.project.user.controller;
import com.project.pds.user.controller.UserFileController;
import com.project.pds.user.service.PdsService;
import com.project.user.service.UserService;
import com.project.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

@org.springframework.stereotype.Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PdsService pdsService;
    //홈 화면 보내는 컨트롤러
    @RequestMapping("/")
    public String index() {
        return "home";
    }

    //로그인 화면 보내는 컨트롤러
    @RequestMapping("/login")
    public String login(){
        return "users/login";
    }

    //회원가입 화면으로 보내는 컨트롤러
    @RequestMapping("/writeForm")
    public String writeForm(){
        return "users/write";
    }

    //유저 아이디 찾는 화면으로 보내는 컨트롤러
    @RequestMapping("/findUserid")
    public String findUserid(){return "users/findUserid";}


    //비밀번호 변경을 하는 화면으로 보내는 컨트롤러
    @RequestMapping("/changePasswdForm")
    public String findPasswd(UserVo userVo, Model model){
        model.addAttribute(userVo);
        System.out.println(model);
        return "users/changePasswd";}

    //회원 가입 시 쓰는 컨트롤러
    @RequestMapping("/userProfileUploadForm")
    public String write(UserVo vo){
        this.userService.userInsert(vo);
        return "users/login";
    }

    //로그인 할 때 쓰는 컨트롤러
    @RequestMapping("/loginProcess")
    public String loginProcess(HttpSession httpSession,

                             @RequestParam HashMap<String, Object> map,
                             Model model){

        String returnURL = "";
        if(httpSession.getAttribute("login") != null){
            httpSession.removeAttribute("login");
        }
        UserVo vo = this.userService.login(map);

        if(vo != null) {
            httpSession.setAttribute("login", vo);
            returnURL = "ctmboard/customerList";
        }else{
            model.addAttribute("fail","로그인 실패");
            returnURL = "users/login";
        }
        return returnURL;

    }

    //유저 상세 정보 화면에서 쓰는 컨트롤러
    @RequestMapping("/getUser")
    public ModelAndView userInformation(HttpSession httpSession){
        ModelAndView mv = new ModelAndView();
        Object getUser = this.userService.getUser(httpSession.getAttribute("login"));
        Object getUserProfile = this.pdsService.getUserProfile(httpSession.getAttribute("login"));

        mv.addObject(getUser);

        mv.addObject(getUserProfile);
        System.out.println(mv.getModel());

        mv.setViewName("users/getUser");
        return mv;
    }

    //회원정보 수정하는 화면으로 보내는 컨트롤러
    //httpsessiohn에 있는 유저 아이디랑 비밀번호를 이용해서
    //getuser를 통해 유저 상세 정보를 들고 옴
    @RequestMapping("/updateForm")
    public ModelAndView updateForm(HttpSession httpSession){
        ModelAndView mv = new ModelAndView();
        Object getUser = this.userService.getUser(httpSession.getAttribute("login"));
        mv.addObject(getUser);
        mv.setViewName("users/update");
        return mv;
    }

    //유저 회원 정보 수정 할 때 쓰는 컨트롤러
    @RequestMapping("/update")
    public String update (UserVo userVo){

        this.userService.userUpdate(userVo);
        return "users/getUser";
    }

    //회원 정보 삭제할 때 쓰는 컨트롤러
    @RequestMapping("/delete")
    public String delete (HttpSession httpSession) {
        UserVo userVo = (UserVo) httpSession.getAttribute("login");
        this.userService.userDelete(userVo);

        return "users/login";
    }

    //로그아웃 하는 컨트롤러
    @RequestMapping(value = "/logout", method= {RequestMethod.GET})
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/login";
    }

    //유저 아이디 찾기 화면에서 ajax를 통해 유저 아이디를
    //화면을 바꾸지 않고 바로 띄우기 위한 컨트롤러
    @RequestMapping(value = "/getUserid", method={RequestMethod.POST}, produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String getUserid (@RequestParam("nickname") String nickname,
                             @RequestParam("email") String email) throws UnsupportedEncodingException {
        UserVo userVo = new UserVo(nickname, email);
        String getUserid = this.userService.getUserid(userVo);
        if (getUserid == null){
            getUserid = "닉네임과 이메일을 다시 확인해주세요";//"check nickname, email";
        }
        return getUserid;
    }

    //회원 가입 창에서 아이디 중복확인을 하기 위해
    //사용하는 컨트롤러
    @RequestMapping(value = "/useridCheck", method={RequestMethod.POST}, produces = "application/text; charset=UTF-8")
    @ResponseBody
    public String useridCheck(@RequestParam("userid") String userid){
        UserVo userVo = new UserVo(userid);
        String useridCheck = this.userService.useridCheck(userVo);
        String check = "";

        if (useridCheck != null){
            check = "중복된 아이디입니다.";
            return check;
        } else {
            check = "중복되지 않은 아이디입니다.";
            return check;
        }
    }


    //비밀번호 변경창에서 비밀번호 변경
    @RequestMapping("/changePasswd")
    public String changePasswd(UserVo userVo){
        this.userService.changePasswd(userVo);
        return "users/popupOut";
    }

}
