package com.example.cloudmusic.dao;

import com.example.cloudmusic.entity.Album;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AlbumDao {
    Album getAlbum(String id);
    void addAlbum(@Param("id")String id, @Param("name")String name, @Param("picUrl")String picUrl);
}


