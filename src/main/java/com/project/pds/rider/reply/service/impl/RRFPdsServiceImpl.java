package com.project.pds.rider.reply.service.impl;

import com.project.pds.rider.reply.dao.RRFPdsDao;
import com.project.pds.rider.reply.service.RRFPdsService;
import com.project.pds.user.service.impl.PdsFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service("RRFPdsSerivce")
public class RRFPdsServiceImpl implements RRFPdsService {
    @Autowired
    RRFPdsDao rrfPdsDao;
    @Override
    public void setWrite(HashMap<String, Object> map, HttpServletRequest request) {
        RRPdsFile.save(map, request);

        this.rrfPdsDao.setWrite(map);

    }

    @Override
    public String getSFileName(HashMap<String, Object> map) {
        String sFileName = this.rrfPdsDao.getSFileName(map);
        return sFileName;
    }
}
