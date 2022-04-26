package com.dataHandler;

import com.dataBase.LoginDataBase;
import com.dataBase.LoginDb;
import com.model.Customer;
import com.model.User;

import java.util.ArrayList;
import java.util.List;


public class LoginHandler implements LoginHandle {
    private static LoginHandle LOGIN_HANDLER;
    private final LoginDataBase ldb = LoginDb.getInstance();

    private LoginHandler() {

    }

    public static LoginHandle getInstance() {
        if (LOGIN_HANDLER == null)
            LOGIN_HANDLER = new LoginHandler();
        return LOGIN_HANDLER;
    }


    @Override
    public int getCustomerId(String email) {

        for (User user : getCustomer())
            if (user.getUserMailID().equals(email))
                return ((Customer) user).getCustomerId();
        return -1;
    }

    @Override
    public String getUserType(String email) {
        for (User user : ldb.getUsers())
            if (user.getUserMailID().equalsIgnoreCase(email))
                return user.getUserType();

        return null;
    }

    @Override
    public List<User> getCustomer() {

        List<User> customerList = new ArrayList<>();
        for (User user : ldb.getUsers())
            if (user.getUserType().equals("Customer"))
                customerList.add(user);

        return customerList;

    }

    @Override
    public void setCustomer(Customer customer) {

        ldb.getUsers().add(customer);

    }

    @Override
    public User getCustomerObj(int customerId) {
        for (User user : getCustomer()) {
            if (((Customer) user).getCustomerId() == customerId)
                return user;
        }
        return null;
    }

    @Override
    public boolean checkUserExist(String email, String password) {

        for (User user : ldb.getUsers()) {
            if (user.getUserMailID().equalsIgnoreCase(email) && user.getUserPassword().equals(password)) {
                return true;
            }


        }
        return false;
    }

    public boolean checkEmailExist(String email) {
        for (User user : ldb.getUsers()) {
            if (user.getUserMailID().equals(email)) {
                return true;
            }
        }
        return false;
    }


}
