package com.project.menu.service.impl;


import com.project.menu.dao.MenuDao;
import com.project.menu.service.MenuService;
import com.project.menu.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override

    public List<MenuVo> getMenuList(){

        List<MenuVo> menuList = menuDao.getMenuList();
        return menuList;
    }

}
