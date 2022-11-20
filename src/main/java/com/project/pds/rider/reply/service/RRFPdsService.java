package com.project.pds.rider.reply.service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface RRFPdsService {
    void setWrite(HashMap<String, Object> map, HttpServletRequest request);
}
