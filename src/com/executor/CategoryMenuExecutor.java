package com.executor;


import com.dataHandler.CategoryHandle;
import com.dataHandler.CategoryHandler;
import com.dataHandler.ProductHandle;
import com.dataHandler.ProductHandler;
import com.model.Product;
import com.navigator.CustomerOptionNavigator;
import com.navigator.Navigator;
import com.helper.Util;

import java.util.ArrayList;


public class CategoryMenuExecutor implements Execute {
    private final int categoryId;
    private final int customerId;
    private final CategoryHandle categoryHandle = CategoryHandler.getInstance();
    private final ProductHandle productHandle = ProductHandler.getInstance();

    public CategoryMenuExecutor(int customerId, int categoryId) {
        this.customerId = customerId;
        this.categoryId = categoryId;
    }

    @Override
    public void execute() {
        Util.displayProduct(getProduct());
        final Navigator navigator = new CustomerOptionNavigator(customerId);
        navigator.navigate();
    }

    private ArrayList<Product> getProduct() {
        final ArrayList<Product> products = new ArrayList<>();
        for (int n : categoryHandle.getCategoryList(categoryId)) {
            products.add(productHandle.getProduct(n));
        }
        return products;
    }
}
