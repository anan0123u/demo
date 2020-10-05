package com.example.demo.one.controller;

import com.example.demo.model.ResBase;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("user")
public class LoginController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("login")
    @ResponseBody
    public ResBase userLogin(@RequestBody Map map) {
        log.info(map.toString());
        try {
            String userName = map.get("userName").toString();
            String userPwd = map.get("userPwd").toString();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, userPwd);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            return new ResBase(-9, "密码错误");
        }
        return new ResBase(0, "登录成功");
    }

    @RequestMapping("logout")
    @ResponseBody
    public ResBase userLogout() {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            return new ResBase(-9, e.getMessage());
        }
        return new ResBase(0, "成功退出");
    }
}
