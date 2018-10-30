package com.csj.application.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/setting")
public class SettingController {

    @GetMapping("/role")
    public ModelAndView role(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("setting/mgr_role");
        return modelAndView;
    }

    @GetMapping("/menu")
    public ModelAndView menu(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("setting/mgr_menu");
        return modelAndView;
    }

    @GetMapping("/permission")
    public ModelAndView permission(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("setting/mgr_permission");
        return modelAndView;
    }


}
