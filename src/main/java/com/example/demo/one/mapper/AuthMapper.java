package com.example.demo.one.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface AuthMapper {

    int getAuthCount();

    List getAuthList();

    int addAuth(Map map);

    int editAuth(Map map);

    int stopAuth(int authId);
}
