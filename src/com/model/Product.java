package com.model;


public class Product {

    private final int productId;
    private final  String productName;
    private final String brandName;
    private int discount;
    private int price;


    public void setPrice(int price) {
        this.price = price;
    }




    public Product(int productId, String productName, String brandName, int price) {
        this.productId = productId;
        this.productName = productName;
        this.brandName = brandName;
        this.price = price;
        this.discount = 0;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getPrice() {
        return price;
    }



}
