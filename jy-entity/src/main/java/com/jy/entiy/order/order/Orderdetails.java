package com.jy.entiy.order.order;

import java.math.BigDecimal;

public class Orderdetails {
    private Long orderdetailsid;

    private Long orderid;

    private Long productid;

    private BigDecimal unitprice;

    private Integer quantity;

    private Float discount;

    private String isdelete;

    private Integer orderstatusid;

    private Integer paystatusid;

    public Long getOrderdetailsid() {
        return orderdetailsid;
    }

    public void setOrderdetailsid(Long orderdetailsid) {
        this.orderdetailsid = orderdetailsid;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete == null ? null : isdelete.trim();
    }

    public Integer getOrderstatusid() {
        return orderstatusid;
    }

    public void setOrderstatusid(Integer orderstatusid) {
        this.orderstatusid = orderstatusid;
    }

    public Integer getPaystatusid() {
        return paystatusid;
    }

    public void setPaystatusid(Integer paystatusid) {
        this.paystatusid = paystatusid;
    }
}