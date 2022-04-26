package com.dataHandler;

import com.model.Item;
import com.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ProductHandle {
    ArrayList<Product> getProductData();
    Product getProduct(int productId);
    void setProduct(Product product);
    void removeProduct(int id);
    void updateDiscount(int id,int discountVal);
    void addDiscount(int id, int discountVal);
    void removeDiscount(int id);
    boolean checkProductIdExist(int productId);

    boolean checkProductExist(int productID, List<Item> itemList);
}
