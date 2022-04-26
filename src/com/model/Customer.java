package com.model;

import static com.helper.Util.generateID;

public class Customer extends User {

    private final String customerName;
    private final int customerId;
    private final Address customerAddress;
    private final String customerPhNumber;

    public Customer(String userMailId, String userPassword, String customerName, Address customerAddress, String customerPhNumber) {
        super(userMailId, userPassword, "Customer");
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhNumber = customerPhNumber;
        this.customerId = generateID();
    }

    public String getCustomerName() {
        return customerName;
    }


    public Address getCustomerAddress() {
        return customerAddress;
    }


    public String getCustomerPhNumber() {
        return customerPhNumber;
    }


    public int getCustomerId() {
        return customerId;
    }
}
