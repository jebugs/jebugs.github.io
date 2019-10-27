package com.jebugs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 */
@SpringBootApplication
public class BlogApiApplication {

    private static Logger logger = LoggerFactory.getLogger(BlogApiApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(BlogApiApplication.class, args);

        logger.info("BlogApiApplication Start Success !");
    }
}
