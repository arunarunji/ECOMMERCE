package com.executor;


import com.dataHandler.*;
import com.model.Cart;
import com.model.Item;
import com.model.Menu;
import com.model.Order;
import com.navigator.CustomerOptionNavigator;
import com.helper.Util;

import java.util.ArrayList;
import java.util.List;


import static com.navigator.SignInPageNavigator.setRunning;
import static com.helper.Util.*;


public class CustomerOptionExceutor implements Execute {
    private final int result;
    private final int customerId;
    private final Cart cart;
    private final OrderHandler orderHandler = OrderDataHandler.getInstance();
    private final ProductHandle productHandle = ProductHandler.getInstance();

    public CustomerOptionExceutor(int result, int customerId, Cart cart) {
        this.customerId = customerId;
        this.result = result;
        this.cart = cart;
    }

    @Override
    public void execute() {

        switch (result) {
            case 1:
                addProductToCart();
                break;
            case 2:
                viewCart();
                break;
            case 3:
                removeProductsFromCart();
                break;
            case 4:
                removeAllProducts();
                break;

            case 5:
                placeOrder();
                break;

            case 6:
                viewOrderHistory();
                break;
            case 7:
                cancelOrder();
                break;

            case 8:
                CustomerOptionNavigator.setRes(false);
                setRunning(false);
                if (cart.getItemList() != null) {
                    CartHandler.getInstance().addCartToList(customerId, cart.getItemList());
                    break;
                }
            default:
                inValidInt();
        }
    }

    private void cancelOrder() {
        final List<Order> orderList = orderHandler.getOrderedData().get(customerId);
        if (orderList != null) {
            final int orderId = getIntegerAndDisplayMessage("Order ID", "Order ID for Cancellation");
            if (orderId != -1) {

                if (orderList.isEmpty())
                    System.out.println("Order Id Does not Exist ,Pls Enter the Valid Order ID");

                else if (orderList.removeIf(order -> order.getOrderId() == orderId))
                    System.out.println("Cancellation of the Order ID " + orderId + " is Successfully");

            }
        } else
            System.out.println("No Order History Found ,Pls Make Some Orders");
    }

    private void viewOrderHistory() {
        final List<Order> orders = orderHandler.getOrderDataArraylist(customerId);
        if (orders == null || orders.isEmpty())
            System.out.println("There is NO Order Found ,Pls Make to Order Some Order");
        else for (Order o : orders)
            Util.generateInvoice(customerId, o.getOrderId(), o.getItemList(), o.getDate());


    }

    private void removeAllProducts() {
        if (cart.getItemList().size() != 0) {
            System.out.println("Are you sure need to clear the Cart ");
            final int choice = getIntegerAndDisplayMessage("Choice", "1 To Proceed  \\nTo Continue Enter Any Key");
            if (choice != -1) {
                cart.removeAllProducts();
                System.out.println("Cart is Cleared Successfully");
            }
        } else
            System.out.println("Pls Add Product to Cart !! Cart is Empty");


    }

    private void viewCart() {
        final List<Item> itemList = cart.getItemList();
        if (itemList == null || itemList.isEmpty()) System.out.println("Cart is Empty ,Pls Add Product To Cart");
        else Util.displayCart(itemList);
    }

    private void addProductToCart() {


        final int productID = getIntegerAndDisplayMessage("ProductId", "ProductID that you need to Add to Cart");
        if (productHandle.checkProductIdExist(productID) && productID != -1) {
            final int qty = getIntegerAndDisplayMessage("Quantity", "Number of Quantity that you need to Purchase");
            if (qty != -1)
                cart.updateCart(productID, qty);
        } else
            System.out.println("Enter the Valid ProductId Number");
    }


    private void placeOrder() {
        final List<Item> item = cart.getItemList();
        if (item == null || item.isEmpty()) {
            System.out.println("Cart is Empty ,Pls Add Product To Cart");

        } else {
            final Menu menu = new Menu("PLACE ORDER MENU", MenuHandler.getInstance().getPlaceOrder());
            int res = menu.getChoice();


            if (res == 1) {

                final List<Item> items = new ArrayList<>(item);
                createOrderAndProceed(customerId, items);
                cart.getItemList().clear();
            } else if (res == 2) {
                Util.displayCart(item);
                final List<Item> temp = new ArrayList<>();
                final List<Item> balance = new ArrayList<>();
                int cnt = getIntegerAndDisplayMessage("Count", "Number of Product that you need to add to Cart");
                if (cnt != -1) {
                    while (cnt-- > 0) {
                        final int id = getIntegerAndDisplayMessage("ProductId", "ProductID that you need to Add to Cart");
                        if (id != -1)
                            for (Item i1 : cart.getItemList())
                                if (i1.getProduct().getProductId() == id) {
                                    temp.add(i1);
                                } else balance.add(i1);
                    }

                }
                createOrderAndProceed(customerId, temp);
                cart.setItemList(balance);

            } else
                inValid("Choice");
        }

    }

    private void removeProductsFromCart() {
        if (cart.getItemList().size() != 0) {
            final int productID1 = getIntegerAndDisplayMessage("ProductID", "ProductID  of the Product that you need to remove");
            if (productHandle.checkProductIdExist(productID1) && productID1 != -1) {
                final int count = getIntegerAndDisplayMessage("Quantity", "Number of Quantity that you need to remove");
                if (count != -1)
                    if (cart.removeProducts(productID1, count))
                        System.out.println("Product Is Removed Successfully");
            }
        } else
            System.out.println("Pls Add Product to Cart !! Cart is Empty");
    }

    private void createOrderAndProceed(int customerId, List<Item> item) {
        final Order order = new Order(customerId, item);
        order.generateInvoice();
        if (orderHandler.setOrderData(customerId, order))
            System.out.println("Order is Placed Successfully..... ");
    }
}



