package com.csj.application.web.controller;


import com.csj.application.model.User;
import com.csj.application.service.MenuService;
import com.csj.application.vo.MenuVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;


    @GetMapping("/top")
    @ResponseBody
    public Map<String,Object>  topMenu(){
        User user=(User)SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        List<MenuVo> userMenus = menuService.getUserMenus(user.getId());
        Map<String,Object> dataMap=new HashMap<>();
        dataMap.put("data",userMenus);
        return dataMap;
    }

    @GetMapping("/left")
    @ResponseBody
    public Map<String,Object>  leftMenu(){
        User user=(User)SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        List<MenuVo> userMenus = menuService.getUserMenus(user.getId());
        Map<String,Object> dataMap=new HashMap<>();
        dataMap.put("data",userMenus);
        return dataMap;
    }


}
