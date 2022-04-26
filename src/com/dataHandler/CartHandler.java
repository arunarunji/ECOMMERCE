package com.dataHandler;

import com.dataBase.CartDataBase;
import com.dataBase.CartDb;
import com.model.Item;

import java.util.List;

public class CartHandler implements CartIHandler {
    private static CartIHandler CART_HANDLER;
    private final CartDataBase cartDataBase = CartDb.getInstance();

    private CartHandler() {

    }

    public static CartIHandler getInstance() {

        if (CART_HANDLER == null)
            CART_HANDLER = new CartHandler();
        return CART_HANDLER;
    }

    public void addCartToList(int customerId, List<Item> item) {
        cartDataBase.getCustomerCart().put(customerId, item);
    }

    public List<Item> getCustomerCart(int customerId) {
        return cartDataBase.getCustomerCart().get(customerId);
    } }




