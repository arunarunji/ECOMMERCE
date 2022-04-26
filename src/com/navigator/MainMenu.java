package com.navigator;


import com.dataHandler.*;
import com.executor.CategoryMenuExecutor;
import com.executor.Execute;

import static com.navigator.SignInPageNavigator.isRunning;
import static com.helper.Util.inValidInt;

import com.model.Category;
import com.model.Menu;
import com.helper.Util;


import java.util.Scanner;


public class MainMenu implements Navigator {
    private final CategoryHandle categoryHandle = CategoryHandler.getInstance();
    private final Scanner in = new Scanner(System.in);
    private final int customerId;
    private final ProductHandle productHandle = ProductHandler.getInstance();


    public MainMenu(int customerId) {
        this.customerId = customerId;

    }


    @Override
    public void navigate() {
        while (isRunning()) {
            final Menu menu = new Menu("Main-Menu Options", MenuHandler.getInstance().getStartingMenuOption());
            {
                switch (menu.getChoice()) {
                    case 1:
                        Util.displayProduct(productHandle.getProductData());
                        final Navigator navigator = new CustomerOptionNavigator(customerId);
                        navigator.navigate();
                        break;
                    case 2:
                        Util.displayCategory(categoryHandle.getCategoriesList());
                        System.out.println("Enter your choice by Entering the Specific ID");
                        int choice1 = Integer.parseInt(in.nextLine().trim());
                        int res = validateChoice1(choice1);
                        if (res != -1) {
                            final Execute e = new CategoryMenuExecutor(customerId, res);
                            e.execute();
                        } else
                            inValidInt();
                    case 3:
                        final Navigator n1 = new CustomerOptionNavigator(customerId);
                        n1.navigate();
                        break;

                }
            }
        }

    }

    private int validateChoice1(int choice1) {


        for (Category category : categoryHandle.getCategoriesList()) {
            if (category.getCategoryId() == choice1) {
                return category.getCategoryId();

            }
        }
        return -1;
    }


}



