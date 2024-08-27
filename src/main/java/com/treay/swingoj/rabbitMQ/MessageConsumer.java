package com.treay.swingoj.rabbitMQ;

import com.rabbitmq.client.Channel;
import com.treay.swingoj.common.ErrorCode;
import com.treay.swingoj.exception.BusinessException;
import com.treay.swingoj.judge.service.JudgeService;
import com.treay.swingoj.model.entity.QuestionSubmit;
import com.treay.swingoj.service.QuestionService;
import com.treay.swingoj.service.QuestionSubmitService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @auther Treay_kz
 * @Date 2024/8/1 20:50
 */
@Component
@Slf4j
public class MessageConsumer {

    @Resource
    private JudgeService judgeService;


    @Resource
    private QuestionSubmitService questionSubmitService;
    // 指定程序监听的消息队列和确认机制
    @SneakyThrows
    @RabbitListener(queues = {"code_queue"}, ackMode = "MANUAL")
    public void receiveMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) {
        log.info("收到消息 ： {}", message);
        long questionSubmitId = Long.parseLong(message);

        if (message == null) {
            channel.basicNack(deliveryTag,false,false);
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"消息为空");
        }
        try {
            judgeService.doJudge(questionSubmitId);
            QuestionSubmit questionSubmit = questionSubmitService.getById(questionSubmitId);
            channel.basicAck(deliveryTag, false);
        } catch (Exception e){
            channel.basicNack(deliveryTag,false,false);
            // todo 重试机制
        }

    }
}
