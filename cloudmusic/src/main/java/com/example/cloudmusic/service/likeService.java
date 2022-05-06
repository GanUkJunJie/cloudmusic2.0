package com.example.cloudmusic.service;

import java.util.List;

public interface likeService {
    Integer getLike(String uuid,String songId);
    List<String> getLikeList(String uuid);
    void addLike(String uuid,String songId);
    void delLike(String uuid,String songId);
}
