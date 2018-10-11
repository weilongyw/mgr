package com.csj.application.service;

import com.csj.application.dao.MenuMapper;
import com.csj.application.model.Menu;
import com.csj.application.vo.MenuVo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<MenuVo> getUserMenus(String userId) {
        List<Menu> menus = menuMapper.selectByUserId(userId);
        List<MenuVo> menuVos = Lists.transform(menus, menu -> new MenuVo(menu));
        List<MenuVo> rootMenus = new ArrayList<>();
        for (MenuVo menu : menuVos) {
            if (null == menu.getPid()||menu.getPid().equals("")) {
                rootMenus.add(menu);
            }
        }
        for (MenuVo rootMenu : rootMenus) {
            List<MenuVo> childList = getChild(rootMenu.getId(), menuVos);
            rootMenu.setSubset(childList);
        }
        return rootMenus;
    }


    public List<MenuVo> getChild(String id, List<MenuVo> allMenus) {
        //子菜单    
        List<MenuVo> childList = new ArrayList<>();
        for (MenuVo menuVo : allMenus) {// 遍历所有节点，将所有菜单的父id与传过来的根节点的id比较      //相等说明：为该根节点的子节点。      
            if (null == menuVo.getPid()) {
                continue;
            }
            if (menuVo.getPid().equals(id)) {
                childList.add(menuVo);
            }
        }
        //递归 
        for (MenuVo menuVo : childList) {
            menuVo.setSubset(getChild(menuVo.getId(), allMenus));
        }
        //如果节点下没有子节点，返回一个空List（递归退出）    
        if (childList.size() == 0) {
            return new ArrayList<>();
        }
        return childList;
    }

}
