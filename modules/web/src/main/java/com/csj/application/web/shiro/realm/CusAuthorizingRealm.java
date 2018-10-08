package com.csj.application.web.shiro.realm;

import com.csj.application.model.Permission;
import com.csj.application.model.Role;
import com.csj.application.model.User;
import com.csj.application.service.UserService;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

public class CusAuthorizingRealm extends AuthorizingRealm {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("===============授权方法执行");
        User user = (User) principalCollection.getPrimaryPrincipal();
        user=userService.getUserByUserName(user.getUserAct());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        List<Role> roles = userService.getRoles(user.getId());
        List<Permission> rolePermissions = userService.getPermissions(roles);
        List<String> permissionNames = Lists.transform(rolePermissions, new Function<Permission, String>() {
            @Override
            public String apply(Permission permission) {
                return permission.getPerName();
            }
        });
        //角色
        List<String> roleNames = Lists.transform(roles, new Function<Role, String>() {
            @Override
            public String apply(Role role) {
                return role.getRoleName();
            }
        });
        authorizationInfo.setRoles(new HashSet<>(roleNames));
        authorizationInfo.setStringPermissions(new HashSet<>(permissionNames));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("===============认证方法执行");
        UsernamePasswordToken authToken = (UsernamePasswordToken) authenticationToken;
        User user=userService.getUserByUserName(authToken.getUsername());
        if (null != user) {
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getUserPwd(), getName());
            return authenticationInfo;
        }else{
            return null;
        }
    }

}
