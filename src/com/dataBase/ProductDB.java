package com.dataBase;


import com.model.Product;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductDB implements ProductDatabase {
    private static ProductDB PRODUCT_DB = null;
    private final HashMap<Integer, Integer> discount = new HashMap<Integer, Integer>() {
        {
            put(2001, 10);
            put(1002, 25);
            put(1006, 50);
            put(1004, 5);

        }
    };

    public static ProductDB getInstance() {

        if (PRODUCT_DB == null)
            PRODUCT_DB = new ProductDB();
        return PRODUCT_DB;
    }

    private ProductDB() {
        setDiscount();
    }

    private final ArrayList<Product> productData = new ArrayList<Product>() {
        {
            //mobiles
            add(new Product(1000, "      Mobile    ", "Mi        ", 5400));
            add(new Product(1001, "      Mobile    ", "OnePlus   ", 4500));
            add(new Product(1002, "      Mobile    ", "Redmi     ", 3500));
            add(new Product(1003, "      Mobile    ", "Oppo      ", 6500));
            add(new Product(1004, "      Mobile    ", "Apple     ", 6500));
            add(new Product(1005, "      Mobile    ", "Honour    ", 8500));
            add(new Product(1006, "      Mobile    ", "Samsung   ", 9500));
            add(new Product(1007, "      Mobile    ", "Nokia     ", 9000));
            // Laptops
            add(new Product(2000, "      Laptop    ", "Acer      ", 25000));
            add(new Product(2001, "      Laptop    ", "HP        ", 35000));
            add(new Product(2002, "      Laptop    ", "ChromeBook", 55000));
            add(new Product(2003, "      Laptop    ", "Dell      ", 45000));
            // HeadPhones
            add(new Product(2005, "      HeadPhones", "Mi        ", 600));
            add(new Product(2006, "      HeadPhones", "Boat      ", 2000));
            add(new Product(2007, "      HeadPhones", "RealMe    ", 700));
            add(new Product(2009, "      HeadPhones", "Sony      ", 500));

            //Camera
            add(new Product(2100, "      Camera    ", "Canon     ", 60000));
            add(new Product(2101, "      Camera    ", "Sony      ", 20000));
            add(new Product(2102, "      Camera    ", "Nikon     ", 70000));
            add(new Product(2103, "      Camera    ", "GoPro     ", 50000));

            add(new Product(3000, "Child Books", "Chetan Bhagat ", 500));
            add(new Product(3001, "Child Books", "Chetan Bhagat ", 500));
            add(new Product(3002, "Child Books", "Chetan Bhagat ", 500));
            add(new Product(3003, "Child Books", "Chetan Bhagat ", 500));
            add(new Product(3004, "Child Books", "Chetan Bhagat ", 500));
            add(new Product(3100, "Novel Book", "RoleHim", 600));
            add(new Product(3102, "Journal Book", "IEEE", 800));

        }
    };


    public ArrayList<Product> getProductData() {
        return productData;
    }


    public void setProduct(Product product) {
        productData.add(product);
    }


    public void addDiscount(int id, int discountVal) {
        discount.put(id, discountVal);
    }

    public void updateDiscount(int id, int discountVal) {
        discount.replace(id, discountVal);
    }

    public void removeDiscount(int id) {
        discount.remove(id);
    }

    private void setDiscount() {

        for (Product product : productData)
            for (Integer key : discount.keySet()) {
                if (product.getProductId() == key) product.setDiscount(discount.get(key));
            }

    }


}
