package com.navigator;


import com.dataHandler.MenuHandler;
import com.executor.CustomerOptionExceutor;
import com.executor.Execute;
import com.model.Cart;
import com.model.Menu;

import static com.helper.Util.inValidInt;


public class CustomerOptionNavigator implements Navigator {
    private final int customerId;
    private static boolean res = true;
    public static boolean isRes() {
        return res;
    }

    public static void setRes(boolean res) {
        CustomerOptionNavigator.res = res;
    }

    public CustomerOptionNavigator(int customerId) {
        this.customerId = customerId;
        res = true;
    }

    @Override
    public void navigate() {
        final Cart cart = new Cart(customerId);
        while (isRes()) {

            final Menu menu = new Menu("CART AND ORDER MENU OPTION", MenuHandler.getInstance().getCustomerOption());
            final int choice = menu.getChoice();


            if (choice != -1) {

                final Execute executor = new CustomerOptionExceutor(choice, customerId, cart);
                executor.execute();
            } else
                inValidInt();
        }
    }

}
