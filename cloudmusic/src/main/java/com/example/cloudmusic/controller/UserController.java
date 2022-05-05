package com.example.cloudmusic.controller;
import com.example.cloudmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    /**
     * 登录
     * @param tel
     * @param password
     * @return
     */
    @GetMapping("/login")
    @ResponseBody
    public ApiResult login(@RequestParam("tel") String tel, @RequestParam("password") String password) {
        System.out.println("userName:"+tel);
        System.out.println("password:"+password);
        if (service.login(tel)==null){
            return new ApiResult("0","用户不存在！",null).success();
        } else {
            if (service.login(tel).equals(password)){
                return new ApiResult("200","登录成功！",service.getUUID(tel)).success();
            } else {
                return new ApiResult("0","密码错误！",null).success();
            }
        }
    }

//    @GetMapping("/queryUser")
//    @ResponseBody
//    public ApiResult queryUser(@RequestParam("uuid") String uuid) {
//        return new ApiResult("200","",service.queryUser(uuid)).success();
//    }

    /**
     * 注册
     * @param tel
     * @param password
     * @return
     */
    @GetMapping("/register")
    @ResponseBody
    public ApiResult register(@RequestParam("tel") String tel, @RequestParam("password") String password) {
        if (service.isExist(tel) == 1){
            return new ApiResult("0","用户已存在！",null).success();
        }else {
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            service.register(uuid,tel,password);
            return new ApiResult("200","注册成功！",null).success();
        }
    }
}
