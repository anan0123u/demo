package com.example.demo.one.service;

import com.example.demo.comm.ResData;
import com.example.demo.comm.ResPage;
import com.example.demo.comm.RetData;

import java.util.Map;

public interface RoleService {

    ResPage getRoleList();

    ResData getRoleInfo();

    RetData deleteRole(int roleId);

    RetData updateRole(Map map);

    RetData stopRole(int roleId);
}
