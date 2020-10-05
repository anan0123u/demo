package com.example.demo.one.service.impl;

import com.example.demo.comm.ResData;
import com.example.demo.comm.ResPage;
import com.example.demo.comm.RetData;
import com.example.demo.one.mapper.RoleMapper;
import com.example.demo.one.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleMapper roleMapper;

    @Override
    public ResPage getRoleList() {
        List list = roleMapper.getRoleList();
        return new ResPage(roleMapper.getRoleCount(), list);
    }

    @Override
    public ResData getRoleInfo() {

        Map map = new HashMap();
        map.put("roleId", 2);
        map.put("roleName", "nnnnnnnnn");
        return new ResData(0, "成功", map);
    }

    @Override
    public RetData updateRole(Map map) {
        String editMode = map.get("editMode").toString();
        int result = 0;
        if ("add".equals(editMode)) {
            result = roleMapper.addRole(map);
        } else {
            result = roleMapper.editRole(map);
        }

        return new RetData(0, "成功", null);
    }

    @Override
    public RetData stopRole(int roleId) {
        int result = roleMapper.stopRole(roleId);
        return new RetData(0, "成功", null);
    }


    @Override
    public RetData deleteRole(int roleId) {
        int result = roleMapper.deleteRole(roleId);
        return new RetData(0, "成功", null);
    }
}
