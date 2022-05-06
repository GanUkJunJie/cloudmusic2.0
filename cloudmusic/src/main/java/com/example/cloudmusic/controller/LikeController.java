package com.example.cloudmusic.controller;

import com.example.cloudmusic.entity.LoveList;
import com.example.cloudmusic.entity.UserInfo;
import com.example.cloudmusic.service.LoveListService;
import com.example.cloudmusic.service.UserInfoService;
import com.example.cloudmusic.service.likeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    private likeService service;
    @Autowired
    private LoveListService loveService;
    @Autowired
    private UserInfoService userService;

    @GetMapping("/getLike")
    @ResponseBody
    public ApiResult getUserBase(@Param("uuid") String uuid, @Param("songIds") String songIds) {
        String[] ids = songIds.split(",");
        ArrayList<String> loveIds = new ArrayList<>();
        for (String e: ids){
            if (service.getLike(uuid,e) == 1){
                loveIds.add(e);
            }
        }
        return new ApiResult("200","",loveIds).success();
    }

    @GetMapping("/addLike")
    @ResponseBody
    public ApiResult addLike(@Param("uuid") String uuid, @Param("songId") String songId) {
        if (service.getLike(uuid,songId) == 0){
            service.addLike(uuid,songId);
            if (loveService.getCount(uuid) == 0){
                UserInfo userInfo = userService.getUserInfo(uuid);
                LoveList loveList = new LoveList(uuid,userInfo.getAvatar(),userInfo.getAvatar(),userInfo.getName(),
                        new Date().getTime(),0,0,1,1);
                loveService.addLoveList(loveList);
            }
            return new ApiResult("200","已添加到我喜欢的音乐",null).success();
        }
        service.delLike(uuid,songId);
        return new ApiResult("200","取消喜欢成功",null).success();
    }
}
