package com.springboot.rabbitmq.controller;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author: chengang
 * @date: 2019/5/31
 * @description:
 */
@Component
@RabbitListener(queues = "notify.payment")
public class PaymentNotifyReceive {

    @RabbitHandler
    public void receive(String message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        System.out.println("消费了消息：" + message);

        // 手动ack
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // 手动签收
        channel.basicAck(deliveryTag, false);
    }
}
