package com.dataBase;


import com.model.Order;

import java.util.ArrayList;

import java.util.HashMap;


  public class OrderedDataDb implements OrderDataBase {
    private  static OrderedDataDb ORDER_DATA = null;

    private final HashMap<Integer, ArrayList<Order>> orderedData = new HashMap<>();

    private OrderedDataDb() {

    }
    public static OrderedDataDb getInstance() {

        if(ORDER_DATA==null)
            ORDER_DATA = new OrderedDataDb();
        return ORDER_DATA;
    }


    public final HashMap<Integer, ArrayList<Order>> getOrderedData() {
        return orderedData;
    }


}
