package com.executor;

import com.navigator.Navigator;
import com.navigator.SignInPageNavigator;

import static com.helper.Util.inValidInt;

import com.navigator.WelcomePageNavigator;

public class WelcomePageExecutor implements Execute {
    private static boolean run = false;
    private final int choice;

    public WelcomePageExecutor(int choice) {
        this.choice = choice;
        run = true;
    }

    public static boolean isRun() {

        return run;
    }

    public static void setRun(boolean run) {

        WelcomePageExecutor.run = run;
    }

    @Override
    public void execute() {
        switch (choice) {

            case 1: {
                final Navigator navigator = new SignInPageNavigator();
                navigator.navigate();
                break;
            }
            case 2: {
                WelcomePageNavigator.setStartRun(false);
                System.out.println("Thank you for using the application , Have a Nice day :)!!");
                break;
            }
            default:
                inValidInt();


        }
    }
}
