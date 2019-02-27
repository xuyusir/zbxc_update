package com.jy.entiy.order.shopping_cart;

import java.math.BigDecimal;

public class Shoppingcartitem {
    private Long cartitemid;

    private Long cartid;

    private Integer quainty;

    private BigDecimal unitprice;

    private Float discount;

    private Long productid;

    public Long getCartitemid() {
        return cartitemid;
    }

    public void setCartitemid(Long cartitemid) {
        this.cartitemid = cartitemid;
    }

    public Long getCartid() {
        return cartid;
    }

    public void setCartid(Long cartid) {
        this.cartid = cartid;
    }

    public Integer getQuainty() {
        return quainty;
    }

    public void setQuainty(Integer quainty) {
        this.quainty = quainty;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }
}