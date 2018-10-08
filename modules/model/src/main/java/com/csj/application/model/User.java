package com.csj.application.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String id;

    private String userName;

    private String userAct;

    private String userPwd;

    private Date createDate;

    private Date createTime;

    private Date lastLoginDate;

    private Date lastLoginTime;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", userAct=").append(userAct);
        sb.append(", userPwd=").append(userPwd);
        sb.append(", createDate=").append(createDate);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastLoginDate=").append(lastLoginDate);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append("]");
        return sb.toString();
    }
}