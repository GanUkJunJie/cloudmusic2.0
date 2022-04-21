package com.example.cloudmusic.controller;

import com.example.cloudmusic.entity.UserBase;
import com.example.cloudmusic.service.UserBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userBase")
public class UserBaseController {
    @Autowired
    private UserBaseService service;

    @GetMapping("/getUserBase")
    @ResponseBody
    public UserBase getUserBase(String tel) {
        return service.getUserBase(tel);
    }
}
