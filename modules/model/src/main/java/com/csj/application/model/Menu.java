package com.csj.application.model;

import lombok.Data;

@Data
public class Menu {
    private String id;

    private String menuName;

    private String menuUrl;

    private String menuIcon;

    private Integer isRoot;

    private String parentId;

    private Integer index;

}