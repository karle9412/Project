package com.project.pds.rider.reply.controller;

import com.project.pds.rider.reply.service.RRFPdsService;
import com.project.pds.user.service.PdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class RRFController {
    @Autowired
    private RRFPdsService rrfPdsService;

    @RequestMapping("Board/RRF/RRFUF")
    public String RRFUF(){
        System.out.println();
        return "riderboard/riderReplyFileUpdate";
    }

    @RequestMapping("Board/RRF/RRFU")
    public String RRFU(@RequestParam HashMap<String, Object> map,
                       HttpServletRequest request){
        System.out.println(request);
        System.out.println(map);
        this.rrfPdsService.setWrite(map, request);
        return "redirect:/Board/riderDetail?board_number=" + map.get("board_number") + "&menu_id=" + map.get("menu_id");
    }

}
