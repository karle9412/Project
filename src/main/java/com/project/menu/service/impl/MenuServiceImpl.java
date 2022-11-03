package com.project.menu.service.impl;

import com.project.board.dao.BoardDao;
import com.project.menu.dao.impl.MenuDao;
import com.project.menu.service.MenuService;
import com.project.menu.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    public List<MenuVo> getmenulist() {

        List<MenuVo> menulist = menuDao.getmenulist();
        return menulist;
    }
}
