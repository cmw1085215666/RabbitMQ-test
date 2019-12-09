package com.server.impl;

import com.alibaba.fastjson.JSON;
import com.dao.MpTempMapper;
import com.entity.Order;
import com.server.MQService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MQServiceImpl implements MQService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MpTempMapper mpTempMapper;

    @PostConstruct
    public void setup(){
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String s) {

                System.out.println("收到mq的回调：" + correlationData +";ack: "+ack+"; s:"+s);
                if (!ack){
                    return;
                }

                try {
                    //修改状态为已发送，注意：这个逻辑如果因为服务器异常情况执行失败了，可以写一个定时任务重新发送消息
                    int count = mpTempMapper.updateStatus(correlationData.getId());

                    if (count != 1){
                        System.out.println("警告：修改本地消息表状态失败");
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("警告：修改本地消息表状态出现异常");
                }

            }
        });
    }

    @Override
    public void sendMsg(Order order){
        rabbitTemplate.convertAndSend("","orderQueue",JSON.toJSONString(order),
                new CorrelationData(order.getOrderId()));
    }

}
