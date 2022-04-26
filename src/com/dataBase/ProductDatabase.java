package com.dataBase;

import com.model.Product;

import java.util.ArrayList;
import java.util.HashMap;

public interface ProductDatabase {
    ArrayList<Product> getProductData();



    void setProduct(Product product);

    void updateDiscount(int id, int discountVal);

    void addDiscount(int id, int discountVal);

    void removeDiscount(int id);

}
