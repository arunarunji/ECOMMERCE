package com.mainClass;

import com.navigator.Navigator;
import com.navigator.WelcomePageNavigator;

public class Main {
    public static void main(String[] args) {
        final Navigator welcome = new WelcomePageNavigator();
        welcome.navigate();
    }
}
