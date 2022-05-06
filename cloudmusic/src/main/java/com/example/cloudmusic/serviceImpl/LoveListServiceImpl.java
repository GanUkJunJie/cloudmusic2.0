package com.example.cloudmusic.serviceImpl;

import com.example.cloudmusic.dao.LoveListDao;
import com.example.cloudmusic.entity.LoveList;
import com.example.cloudmusic.service.LoveListService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoveListServiceImpl implements LoveListService {
    @Autowired
    LoveListDao loveListDao;

    @Override
    public LoveList getLoveList(String uuid) {
        return loveListDao.getLoveList(uuid);
    }

    @Override
    public Integer getCount(String uuid){
        return loveListDao.getCount(uuid);
    }

    @Override
    public void addLoveList(LoveList loveList){
        loveListDao.addLoveList(loveList);
    }

}
