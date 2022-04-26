package com.dataBase;

import com.model.Item;

import java.util.List;
import java.util.Map;

public interface CartDataBase {
    Map<Integer, List<Item>> getCustomerCart();
}
