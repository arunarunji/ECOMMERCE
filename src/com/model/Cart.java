package com.model;


import com.dataHandler.CartHandler;
import com.dataHandler.CartIHandler;
import com.dataHandler.ProductHandle;
import com.dataHandler.ProductHandler;


import java.util.ArrayList;
import java.util.List;


public class Cart {

    private final int customerId;
    private List<Item> itemList;
    private final CartIHandler cartIHandler = CartHandler.getInstance();

    public Cart(int customerId) {
        this.customerId = customerId;
        generateCart();

    }

    public void generateCart() {

        itemList = cartIHandler.getCustomerCart(customerId);
        if (itemList == null)
            itemList = new ArrayList<>();

    }


    public void updateCart(int productID, int count) {
        final ProductHandle productHandle = ProductHandler.getInstance();
        if (!productHandle.checkProductExist(productID, itemList)) {
            getItemList().add(new Item(productHandle.getProduct(productID), count));

        } else {
            Item item = getItem(productID);
            if (item != null) {
                item.addQuantity(count);

            }
        }

        System.out.println("Products is added Successfully to the Cart");
    }


    private Item getItem(int productId) {
        final ProductHandle productHandle = ProductHandler.getInstance();
        for (Item i : itemList) {
            if (i.getProduct().equals(productHandle.getProduct(productId)))
                return i;
        }
        return null;
    }


    public boolean removeProducts(int productId, int count) {
        boolean flag = false;
        Item item = getItem(productId);
        if (item != null) {
            if (item.getQuantity() >= count) {
                item.removeQuantity(count);
                flag = true;
            } else {
                System.out.println("the Quantity Entered is more the Product Quantity available in the Cart");
            }
        }
        return flag;
    }

    public void removeAllProducts() {
        itemList.clear();

    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
