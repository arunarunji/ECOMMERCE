package com.dataBase;

import java.util.HashMap;
import java.util.Map;

public class MenuDB implements Menu {
    private static MenuDB MENU_DB=null;

    private MenuDB() {

    }

    public static MenuDB getInstance() {

        if(MENU_DB==null)
            MENU_DB = new MenuDB();
        return MENU_DB;
    }

    private final Map<Integer, String> welcomePage = new HashMap<Integer, String>() {
        {
            put(1, "Go to Login");
            put(2, "Quit Application");
        }

    };
    private final Map<Integer, String> signPage = new HashMap<Integer, String>() {
        {
            put(1, "New to EBuy? Create a new Account");
            put(2, "SIGN-IN");
        }
    };
    private final Map<Integer, String> startingMenuOption = new HashMap<Integer, String>() {
        {
            put(1, "View All Products");
            put(2, "View Specific Category Products");
            put(3, "Go To Cart Option");

        }
    };
    private final Map<Integer, String> customerOption = new HashMap<Integer, String>() {
        {
            put(1, "Add To Cart");
            put(2, "View Cart Products");
            put(3, "Remove Products From Cart");
            put(4, "Remove all Products from Cart");
            put(5, "Place Order ");
            put(6, "View Order History ");
            put(7, "Cancel Order");
            put(8, "Exit");

        }
    };
    private final Map<Integer, String> adminOption = new HashMap<Integer, String>() {
        {
            put(1, "ADD NEW PRODUCT");
            put(2, "REMOVE EXISTING PRODUCT");
            put(3, "UPDATE THE EXISTING PRODUCT");
            put(4, "UPDATE DISCOUNT TO PRODUCT");
            put(5, "ADD DISCOUNT TO PRODUCTS ");
            put(6, "REMOVE DISCOUNT ");
            put(7, "ADD NEW CATEGORY");
            put(8,"View Products");
            put(9, "EXIT");

        }
    };
    private final Map<Integer, String> placeOrder = new HashMap<Integer, String>() {
        {
            put(1, "PLACE ORDER ALL PRODUCTS");
            put(2, "SELECT SPECIFIC PRODUCTS");

        }
    };

    public Map<Integer, String> adminOption() {
        return adminOption;
    }

    public Map<Integer, String> getWelcomePage() {
        return welcomePage;
    }

    public Map<Integer, String> getSignPage() {
        return signPage;
    }

    public Map<Integer, String> getStartingMenuOption() {
        return startingMenuOption;
    }

    public Map<Integer, String> getCustomerOption() {
        return customerOption;
    }

    public Map<Integer, String> getPlaceOrder() {
        return placeOrder;
    }

}
