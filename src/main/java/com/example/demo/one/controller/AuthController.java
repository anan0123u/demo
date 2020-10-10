package com.example.demo.one.controller;

import com.example.demo.comm.ResPage;
import com.example.demo.comm.RetData;
import com.example.demo.model.ResBase;
import com.example.demo.one.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping("list")
    @ResponseBody
    public ResPage getAuthList() {
        return authService.getAuthList();
    }

    @RequestMapping("add")
    @ResponseBody
    public ResBase addAuth(@RequestBody Map map) {
        RetData retData = authService.addAuth(map);
        return new ResBase(retData.getRetCode(), retData.getRetMsg());
    }

    @RequestMapping("edit")
    @ResponseBody
    public ResBase editAuth(@RequestBody Map map) {
        RetData retData = authService.editAuth(map);
        return new ResBase(retData.getRetCode(), retData.getRetMsg());
    }

    @RequestMapping("stop")
    @ResponseBody
    public ResBase stopAuth(@RequestParam int authId) {
        RetData retData = authService.stopAuth(authId);
        return new ResBase(retData.getRetCode(), retData.getRetMsg());
    }
}
