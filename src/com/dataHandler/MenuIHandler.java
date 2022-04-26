package com.dataHandler;

import java.util.Map;

public interface MenuIHandler {
    Map<Integer, String> adminOption();
    Map<Integer, String> getWelcomePage();
    Map<Integer, String> getSignPage();
    Map<Integer, String> getStartingMenuOption();
    Map<Integer, String> getCustomerOption();
    Map<Integer, String> getPlaceOrder();
}
