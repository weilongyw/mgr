package com.csj.application.model;


import lombok.Data;

@Data
public class Permission {

    private String id;

    private String perName;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", perName=").append(perName);
        sb.append("]");
        return sb.toString();
    }
}