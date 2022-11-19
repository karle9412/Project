package com.project.pds.rider.reply.controller;

import com.project.pds.user.service.PdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class RRFController {
    @Autowired
    private PdsService pdsService;

    @RequestMapping("Board/RRF/RRFUF")
    public String RRFUF(){
        return "riderboard/riderReplyFileUpdate";
    }

    @RequestMapping("RRF/RRFU")
    public String RRFU(){
        System.out.println("야!");
        return null;
    }

}
