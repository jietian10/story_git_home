package com.hfxt.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public final static String QUEUE_NAME = "testQueue";

    @Bean
    public Queue testQueue1(){
        return new Queue(QUEUE_NAME);
    }
}
