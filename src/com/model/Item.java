package com.model;

public class Item {
    private final Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void addQuantity(int count)
    {
        quantity+=count;
    }
    public void removeQuantity(int count)
    {
        quantity-=count;
    }
}
