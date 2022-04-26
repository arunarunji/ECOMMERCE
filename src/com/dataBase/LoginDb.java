package com.dataBase;


import com.model.Address;
import com.model.Admin;
import com.model.Customer;
import com.model.User;

import java.util.ArrayList;



public class LoginDb implements LoginDataBase {
    private static  LoginDb LOGIN_DB=null;

    private LoginDb() {


    }

    public static LoginDb getInstance() {
        if(LOGIN_DB==null)
            LOGIN_DB = new LoginDb();
        return LOGIN_DB;
    }

    private final ArrayList<User> users = new ArrayList<User>() {
        {
            add(new Admin("mb.arun1407@gmail.com", "Arun@1234"));

            add(new Customer("arun@gmail.com", "Arun@1234", "ArunKumar", new Address(2, "Main Road", "Villupuram", "Pondicherry", "Pondicherry", 605102), "9487545391"));
            add(new Customer("mass@gmail.com", "Arun@1234", "Mass", new Address(2, "Main Road", "Villupuram", "Pondicherry", "Pondicherry", 605102), "9487545391"));
            add(new Customer("mohan@gmail.com", "Arun@1234", "Mohan", new Address(2, "Main Road", "Villupuram", "Pondicherry", "Pondicherry", 605102), "9487545391"));
        }
    };


    public ArrayList<User> getUsers() {
        return users;
    }
}

