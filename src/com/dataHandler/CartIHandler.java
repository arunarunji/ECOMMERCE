package com.dataHandler;

import com.model.Item;

import java.util.List;

public interface CartIHandler {

    void addCartToList(int customerId, List<Item> item);
    List<Item> getCustomerCart(int customerId);


}
