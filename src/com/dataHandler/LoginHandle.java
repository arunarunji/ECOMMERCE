package com.dataHandler;


import com.model.Customer;
import com.model.User;

import java.util.List;

public interface LoginHandle {
    List<User> getCustomer();

    void setCustomer(Customer customer);

    User getCustomerObj(int customerId);

    boolean checkUserExist(String email, String password);

    String getUserType(String email);

    int getCustomerId(String email);

    boolean checkEmailExist(String email);


}
