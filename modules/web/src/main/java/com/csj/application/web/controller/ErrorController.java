package com.csj.application.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @RequestMapping("/403")
    public ModelAndView error() {
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}
