package com.example.cloudmusic.entity;

public class UserBase {
    private String uuid;
    private String tel;
    private String name;
    private String avatar;

    public UserBase(String uuid,String tel, String name, String avatar) {
        this.uuid = uuid;
        this.tel = tel;
        this.name = name;
        this.avatar = avatar;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
