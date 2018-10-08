package com.csj.application.service;

import com.csj.application.dao.MenuMapper;
import com.csj.application.dao.PermissionMapper;
import com.csj.application.dao.RoleMapper;
import com.csj.application.dao.UserMapper;
import com.csj.application.model.Menu;
import com.csj.application.model.Permission;
import com.csj.application.model.Role;
import com.csj.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;


    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    public User getUserByUserName(String username) {
        return  userMapper.selectByUserName(username);
    }

    public List<Role> getRoles(String userId) {
       return roleMapper.selectByUserId(userId);
    }

    public List<Permission> getPermissions(List<Role> roles) {
        List<String> roleIds = new ArrayList<>();
        for(Role role:roles){
            roleIds.add(role.getId());
        }
        return permissionMapper.selectByRole(roleIds);
    }

    public List<Menu> getMenus(String userId) {
        return  menuMapper.selectByUserId(userId);
    }
}
