package org.example;

import org.example.Builder.PantsBuilder;
import org.example.Builder.SkirtBuilder;
import org.example.Builder.TShirtBuilder;
import org.example.Clothes.Clothes;
import org.example.Clothes.Pants;
import org.example.Clothes.Skirt;
import org.example.Clothes.TShirt;
import org.example.Command.*;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {

        System.out.println("Välkommen till Wigell Clothing!");

        Customer customer = new Customer(1,"Test Customer","Testgvägen 7", "customer@mail.com");

        CEO ceo = new CEO();
        OrderCEOObserver orderCEOObserver = new OrderCEOObserver();
        Order order = new Order(customer);
        order.addPropertyChangeListener(orderCEOObserver);

        Menu menu = new Menu(order);
        menu.showMenu();
    }
}
