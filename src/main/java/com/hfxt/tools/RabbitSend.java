package com.hfxt.tools;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class RabbitSend {

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(Object data){
        Object str=new Date() + "消息队列<= "+data;
        System.out.println(str);
        amqpTemplate.convertAndSend("testQueue" , str);
    }
}
