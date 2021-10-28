package com.xiaolong.spider;

import com.xiaolong.spider.config.Config;
import com.xiaolong.spider.constant.Constant;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.xmlunit.validation.ValidationResult;

import java.util.Properties;

/**
 * @Description: ProducerTest 测试
 * @Author xiaolong
 * @Date 2021/10/28 10:02 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProducerTest {

    private Properties config = new Config().getProperties();


    @Test
    public void test() {
        log.info("call test.");
        String url = "https://data.cdc.gov/resource/9bhg-hcku.json?$$app_token=";
        url = url + config.getProperty(Constant.SPIDER_FOREIGN_TOKEN);
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity(url , String.class);
        String sttr = response.getBody();
        log.info("sttr=" + sttr);
    }

}
