package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@MapperScan("com.dao")
@EntityScan(basePackages = {"com.entity"})
@ComponentScan(basePackages = {"com"})
@SpringBootApplication
public class TransportApplection {

    public static void main(String[] args) {
        SpringApplication.run(TransportApplection.class, args);
    }
}
