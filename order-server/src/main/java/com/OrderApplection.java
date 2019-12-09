package com;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.StandardContext;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@MapperScan("com.dao")
@EntityScan(basePackages = {"com.entity"})
@ComponentScan(basePackages = {"com"})
@SpringBootApplication
public class OrderApplection {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplection.class, args);
    }

    @Bean
    public Queue ctreatQueue(){
        return new Queue("orderQueue");
    }

}
