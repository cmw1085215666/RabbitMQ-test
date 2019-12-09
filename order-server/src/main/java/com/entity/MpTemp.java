package com.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_mq_temp")
public class MpTemp {
    /**
     * 订单id
     */
    @Id
    @Column(name = "order_id")
    private String orderId;

    /**
     * 发送状态状态
     */
    @Column(name = "sent_status")
    private Boolean sentStatus;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取订单id
     *
     * @return order_id - 订单id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 设置订单id
     *
     * @param orderId 订单id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 获取发送状态状态
     *
     * @return sent_status - 发送状态状态
     */
    public Boolean getSentStatus() {
        return sentStatus;
    }

    /**
     * 设置发送状态状态
     *
     * @param sentStatus 发送状态状态
     */
    public void setSentStatus(Boolean sentStatus) {
        this.sentStatus = sentStatus;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}