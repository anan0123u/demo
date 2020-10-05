package com.example.demo.one.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface RoleMapper {

    int getRoleCount();

    List<Map> getRoleList();

    int addRole(Map map);

    int editRole(Map map);

    int stopRole(int roleId);

    int deleteRole(int roleId);
}
