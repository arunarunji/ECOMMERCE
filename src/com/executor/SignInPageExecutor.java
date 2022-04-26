package com.executor;


import com.dataHandler.LoginHandle;
import com.dataHandler.LoginHandler;
import com.model.Address;
import com.model.Customer;
import com.navigator.MainMenu;
import com.navigator.Navigator;

import static com.helper.Util.*;


import java.util.Scanner;

public class SignInPageExecutor implements Execute {
    private final Scanner in = new Scanner(System.in);
    private final int choice;
    private int customerID;
    private String userType;
    private final LoginHandle loginHandle = LoginHandler.getInstance();


    public SignInPageExecutor(int choice) {
        this.choice = choice;

    }


    @Override
    public void execute() {
        switch (choice) {
            case 1:
                SignUp();
                break;
            case 2:
                if (!checkLogin())
                    System.out.println("Pls Enter correct Email and Password OR Pls Create New Account ");

                else {
                    System.out.println("LOGGED IN SUCCESSFULLY ....");
                    WelcomePageExecutor.setRun(false);
                    if (userType.equalsIgnoreCase("Customer")) {
                        final Navigator n = new MainMenu(customerID);
                        n.navigate();
                    } else {

                        final Execute n1 = new AdminExecutor();
                        n1.execute();
                    }
                }
                break;
            default:
                inValidInt();

        }
    }

    private boolean checkLogin() {
        String email = "";
        String password = "";
        while (validateEmail(email)) {
            System.out.println("Enter the UserEmailId");
            email = in.nextLine().trim();
            if (validateEmail(email))
                System.out.println("Invalid Email,Pls Enter the Valid Email ");
        }
        while (validatePassword(password)) {
            System.out.println("Enter the Password  ");
            password = in.nextLine().trim();
            if (validatePassword(password))
                System.out.println("Invalid Password,Pls Enter the Valid Password ");
        }
        customerID = loginHandle.getCustomerId(email);
        userType = loginHandle.getUserType(email);
        return loginHandle.checkUserExist(email, password);

    }

    private void SignUp() {
        String email = "";
        String password = "";
        String name = "";
        String phNumber = "";
        while (validateEmail(email)) {
            System.out.println("Enter the UserEmailId");
            email = in.nextLine().trim();
            if (!loginHandle.checkEmailExist(email)) {
                if (validateEmail(email))
                    System.out.println("Invalid Email,Pls Enter the Valid Email ");
            } else {
                System.out.println("Customer EmailId Already Exists ");
            }
        }
        while (validatePassword(password)) {

            System.out.println("Password must contain at least one digit [0-9].\n" +
                    "        Password must contain at least one lowercase character [a-z].\n" +
                    "        Password must contain at least one uppercase character [A-Z].\n" +
                    "        Password must contain at least one special character like ! @ # & ( ).\n" +
                    "        Password must contain a length of at least 8 characters and a maximum of 20 characters.\nEnter a password with following criteria");

            password = in.nextLine().trim();
            if (validatePassword(password))
                System.out.println("Invalid Password,Pls Enter the Valid Password ");
        }
        while (validateName(name)) {
            System.out.println("Enter the CustomerName");
            name = in.nextLine().trim();
            if (validateName(name))
                System.out.println("Invalid Customer Name,Pls Enter the Valid Customer Name ");
        }
        while (validatePhone(phNumber)) {
            System.out.println("Enter the Phone Number ");
            phNumber = in.nextLine().trim();
            if (validatePhone(phNumber))
                System.out.println("Invalid Phone Number ,Pls Enter the Valid phone Number ");
        }
        final Address address = new Address(2, "Main Road", "Villupuram", "Pondicherry", "Pondicherry", 605102);
        final Customer customer = new Customer(email, password, name, address, phNumber);
        customerID = customer.getCustomerId();
        loginHandle.setCustomer(customer);
        System.out.println("Login is SuccessFully Created ..");
        final Navigator n = new MainMenu(customerID);
        n.navigate();
    }


}


