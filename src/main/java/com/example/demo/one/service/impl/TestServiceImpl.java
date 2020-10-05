package com.example.demo.one.service.impl;

import com.example.demo.one.mapper.TestMapper;
import com.example.demo.one.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TestMapper testMapper;

    @Override
    public String test1() {
        log.info("" + 1111);
        return testMapper.testa();
    }
}
