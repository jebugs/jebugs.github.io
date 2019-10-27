package com.jebugs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author haozx1
 * @Date 2019/8/27 22:23
 */
@SpringBootApplication
public class ShiroApplication {

    private static Logger logger = LoggerFactory.getLogger(ShiroApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(ShiroApplication.class, args);

        logger.info("ShiroApplication Start Success !");
    }
}
