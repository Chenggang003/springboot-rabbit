package com.springboot.rabbitmq.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chengang
 * @date: 2019/5/31
 * @description:
 */
@RestController
public class PaymentNotifySender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/sender")
    public void sender() {
        for (int i = 0; i < 100; i++) {
            amqpTemplate.convertAndSend("notify.payment","消息" + i);
        }
    }
}
