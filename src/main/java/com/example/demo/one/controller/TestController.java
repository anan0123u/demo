package com.example.demo.one.controller;

import com.example.demo.one.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TestService testService;

    @RequestMapping("a")
    @ResponseBody
    public String test1() {
        log.info("1111111111");
        return "" + testService.test1();
    }
}
