package com.model;

import com.helper.Util;

import java.util.Date;
import java.util.List;


public class Invoice {
    private final Address pAddress;
    private final Address bAddress;
    private final int orderIdNumber;
    private final int customerId;
    private final String customerName;
    private final String phoneNumber;
    private final List<Item> Items;
    private final Date date;



    public Invoice(Address pAddress, Address bAddress, int orderIdNumber, int customerId, String customerName, String phoneNumber, List<Item> Items, Date date) {
        this.pAddress = pAddress;
        this.bAddress = bAddress;
        this.orderIdNumber = orderIdNumber;
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.Items = Items;
        this.date = date;
    }

    public void generateBill() {
        System.out.println("\n----------------------------------INVOICE DETAILS--------------------------------");
        System.out.println("Customer Name            :" + customerName);
        System.out.println("Customer MobileNumber    :" + phoneNumber);
        System.out.println("CustomerId               :" + customerId);
        System.out.println("OrderID                  :" + orderIdNumber);
        System.out.println("Booking  Date            :" + date);
        System.out.println("Billing Address           " + bAddress);
        System.out.print("Delivery Address            " + pAddress);

        Util.displayCart(Items);
        System.out.println("NOTE: Pls note the Order ID for future Cancellation ");
        System.out.println("--------------------------------------------------------------------------------------");


    }

}
