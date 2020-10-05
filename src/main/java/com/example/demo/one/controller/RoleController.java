package com.example.demo.one.controller;

import com.example.demo.comm.ResData;
import com.example.demo.comm.ResPage;
import com.example.demo.comm.RetData;
import com.example.demo.model.ResBase;
import com.example.demo.one.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("list")
    @ResponseBody
    public ResPage getRoleList() {
        return roleService.getRoleList();
    }

    @RequestMapping("info")
    @ResponseBody
    public ResData getRoleInfo() {
        return roleService.getRoleInfo();
    }

    @RequestMapping("update")
    @ResponseBody
    public ResBase updateRole(@RequestBody Map map) {
        RetData retData = roleService.updateRole(map);
        return new ResBase(retData.getRetCode(), retData.getRetMsg());
    }

    @RequestMapping("stop")
    @ResponseBody
    public ResBase stopRole(int roleId) {
        RetData retData = roleService.stopRole(roleId);
        return new ResBase(retData.getRetCode(), retData.getRetMsg());
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResBase deleteRole(int roleId) {
        RetData retData = roleService.deleteRole(roleId);
        return new ResBase(retData.getRetCode(), retData.getRetMsg());
    }
}
