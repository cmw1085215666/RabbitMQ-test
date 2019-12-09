package com.server.impl;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import com.server.TransportService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class TransportServiceImpl implements TransportService {

    @RabbitListener(queues = "orderQueue")
    public void messageCustomer(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws Exception {

        try {
            System.out.println("运单系统处理消息："+message);
            JSONObject orderInfo = JSONObject.parseObject(message);
            // 创建一条运单数据 处理消息时注意消息可能重发，注意幂等性/去重

            String orderId = orderInfo.getString("orderId");

            //此处神略业务代码。。。。。。


            //确认消息已经消费
            channel.basicAck(tag,false);
        }catch (Exception e){
            e.printStackTrace();
            //异常处理----根据不同的异常让MQ重发或者不处理
//            channel.basicNack(tag,false,true);//让MQ重发
            channel.basicNack(tag,false,false);//不用MQ重发了，直接丢弃（死信队列），可以做一些人工处理，系统预警 监控
        }

    }

}
