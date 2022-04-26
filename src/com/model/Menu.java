package com.model;


import com.helper.Util;

import java.util.Map;

public class Menu {
    private final String header;
    private final Map<Integer, String> options;

    public Menu(String header, Map<Integer, String> options) {
        this.header = header;
        this.options = options;
    }

    public int getChoice() {

        System.out.println();
        System.out.println();
        System.out.println("\t\t----------------------" + header + "--------------------");
        for (Integer key : options.keySet()) {
            System.out.println("\t\t\t\t" + key + ". " + options.get(key));
        }
        System.out.println();
        System.out.println("Choose an option (1-" + options.size() + ") from the above options to proceed:");
        int choice = Util.getInteger();
        return choice > options.size() + 1 ? -1 : choice;
    }
}
