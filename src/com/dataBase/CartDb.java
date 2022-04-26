package com.dataBase;

import com.model.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartDb implements CartDataBase {
    private static CartDb CART_DB=null;
    private final Map<Integer, List<Item>> customerCart = new HashMap<>();

    private CartDb() {

    }

    public static CartDb getInstance() {

        if(CART_DB==null)
            CART_DB = new CartDb();
        return CART_DB;
    }

    public Map<Integer, List<Item>> getCustomerCart() {
        return customerCart;
    }
}
