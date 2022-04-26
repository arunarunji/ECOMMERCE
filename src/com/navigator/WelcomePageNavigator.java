package com.navigator;


import com.dataHandler.MenuHandler;
import com.executor.Execute;
import com.executor.WelcomePageExecutor;
import com.model.Menu;

import static com.helper.Util.inValidInt;

public class WelcomePageNavigator implements Navigator {

    private static boolean startRun = true;

    public WelcomePageNavigator() {
        startRun = true;
    }

    public static void setStartRun(boolean start) {

        startRun = start;
    }

    @Override
    public void navigate() {
        System.out.println("\t\t---------------- Welcome to EBuy ECOMMERCE.in-------------");

        while (startRun) {
            final Menu menu = new Menu("HOME PAGE MENU ", MenuHandler.getInstance().getWelcomePage());
            final int result = menu.getChoice();
            if (result != -1) {
                final Execute executor = new WelcomePageExecutor(result);
                executor.execute();
            } else
                inValidInt();
        }
    }


}
