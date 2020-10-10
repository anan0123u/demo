package com.example.demo.one.service;

import com.example.demo.comm.ResPage;
import com.example.demo.comm.RetData;

import java.util.Map;

public interface AuthService {

    ResPage getAuthList();

    RetData addAuth(Map map);

    RetData editAuth(Map map);

    RetData stopAuth(int authId);
}
