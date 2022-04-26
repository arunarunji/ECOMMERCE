package com.executor;


import com.dataHandler.*;
import com.model.Category;
import com.model.Menu;
import com.model.Product;
import com.navigator.CustomerOptionNavigator;
import com.helper.Util;


import java.util.ArrayList;
import java.util.Scanner;

import static com.navigator.SignInPageNavigator.isRunning;
import static com.navigator.SignInPageNavigator.setRunning;
import static com.helper.Util.*;

public class AdminExecutor implements Execute {
    private final Scanner in = new Scanner(System.in);
    private final CategoryHandle categoryHandle = CategoryHandler.getInstance();
    private final ProductHandle productHandle = ProductHandler.getInstance();


    @Override
    public void execute() {
        while (isRunning()) {

            final Menu menu = new Menu("ADMIN MAIN MENU OPTION", MenuHandler.getInstance().adminOption());
            final int choice = menu.getChoice();
            if (choice != -1) {
                switch (choice) {
                    case 1:
                        addProduct();
                        break;
                    case 2:
                        removeProduct();
                        break;
                    case 3:
                        updateExistingProduct();
                        break;
                    case 4:
                        updateDiscount();
                        break;
                    case 5:
                        addDiscount();
                        break;

                    case 6:
                        removeDiscount();
                        break;
                    case 7:
                        addCategory();
                        break;
                    case 8:
                        viewProducts();
                        break;
                    case 9:

                        CustomerOptionNavigator.setRes(false);
                        setRunning(false);
                        System.out.println("Admin is LOGGED OUT Successfully .... , your Update of data are Successfully");
                        break;
                    default:
                        inValidInt();
                }


            } else
                System.out.println("Pls Enter the Valid Choice");


        }
    }

    private void removeDiscount() {
        System.out.println();
        final int productID = getIntegerAndDisplayMessage("ProductId", " ProductID that you need to remove Discount");
        if (!productHandle.checkProductIdExist(productID) && productID != -1)
            productHandle.removeDiscount(productID);
        else
            System.out.println("ProductID Already Exist");


    }

    private void viewProducts() {
        Util.displayProduct(productHandle.getProductData());
    }

    private void addDiscount() {
        System.out.println();
        final int productId = getIntegerAndDisplayMessage("ProductId", "ProductId that you need add discount");
        if (productHandle.checkProductIdExist(productId) && productId != -1) {
            final int discount = getIntegerAndDisplayMessage("Discount", "Discount Amount that you need to Add to Product");
            if (discount != -1)
                productHandle.addDiscount(productId, discount);


        } else
            System.out.println("ProductID does not Exist Exist");
    }

    private void addProduct() {
        System.out.println();
        final int productId = getIntegerAndDisplayMessage("ProductId", "ProductId that you need to add");
        if (!productHandle.checkProductIdExist(productId) && productId != -1) {
            System.out.println("Enter the Product Name");
            String productName = in.nextLine().trim();
            System.out.println("Enter the brandName");
            String brandName = in.nextLine().trim();
            final int price = getIntegerAndDisplayMessage("Price", "Price of the Product");
            if (price != -1) {
                final Product product = new Product(productId, productName, brandName, price);
                Util.displayCategory(categoryHandle.getCategoriesList());
                final int choice1 = getIntegerAndDisplayMessage("Category", "Category Number that You need add the Product");
                if (choice1 != -1) {
                    final int res = validateChoice(choice1);
                    if (res != -1) {
                        categoryHandle.getCategory(res).addProduct(productId);
                        productHandle.setProduct(product);
                        System.out.println("Product is Added Successfully");
                    } else System.out.println("Pls Enter the Valid Choice ,pls make Sure Entering Correct Category ID");
                }
            }
        } else
            System.out.println("ProductID Already Exist");
    }

    private void removeProduct() {

        final int productId = getIntegerAndDisplayMessage("ProductId", "ProductID that you need to remove");
        if (productHandle.checkProductIdExist(productId) && productId != -1) {
            Util.displayCategory(categoryHandle.getCategoriesList());
            final int choice1 = getIntegerAndDisplayMessage("Category ID", "Category Number that You need to remove");
            if (choice1 != -1) {
                int res = validateChoice(choice1);
                if (res != -1) {
                    categoryHandle.getCategory(res).removeProduct(res);
                    productHandle.removeProduct(productId);

                } else System.out.println("Pls Enter the Valid Choice ,pls make Sure Entering Correct Category ID");
            }
        } else
            System.out.println("ProductID does not Exist");
    }

    private void updateExistingProduct() {
        System.out.println();
        final int productId = getIntegerAndDisplayMessage("ProductId", "ProductID that you need to change");
        if (productHandle.checkProductIdExist(productId) && productId != -1) {
            System.out.println("1.Price\n2.Discount");
            final int choice = Util.getInteger();
            switch (choice) {
                case 1:
                    final int price = getIntegerAndDisplayMessage("Price", "Price that you need to Update");
                    productHandle.getProduct(productId).setPrice(price);
                    break;
                case 2:
                    final int discount = getIntegerAndDisplayMessage("discount", "Amount that you need to Update");
                    productHandle.getProduct(productId).setDiscount(discount);
                    break;


                default:
                    inValidInt();
            }
        } else
            System.out.println("ProductId Does not Exist");
    }

    private void updateDiscount() {
        System.out.println();
        final int productID = getIntegerAndDisplayMessage("ProductId", "ProductId that you need to Update");
        if (productHandle.checkProductIdExist(productID) && productID != -1) {
            final int discount = getIntegerAndDisplayMessage("Discount", "new Discount Price for the Product");
            if (discount != -1) {
                productHandle.updateDiscount(productID, discount);
                System.out.println("Discount for the Product is Updated Successfully ...... ");
            }
        }
    }

    private void addCategory() {
        final CategoryHandle categoryHandle = CategoryHandler.getInstance();
        System.out.println();
        System.out.println("Enter the CategoryName that you need to add");
        String name = in.nextLine().trim();
        System.out.println("\nEnter 1 to add products \n2 continue ");
        final int choice = Util.getInteger();
        final ArrayList<Integer> products = new ArrayList<>();
        if (choice == 1) {
            System.out.println("Enter the Number of products to add");
            int cnt = Util.getInteger();
            while (cnt > 0) {
                System.out.println("Enter the " + cnt + " Details");
                final int productId = getIntegerAndDisplayMessage("ProductID", "ProductId that you need to add");
                if (productId != -1) {
                    System.out.println("Enter the Product Name");
                    final String productName = in.nextLine().trim();
                    System.out.println("Enter the brandName");
                    final String brandName = in.nextLine().trim();
                    final int price = getIntegerAndDisplayMessage("Price", "Price of the Product");
                    if (price != -1) {
                        final Product product = new Product(productId, productName, brandName, price);
                        products.add(productId);
                        productHandle.setProduct(product);
                        cnt--;
                    }
                }
            }
            final Category category = new Category(name, products);
            categoryHandle.setCategoryList(category);
            System.out.println("Category is Created  and Products Added Successfully");
        }
        final Category category = new Category(name, products);
        categoryHandle.setCategoryList(category);
        System.out.println("Category is Created Successfully ..");
    }

    private int validateChoice(int choice1) {


        for (Category category : categoryHandle.getCategoriesList()) {
            if (category.getCategoryId() == choice1) {
                return category.getCategoryId();

            }
        }
        return -1;
    }


}

