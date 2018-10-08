package com.csj.application.dao;

import com.csj.application.model.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    List<Role> selectByUserId(String userId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}