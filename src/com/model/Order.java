package com.model;


import com.helper.Util;

import java.util.Date;
import java.util.List;

import static com.helper.Util.orderID;

public class Order {

    private final int orderId;
    private final int customerId;
    private final List<Item> itemList;
    private final Date date = new Date();


    public Order(int customerId, List<Item> cartProduct) {
        this.customerId = customerId;
        this.orderId = orderID();
        itemList = cartProduct;

    }


    public Date getDate() {
        return date;
    }

    public int getOrderId() {
        return orderId;
    }


    public List<Item> getItemList() {
        return itemList;
    }

    public void generateInvoice() {
        Util.generateInvoice(customerId, orderId, itemList, date);
    }

}

