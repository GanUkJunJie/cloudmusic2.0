package com.example.cloudmusic.entity;

import java.util.List;

public class Menu {
    private Integer id;
    private String menuCode;
    private String menuName;
    private Integer supIndex;
    private List<Menu> subMenu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getSupIndex() {
        return supIndex;
    }

    public void setSupIndex(Integer supIndex) {
        this.supIndex = supIndex;
    }

    public List<Menu> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<Menu> subMenu) {
        this.subMenu = subMenu;
    }
}
