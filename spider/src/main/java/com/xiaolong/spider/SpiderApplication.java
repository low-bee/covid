package com.xiaolong.spider;

import com.xiaolong.spider.consumer.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description: Spider启动类
 * @Author xiaolong
 * @Date 2021/10/25 11:42 上午
 */
@MapperScan(basePackages = "com.xiaolong.spider.dao")
@SpringBootApplication
public class SpiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpiderApplication.class, args);
        new Thread(new Consumer(), "consumer-thread").start();
    }

}