package com.xiaolong.spider;

import com.xiaolong.spider.consumer.Consumer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description: 测试类，现在直接newConsumerSpring不会托管，可以使用@PostConstructor直接执行
 * @Author xiaolong
 * @Date 2021/10/26 8:12 上午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerTest {

    Consumer consumer = new Consumer();

    @Test
    public void testIOC(){
        consumer.run();
    }

}
