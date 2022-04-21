package com.example.cloudmusic.controller;

import com.example.cloudmusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;
    /**
     * 登录
     * @param tel
     * @param pwd
     * @return
     */
    @GetMapping("/login")
    @ResponseBody
    public String login(@RequestParam("tel") String tel, @RequestParam("pwd") String pwd) {
        System.out.println("userName:"+tel);
        System.out.println("pwd:"+pwd);
        if (tel.length() ==11){
            if (pwd.length()>0){
                if (service.login(tel)==null){
                    return "用户不存在！";
                } else {
                    if (service.login(tel).equals(pwd)){
                        return tel;
                    } else {
                        return "密码错误";
                    }
                }
            }else {
                return "请输入密码";
            }
        }else {
            return "请输入合法的手机号码";
        }
    }

    /**
     * 注册
     * @param tel
     * @param pwd
     * @return
     */
    @GetMapping("/regist")
    @ResponseBody
    public String register(@RequestParam("tel") String tel, @RequestParam("pwd") String pwd) {
        if (tel.length() == 11 && pwd.length() > 0) {
            if (service.isExist(tel)!=null){
                return "用户已存在！";
            }else {
                service.register(tel,pwd);
                return "true";
            }
        }
        return "请输入合法的手机号码和密码";
    }
}
