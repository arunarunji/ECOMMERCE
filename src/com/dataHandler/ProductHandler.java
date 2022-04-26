package com.dataHandler;

import com.dataBase.ProductDB;
import com.dataBase.ProductDatabase;
import com.model.Item;
import com.model.Product;

import java.util.ArrayList;

import java.util.List;

public class ProductHandler implements ProductHandle {
    private static ProductHandle PRODUCT_HANDLER;
    private final ProductDatabase pdb = ProductDB.getInstance();

    private ProductHandler() {

    }

    public static ProductHandle getInstance() {

        if (PRODUCT_HANDLER == null)
            PRODUCT_HANDLER = new ProductHandler();

        return PRODUCT_HANDLER;
    }

    @Override
    public ArrayList<Product> getProductData() {
        return pdb.getProductData();
    }


    @Override
    public void setProduct(Product product) {
        pdb.setProduct(product);
    }


    @Override
    public void updateDiscount(int id, int discountVal) {
        pdb.updateDiscount(id, discountVal);
    }

    @Override
    public void addDiscount(int id, int discountVal) {
        pdb.addDiscount(id, discountVal);
    }

    @Override
    public void removeDiscount(int id) {
        pdb.removeDiscount(id);
    }

    @Override

    public boolean checkProductExist(int productId, List<Item> itemList) {

        for (Item i : itemList) {
            return i.getProduct().equals(PRODUCT_HANDLER.getProduct(productId));
        }
        return false;
    }

    @Override
    public boolean checkProductIdExist(int productId) {
        for (Product product : PRODUCT_HANDLER.getProductData()) {
            if (product.getProductId() == productId)
                return true;

        }
        return false;
    }

    @Override
    public Product getProduct(int productId) {
        for (Product product : PRODUCT_HANDLER.getProductData()) {
            if (product.getProductId() == productId)
                return product;
        }
        return null;
    }

    @Override
    public void removeProduct(int id) {
        PRODUCT_HANDLER.getProductData().remove(getProduct(id));
    }

}
