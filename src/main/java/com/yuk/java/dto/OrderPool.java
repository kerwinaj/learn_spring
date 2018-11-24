package com.yuk.java.dto;

public class OrderPool {
    // 订单号
    private Long orderNo;

    //商品类型
    private Long categoryId;

    // 支付时间
    private Integer payTime;

    // 优先级
    private Integer priority;

    // 商品成交价
    public Double price;

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getPayTime() {
        return payTime;
    }

    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "orderNo:"+orderNo+",payTime:"+payTime+",priority:"+priority+",cid:"+categoryId+",price:"+price+"\n";
    }
}
