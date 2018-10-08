package com.csj.application.vo;

import com.csj.application.model.Menu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
public class MenuVo {

    public MenuVo(Menu menu){
        this.id=menu.getId();
        this.text=menu.getMenuName();
        this.icon=menu.getMenuIcon();
        this.href=menu.getMenuUrl();
        this.pid=menu.getParentId();
    }

    @JsonIgnore
    private String id;

    @JsonIgnore
    private String pid;

    private String text;

    private String icon;

    @JsonInclude( JsonInclude.Include.NON_EMPTY)
    private String href;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MenuVo> subset;

    @Override
    public String toString() {
        return "MenuVo{" +
                "text='" + text + '\'' +
                ", icon='" + icon + '\'' +
                ", href='" + href + '\'' +
                ", subject=" + subset +
                '}';
    }
}
