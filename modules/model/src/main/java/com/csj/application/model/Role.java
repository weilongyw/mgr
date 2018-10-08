package com.csj.application.model;

import lombok.Data;

@Data
public class Role {
    private String id;

    private String roleName;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleName=").append(roleName);
        sb.append("]");
        return sb.toString();
    }
}