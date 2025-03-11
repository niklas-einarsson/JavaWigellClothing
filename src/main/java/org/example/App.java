package org.example;

import org.example.BusinessObject.CEO;
import org.example.BusinessObject.Customer;
import org.example.BusinessObject.Order;

public class App {
    public static void main( String[] args ) {

        System.out.println("Välkommen till Wigell Clothing!");

        Customer customer = new Customer(1,"Test Customer","Testgvägen 7", "customer@mail.com");

        CEO ceo = new CEO(1, "Herr Wigell");
        OrderCEOObserver orderCEOObserver = new OrderCEOObserver();
        OrderService.getInstance().createNewOrder(customer, orderCEOObserver);
        Order order = OrderService.getInstance().getOrders().get(0);

        Menu menu = new Menu(order);
        menu.showMenu();
    }
}
