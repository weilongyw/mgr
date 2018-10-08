package com.csj.application.dao;

import com.csj.application.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    User selectByUserName(String userAccount);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}