package com.example.cloudmusic.serviceImpl;

import com.example.cloudmusic.dao.UserDynamicDao;
import com.example.cloudmusic.entity.UserDynamic;
import com.example.cloudmusic.service.UserDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDynamicServiceImpl implements UserDynamicService {
    @Autowired
    UserDynamicDao userDynamicDao;

    @Override
    public UserDynamic getUserDynamic(String uuid) {
        return userDynamicDao.getUserDynamic(uuid);
    }
}
