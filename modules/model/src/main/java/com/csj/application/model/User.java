package com.csj.application.model;

import java.util.Date;

public class User {
    private String id;

    private String act;

    private String pwd;

    private String userName;

    private String nick;

    private String eMail;

    private String mobilePhone;

    private String status;

    private String actType;

    private String parentAct;

    private Date createTime;

    private Date lastLoginTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act == null ? null : act.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType == null ? null : actType.trim();
    }

    public String getParentAct() {
        return parentAct;
    }

    public void setParentAct(String parentAct) {
        this.parentAct = parentAct == null ? null : parentAct.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", act=").append(act);
        sb.append(", pwd=").append(pwd);
        sb.append(", userName=").append(userName);
        sb.append(", nick=").append(nick);
        sb.append(", eMail=").append(eMail);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", status=").append(status);
        sb.append(", actType=").append(actType);
        sb.append(", parentAct=").append(parentAct);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append("]");
        return sb.toString();
    }
}