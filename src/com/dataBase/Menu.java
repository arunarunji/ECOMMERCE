package com.dataBase;


import java.util.Map;

public interface Menu {

    Map<Integer, String> adminOption();
    Map<Integer, String> getWelcomePage();
    Map<Integer, String> getSignPage();
    Map<Integer, String> getStartingMenuOption();
    Map<Integer, String> getCustomerOption();
    Map<Integer, String> getPlaceOrder();


}
