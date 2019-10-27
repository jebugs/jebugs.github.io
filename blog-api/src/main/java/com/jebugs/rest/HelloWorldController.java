package com.jebugs.rest;

import com.jebugs.common.utis.RedisUtils;
import com.jebugs.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haozx1
 * @Date 2019/9/3 16:34
 */
@RestController
public class HelloWorldController {

    @Autowired
    private TestService testService;

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String test() {

        redisUtils.set("testkey", "haozhaoxu");

        redisUtils.set("test::key", "haozhaoxu");

        return redisUtils.get("test::key").toString();
    }
}
