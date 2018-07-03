package com.itunion.log.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequestMapping("/app")
@RestController
public class AppController {
    private Logger logger = LoggerFactory.getLogger(AppController.class);

    @RequestMapping
    public String selectList() {
        boolean flag = new Random().nextBoolean();
        if (flag) {
            throw new RuntimeException("查询报错");
        } else {
            return "正常返回 当前时间：" + System.currentTimeMillis();
        }
    }

    @ExceptionHandler
    @ResponseBody
    public String exceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return e.getMessage();
    }
}
