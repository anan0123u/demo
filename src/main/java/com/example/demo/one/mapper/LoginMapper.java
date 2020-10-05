package com.example.demo.one.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Mapper
@Component
public interface LoginMapper {

    Map getUserInfo(String userName);

}
