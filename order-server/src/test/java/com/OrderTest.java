package com;

import com.dao.OrderMapper;
import com.entity.Order;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.server.OrderServier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import static org.springframework.amqp.rabbit.core.RabbitAdmin.QUEUE_NAME;

@RunWith(SpringRunner.class) //作用：让当前类在容器环境下进行测试
//作用：声明当前类是springboot的测试类并且获取入口类上的相关信息
@SpringBootTest(classes = OrderApplection.class)
public class OrderTest {
    private final static String QUEUE_NAME = "hello";
    @Autowired
    private OrderServier orderServier;

    @Test
    public void createOrder() throws Exception {

        Order order = new Order();
        order.setOrderContext("测试订单01");
        order.setPrice(BigDecimal.ONE);
        order.setOrderId(UUID.randomUUID().toString());
        order.setUserId(UUID.randomUUID().toString());

        orderServier.createOrder(order);

    }

}
