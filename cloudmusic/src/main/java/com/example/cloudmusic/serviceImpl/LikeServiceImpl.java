package com.example.cloudmusic.serviceImpl;

import com.example.cloudmusic.dao.LikeDao;
import com.example.cloudmusic.entity.UserBase;
import com.example.cloudmusic.service.likeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements likeService {
    @Autowired
    LikeDao likeDao;

    @Override
    public Integer getLike(String uuid,String songId) {
        return likeDao.getLike(uuid,songId);
    }

    @Override
    public List<String> getLikeList(String uuid){
        return  likeDao.getLikeList(uuid);
    }

    @Override
    public void addLike(String uuid,String songId){
        likeDao.addLike(uuid, songId);
    };

    @Override
    public void delLike(String uuid,String songId){
        likeDao.delLike(uuid, songId);
    };
}
