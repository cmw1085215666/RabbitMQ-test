package com.server.impl;

import com.dao.MpTempMapper;
import com.dao.OrderMapper;
import com.entity.MpTemp;
import com.entity.Order;
import com.server.MQService;
import com.server.OrderServier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderServier {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private MpTempMapper mpTempMapper;

    @Autowired
    private MQService mqService;

    @Override
    public void createOrder(Order order) {
        createOrderServer(order);

        //向运单系统发送mp消息
        mqService.sendMsg(order);

    }

    @Transactional
    //这里为独立的事务有订单就要有相应的消息
    public void createOrderServer(Order order) {
        //这里创建订单
        orderMapper.insertSelective(order);
        //同时保存mp临时表
        MpTemp mpTemp = new MpTemp();
        mpTemp.setOrderId(order.getOrderId());
        mpTempMapper.insertSelective(mpTemp);
    }
}
