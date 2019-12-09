package com.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_transport")
public class Transport {
    /**
     * 订单id
     */
    @Id
    @Column(name = "order_id")
    private String orderId;

    /**
     * 快递小哥id
     */
    private String transporter;

    /**
     * 运单状态
     */
    @Column(name = "transport_staut")
    private Boolean transportStaut;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 订单详情
     */
    @Column(name = "order_context")
    private String orderContext;

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
     * 获取快递小哥id
     *
     * @return transporter - 快递小哥id
     */
    public String getTransporter() {
        return transporter;
    }

    /**
     * 设置快递小哥id
     *
     * @param transporter 快递小哥id
     */
    public void setTransporter(String transporter) {
        this.transporter = transporter == null ? null : transporter.trim();
    }

    /**
     * 获取运单状态
     *
     * @return transport_staut - 运单状态
     */
    public Boolean getTransportStaut() {
        return transportStaut;
    }

    /**
     * 设置运单状态
     *
     * @param transportStaut 运单状态
     */
    public void setTransportStaut(Boolean transportStaut) {
        this.transportStaut = transportStaut;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取订单详情
     *
     * @return order_context - 订单详情
     */
    public String getOrderContext() {
        return orderContext;
    }

    /**
     * 设置订单详情
     *
     * @param orderContext 订单详情
     */
    public void setOrderContext(String orderContext) {
        this.orderContext = orderContext == null ? null : orderContext.trim();
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