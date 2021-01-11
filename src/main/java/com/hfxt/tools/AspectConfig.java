package com.hfxt.tools;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class AspectConfig {

    @Bean
    public MyAdvice myAdviceAspect() {
        return new MyAdvice();
    }
}

