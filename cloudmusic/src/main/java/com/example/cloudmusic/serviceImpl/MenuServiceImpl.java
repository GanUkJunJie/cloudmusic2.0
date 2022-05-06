package com.example.cloudmusic.serviceImpl;

import com.example.cloudmusic.dao.MenuDao;
import com.example.cloudmusic.entity.Menu;
import com.example.cloudmusic.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuDao menuDao;

    @Override
    public List<Menu> getMenu(Integer supIndex) {
        return menuDao.getMenu(supIndex);
    }

}
