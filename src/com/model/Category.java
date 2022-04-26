package com.model;


import java.util.ArrayList;

import static com.helper.Util.CategoryID;

public class Category{
    private final String categoryName;
    private final ArrayList<Integer> products;
    private final int categoryId;

    public Category(String categoryName, ArrayList<Integer> products) {
        this.categoryName = categoryName;
        this.products = products;
        categoryId = CategoryID();
    }

    public ArrayList<Integer> getProducts() {
        return products;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addProduct(int id)
    {
        products.add(id);

    }
    public void removeProduct(int id)
    {
        products.remove(id);
    }
}
