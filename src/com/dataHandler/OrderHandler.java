package com.dataHandler;

import com.model.Order;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrderHandler {
    HashMap<Integer, ArrayList<Order>> getOrderedData();
    boolean setOrderData(int customerId, Order order);
    ArrayList<Order> getOrderDataArraylist(int customerId);
}
