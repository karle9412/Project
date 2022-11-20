package com.project.pds.rider.reply.service.impl;

import com.project.pds.rider.reply.dao.RRFPdsDao;
import com.project.pds.rider.reply.service.RRFPdsService;
import com.project.pds.user.service.impl.PdsFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
}
