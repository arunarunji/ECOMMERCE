package com.navigator;

import com.dataHandler.MenuHandler;
import com.executor.Execute;
import com.executor.SignInPageExecutor;
import com.executor.WelcomePageExecutor;
import com.model.Menu;

import static com.executor.WelcomePageExecutor.isRun;
import static com.helper.Util.inValidInt;

public class SignInPageNavigator implements Navigator {
    private static boolean running = true;


    public static boolean isRunning() {

        return running;
    }

    public static void setRunning(boolean run) {

        running = run;
    }


    public SignInPageNavigator() {
        WelcomePageExecutor.setRun(true);
        running = true;
    }

    @Override
    public void navigate() {
        while (isRun()) {
            final Menu menu = new Menu("SIGNUP PAGE", MenuHandler.getInstance().getSignPage());
            int result = menu.getChoice();
            if (result != -1) {
                final Execute e = new SignInPageExecutor(result);
                e.execute();
            } else
                inValidInt();


        }
    }

}
