package com.example.cloudmusic.serviceImpl;

import com.example.cloudmusic.dao.MenuDao;
import com.example.cloudmusic.dao.PassportDao;
import com.example.cloudmusic.entity.Menu;
import com.example.cloudmusic.service.MenuService;
import com.example.cloudmusic.service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportServiceImpl implements PassportService {
    @Autowired
    PassportDao passportDao;

    @Override
    public String getPassport(String uuid) {
        return passportDao.getPassport(uuid);
    }
}
