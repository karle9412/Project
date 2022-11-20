package com.project.pds.rider.reply.dao;

import java.util.HashMap;

public interface RRFPdsDao {
    void setWrite(HashMap<String, Object> map);

    String getSFileName(HashMap<String, Object> map);
}
