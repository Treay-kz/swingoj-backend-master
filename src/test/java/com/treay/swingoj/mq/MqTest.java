package com.treay.swingoj.mq;

import com.treay.swingoj.rabbitMQ.MessageProducer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @auther Treay_kz
 * @Date 2024/8/1 20:51
 */
@SpringBootTest
public class MqTest {
    @Resource
    private MessageProducer myMessageProducer;

    @Test
    void sendMessage() {
        myMessageProducer.sendMessage("code_exchange", "my_routingKey", "你好呀");
    }
}
