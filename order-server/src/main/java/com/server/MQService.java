package com.server;

import com.entity.Order;

public interface MQService {
    public void sendMsg(Order order);
}
