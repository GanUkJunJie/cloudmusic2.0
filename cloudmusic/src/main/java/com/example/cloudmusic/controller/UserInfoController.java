package com.example.cloudmusic.controller;


import com.example.cloudmusic.entity.UserInfo;
import com.example.cloudmusic.entity.data.UserInfoData;
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
    public UserInfo getUserInfo(String tel){
        return service.getUserInfo(tel);
    }

    @PostMapping("/updateUserInfo")
    @ResponseBody
    public Boolean updateUserInfo(@RequestBody UserInfoData userInfoData){
        UserInfo userInfo = userInfoData.getUserInfo();
        service.updateUserInfo(userInfo.getTel(),userInfo.getName(),userInfo.getSex(),
                userInfo.getIntro(),userInfo.getBirth(),userInfo.getAddress(),userInfo.getRegPhoto());
        return true;
    }
    @GetMapping("/getHeaderInfo")
    @ResponseBody
    public UserInfo getHeaderInfo(String tel){
        return service.getHeaderInfo(tel);
    }


}
