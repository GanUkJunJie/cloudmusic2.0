package com.example.cloudmusic.controller;

import com.example.cloudmusic.service.LoveListService;
import com.example.cloudmusic.service.likeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/loveList")
public class LoveListController {
    @Autowired
    private LoveListService service;
    @Autowired
    private likeService likeService;

    @GetMapping("/getLoveList")
    @ResponseBody
    public ApiResult getLoveList(@Param("uuid") String uuid) {
        Map<String, Object> map = new HashMap<>();
        map.put("playlist",service.getLoveList(uuid));
        map.put("trackIds",likeService.getLikeList(uuid));
        return new ApiResult("200","",map).success();
    }

    @GetMapping("/getCount")
    @ResponseBody
    public ApiResult getCount(@Param("uuid") String uuid) {
        return new ApiResult("200","",service.getCount(uuid)).success();
    }
}
