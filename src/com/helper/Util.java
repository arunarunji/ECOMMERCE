package com.helper;


import com.dataHandler.LoginHandle;
import com.dataHandler.LoginHandler;
import com.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Util {


    private static final Scanner in = new Scanner(System.in);

    public static void displayProduct(List<Product> productData) {

        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("ProductId        ProductName    BrandName        Price         Discount     DiscountedPrice");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        for (Product product : productData)
            if (product.getDiscount() > 0)
                System.out.println(product.getProductId() + "          " + product.getProductName() + "      " + product.getBrandName() + "              " + product.getPrice() + "               " + product.getDiscount() + "        " + (product.getPrice() - (product.getPrice() * product.getDiscount()) / 100));
            else
                System.out.println(product.getProductId() + "         " + product.getProductName() + "      " + product.getBrandName() + "              " + product.getPrice() + "               " + "-  " + "        " + product.getPrice());

    }

    public static void displayCart(List<Item> Items) {
        int totalAmount = 0;
        System.out.println("\n------------------------------------------------------------------------------------------------------------------ ");
        System.out.println("ProductId   ProductName   ProductQuantity    BrandName   OriginalPrice  Discount  DiscountedPrice    TotalAmount ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        for (Item item : Items) {
            if (item.getProduct().getDiscount() > 0) {
                System.out.println(item.getProduct().getProductId() + "    " + item.getProduct().getProductName() + "         " + item.getQuantity() + "              " + item.getProduct().getBrandName() + "     " + item.getProduct().getPrice() + "         " + item.getProduct().getDiscount() + "           " + (item.getProduct().getPrice() - (item.getProduct().getPrice() * item.getProduct().getDiscount() / 100)) + "          " + (item.getProduct().getPrice() - (item.getProduct().getPrice() * item.getProduct().getDiscount() / 100)) * item.getQuantity());
                totalAmount += (item.getProduct().getPrice() - (item.getProduct().getPrice() * item.getProduct().getDiscount() / 100)) * item.getQuantity();
            } else {
                System.out.println(item.getProduct().getProductId() + "        " + item.getProduct().getProductName() + "         " + item.getQuantity() + "               " + item.getProduct().getBrandName() + "     " + item.getProduct().getPrice() + "      " + "        -                    " + item.getProduct().getPrice() + "         " + item.getQuantity() * item.getProduct().getPrice());
                totalAmount += item.getProduct().getPrice() * item.getQuantity();
            }
        }
        System.out.println("---------------------------------------------------");
        System.out.println("|TOTAL Amount                     :" + totalAmount);
        System.out.println("---------------------------------------------------");


    }

    public static void generateInvoice(int customerId, int orderId, List<Item> orderedProducts, Date date) {

        final LoginHandle loginHandle = LoginHandler.getInstance();
        final Customer customer = (Customer) loginHandle.getCustomerObj(customerId);
        final Invoice invoice = new Invoice(customer.getCustomerAddress(), customer.getCustomerAddress(), orderId, customerId, customer.getCustomerName(), customer.getCustomerPhNumber(), orderedProducts, date);
        invoice.generateBill();
    }

    public static void displayCategory(ArrayList<Category> categories) {
        System.out.println("\t\t\t\t---------- Categories---------");
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.println("    CategoryID              CategoryName ");
        System.out.println("-------------------------------------------------------------");
        for (Category category : categories) {
            System.out.println("      " + category.getCategoryId() + "                    " + category.getCategoryName());
        }
    }


    public static int getInteger() {
        int n;
        try {
            n = Integer.parseInt(in.nextLine().trim());

        } catch (NumberFormatException e) {

            return -1;
        }
        return n;
    }

    public static void inValidInt() {
        System.out.println("Enter the Valid Choice ,Pls Enter Between the Range  ");
    }

    public static void inValid(String name) {
        System.out.println("Enter the Valid " + name);
    }

    public static int getIntegerAndDisplayMessage(String Name, String message) {
        int n;
        System.out.println("Enter the  " + message);
        try {
            n = Integer.parseInt(in.nextLine().trim());

        } catch (NumberFormatException e) {
            System.out.println("Enter the Valid " + Name);
            return -1;
        }
        return n;
    }

    public static boolean validatePhone(String phone) {
        /*
        (0/91): number starts with (0/91)
        [6-9]: starting of the number may contain a digit between 6 and 9
        [0-9]: then contains digits 0 to 9
         */
        final String phonePattern = "(0/91)?[6-9][0-9]{9}";
        return !Pattern.compile(phonePattern).matcher(phone).matches();
    }


    public static boolean validateName(String name) {
        return name.isEmpty();

    }


    public static boolean validateEmail(String email) {
        final String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return !Pattern.compile(emailPattern).matcher(email).matches();
    }

    public static boolean validatePassword(String password) {
        /*
        Password must contain at least one digit [0-9].
        Password must contain at least one lowercase character [a-z].
        Password must contain at least one uppercase character [A-Z].
        Password must contain at least one special character like ! @ # & ( ).
        Password must contain a length of at least 8 characters and a maximum of 20 characters.
         */
        final String passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        return !Pattern.compile(passwordPattern).matcher(password).matches();
    }

    private final static ArrayList<Integer> randomNumbers = new ArrayList<>();

    public static int generateID() {
        int id = (int) (Math.random() * 9000) + 1000;
        for (int n : randomNumbers) {
            if (n == id)
                id = generateID();
            else
                randomNumbers.add(id);
        }

        return id;
    }

    public static int orderID() {
        int id = (int) (Math.random() * 900000) + 100000;
        for (int n : randomNumbers) {
            if (n == id)
                id = generateID();
            else
                randomNumbers.add(id);
        }

        return id;
    }

    public static int CategoryID() {
        int id = (int) (Math.random() * 90) + 10;
        for (int n : randomNumbers) {
            if (n == id)
                id = generateID();
            else
                randomNumbers.add(id);
        }

        return id;
    }

}