package com.example.cloudmusic.serviceImpl;

import com.example.cloudmusic.dao.AlbumDao;
import com.example.cloudmusic.dao.LikeDao;
import com.example.cloudmusic.entity.Album;
import com.example.cloudmusic.service.AlbumService;
import com.example.cloudmusic.service.likeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumDao albumDao;

    @Override
    public Album getAlbum(String id){
        return albumDao.getAlbum(id);
    }

    @Override
    public void addAlbum(String id, String name, String picUrl){
        albumDao.addAlbum(id,name,picUrl);
    }
}
