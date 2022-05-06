package com.example.cloudmusic.service;

import com.example.cloudmusic.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenu(Integer supIndex);
}
