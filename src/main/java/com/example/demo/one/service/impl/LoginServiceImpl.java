package com.example.demo.one.service.impl;

import com.example.demo.comm.RetData;
import com.example.demo.one.mapper.LoginMapper;
import com.example.demo.one.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public RetData userLogin(String userName, String userPwd) {
        RetData retData = new RetData();
        Map map = loginMapper.getUserInfo(userName);
        retData.setRetData(map);
        return retData;
    }

}
