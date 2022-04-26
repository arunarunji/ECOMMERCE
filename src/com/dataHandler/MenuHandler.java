package com.dataHandler;

import com.dataBase.Menu;
import com.dataBase.MenuDB;

import java.util.Map;

public class MenuHandler implements MenuIHandler {
    private static  MenuIHandler MENU_HANDLER ;
    private final Menu menu = MenuDB.getInstance();

    private MenuHandler() {

    }

    public static MenuIHandler getInstance() {
        if(MENU_HANDLER==null)
            MENU_HANDLER = new MenuHandler();
        return MENU_HANDLER;
    }

    @Override
    public Map<Integer, String> adminOption() {
        return menu.adminOption();
    }

    @Override
    public Map<Integer, String> getWelcomePage() {
        return menu.getWelcomePage();
    }

    @Override
    public Map<Integer, String> getSignPage() {
        return menu.getSignPage();
    }

    @Override
    public Map<Integer, String> getStartingMenuOption() {
        return menu.getStartingMenuOption();
    }

    @Override
    public Map<Integer, String> getCustomerOption() {
        return menu.getCustomerOption();
    }

    @Override
    public Map<Integer, String> getPlaceOrder() {
        return menu.getPlaceOrder();
    }
}
