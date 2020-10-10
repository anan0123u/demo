package com.example.demo.one.service.impl;

import com.example.demo.comm.ResPage;
import com.example.demo.comm.RetData;
import com.example.demo.one.mapper.AuthMapper;
import com.example.demo.one.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AuthMapper authMapper;

    @Override
    public ResPage getAuthList() {
        int iCount = authMapper.getAuthCount();
        List list = authMapper.getAuthList();
        return new ResPage(iCount, list);
    }

    @Override
    public RetData addAuth(Map map) {
        int result = authMapper.addAuth(map);
        return new RetData(0, "", null);
    }

    @Override
    public RetData editAuth(Map map) {
        int result = authMapper.editAuth(map);
        return new RetData(0, "", null);
    }

    @Override
    public RetData stopAuth(int authId) {
        int result = authMapper.stopAuth(authId);
        return new RetData(0, "", null);
    }
}
