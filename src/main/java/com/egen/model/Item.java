package com.egen.model;

import java.math.BigDecimal;

public class Item {
    private String itemName;
    private BigDecimal itemQty;
    private BigDecimal total;

    public Item(String itemName, BigDecimal itemQty, BigDecimal total) {
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.total = total;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemQty() {
        return itemQty;
    }

    public void setItemQty(BigDecimal itemQty) {
        this.itemQty = itemQty;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
