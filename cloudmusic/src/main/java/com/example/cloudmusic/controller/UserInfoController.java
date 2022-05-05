package com.example.cloudmusic.controller;


import com.example.cloudmusic.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoService service;

    @GetMapping("/getUserInfo")
    @ResponseBody
    public ApiResult getUserInfo(String uuid){
        return new ApiResult("200","",service.getUserInfo(uuid)).success();
    }

    @GetMapping("/updateUserInfo")
    @ResponseBody
    public ApiResult updateUserInfo(@RequestParam("uuid") String uuid,
        @RequestParam("name") String name, @RequestParam("intro") String intro,
        @RequestParam("sex") String sex, @RequestParam("birthYear") Integer birthYear,
        @RequestParam("birthMonth") Integer birthMonth, @RequestParam("birthDay") Integer birthDay,
        @RequestParam("address") String address, @RequestParam("avatar") String avatar){
        service.updateUserInfo(uuid,name,sex,intro,birthYear,birthMonth,birthDay,address,avatar);
        return new ApiResult("200","修改成功",null).success();
    }

    @GetMapping("/getUserBase")
    @ResponseBody
    public ApiResult getUserBase(@RequestParam("uuid") String uuid) {
        return new ApiResult("200","",service.getUserBase(uuid)).success();
    }
}
