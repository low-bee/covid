package com.xiaolong.spider;

import com.xiaolong.spider.consumer.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description: Spider启动类
 * @Author xiaolong
 * @Date 2021/10/25 11:42 上午
 */
//@MapperScan(basePackages = "com.xiaolong.spider.dao")
@SpringBootApplication
@EnableScheduling
public class SpiderApplication {
    // 注入、web

    public static void main(String[] args) {
        SpringApplication.run(SpiderApplication.class, args);

    }

}
