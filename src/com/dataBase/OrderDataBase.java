package com.dataBase;

import com.model.Order;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrderDataBase {
    HashMap<Integer, ArrayList<Order>> getOrderedData();


}
