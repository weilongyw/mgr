package com.csj.application.dao;

import com.csj.application.model.Permission;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    List<Permission> selectByRole(List<String> roleIds);
}