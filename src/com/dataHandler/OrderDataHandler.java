package com.dataHandler;

import com.dataBase.OrderDataBase;

import com.dataBase.OrderedDataDb;
import com.model.Order;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderDataHandler implements OrderHandler {
    private static OrderDataHandler ORDER_DATA_HANDLER = null;
    private final OrderDataBase odm = OrderedDataDb.getInstance();

    private OrderDataHandler() {

    }

    public static OrderDataHandler getInstance() {
        if (ORDER_DATA_HANDLER == null) ORDER_DATA_HANDLER = new OrderDataHandler();

        return ORDER_DATA_HANDLER;
    }

    @Override
    public HashMap<Integer, ArrayList<Order>> getOrderedData() {
        return odm.getOrderedData();

    }

    @Override
    public boolean setOrderData(int customerId, Order order) {
        boolean flag = false;
        if (ORDER_DATA_HANDLER.getOrderedData().putIfAbsent(customerId, new ArrayList<Order>() {{
            add(order);
        }}) != null) {
            ORDER_DATA_HANDLER.getOrderedData().get(customerId).add(order);
            flag = true;
        }
        return flag;
    }

    @Override
    public ArrayList<Order> getOrderDataArraylist(int customerId) {
        if (ORDER_DATA_HANDLER.getOrderedData().containsKey(customerId))
            return ORDER_DATA_HANDLER.getOrderedData().get(customerId);
        return null;
    }


}
