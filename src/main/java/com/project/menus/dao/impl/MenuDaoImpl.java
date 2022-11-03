package com.project.menus.dao.impl;

import com.project.menus.vo.MenuVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository("menudao")
public class MenuDaoImpl implements com.project.menus.dao.impl.MenuDao {

    @Autowired
    SqlSession sqlSession;

    public List<MenuVo> getmenulist() {
        List<MenuVo> menulist = sqlSession.selectList("Menu.MenuList");
        return menulist;
    }
}
