package com.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_order")
public class Order {
    /**
     * 订单id
     */
    @Id
    @Column(name = "order_id")
    private String orderId;

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

    /**
     * 订单价格
     */
    private BigDecimal price;

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
     * 获取订单价格
     *
     * @return price - 订单价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置订单价格
     *
     * @param price 订单价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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