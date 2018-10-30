package com.csj.application.web.shiro.filter;

import com.csj.application.model.User;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CusFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        //保存登陆成功用户信息
        User user= (User) subject.getPrincipal();
        HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
        HttpSession session = httpServletRequest.getSession();
        //把用户信息保存到session
        session.setAttribute("user", user);
        //登录成功后跳转首页
        WebUtils.getAndClearSavedRequest(request);
        WebUtils.redirectToSavedRequest(request,response,getSuccessUrl());
        return false;
    }


}
