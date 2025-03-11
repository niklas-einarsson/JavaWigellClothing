package org.example.BusinessObject;

import org.example.Clothes.Clothes;
import org.example.OrderStatus;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Order extends BusinessObject {

    private static int nextId = 1;
    private double orderPrice;
    private List<Clothes> items = new ArrayList<>();
    private OrderStatus status;
    private Customer customer;

    private PropertyChangeSupport propertyChangeSupport;

    public Order(Customer customer) {
        propertyChangeSupport = new PropertyChangeSupport(this);
        id = nextId++;
        name = "Order" + id;
        status = OrderStatus.PENDING;
        System.out.println("Ny order skapad med id: " + getId());
        this.customer = customer;
    }

    public Order() {
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }


    public void addItem(Clothes items) {
        this.items.add(items);
        orderPrice += items.getPrice();
    }

    public List<Clothes> getItems() {
        return items;
    }

    public void setItems(List<Clothes> items) {
        this.items = items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStatus(OrderStatus status) {
        OrderStatus oldStatus = this.status;
        this.status = status;
        this.propertyChangeSupport.firePropertyChange("status", oldStatus, status);
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Order.nextId = nextId;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderPrice=" + orderPrice +
                ", items=" + items +
                ", status=" + status +
                ", customer=" + customer +
                ", propertyChangeSupport=" + propertyChangeSupport +
                ", id=" + id +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}
