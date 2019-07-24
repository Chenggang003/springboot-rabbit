package com.springboot.rabbitmq.rabbitmq.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: chengang
 * @date: 2019/5/31
 * @description:
 */
@Component
@RabbitListener(queues = "notify.payment")
public class PaymentNotifyReceive {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("消费了消息：" + message);
    }

}
