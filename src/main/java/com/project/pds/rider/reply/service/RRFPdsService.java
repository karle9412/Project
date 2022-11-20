package com.project.pds.rider.reply.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

public interface RRFPdsService {
    void setWrite(HashMap<String, Object> map, HttpServletRequest request);

    String getSFileName(HashMap<String, Object> map);
}
