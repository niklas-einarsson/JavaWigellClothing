package org.example;

import org.example.BusinessObject.Customer;
import org.example.BusinessObject.Order;
import org.example.Clothes.Pants;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    private OrderService orderService;
    private Customer customer;
    private PropertyChangeListener listener;


    @BeforeEach
    void setUp() {
        orderService = OrderService.getInstance();
        orderService.getOrders().clear();
        customer = Mockito.mock(Customer.class);
        listener = Mockito.mock(PropertyChangeListener.class);
    }

    @Test
    void ShouldReturnSameSingletonInstance() {
        OrderService instance1 = OrderService.getInstance();
        OrderService instance2 = OrderService.getInstance();

        assertSame(instance1, instance2, "Instances should be the same because Singleton");
    }

    @Test
    void CreatingOneOrderShouldIncreaseListSizeByOne() {
        orderService.createNewOrder(customer, listener);
        assertEquals(1, orderService.getOrders().size(), "One order should exist");
    }


    @Test
    void OrdersShouldMatch() {
        orderService.createNewOrder(customer, listener);
        Order expectedOrder = orderService.getOrders().get(0);
        Order retrievedOrder = orderService.getOrder(expectedOrder.getId());
        assertEquals(expectedOrder, retrievedOrder, "Orders should match");
    }

    @Test
    void OrderWithIdShouldNotExist() {
        orderService.createNewOrder(customer, listener);
        Order retrievedOrder = orderService.getOrder(5);
        assertNull(retrievedOrder, "Order should not exist");
    }

    @Test
    void TwoItemsShouldBeAddedToOrder() {
        orderService.createNewOrder(customer, listener);
        Order order = orderService.getOrders().get(0);
        Pants pants = Mockito.mock(Pants.class);
        Pants pants2 = Mockito.mock(Pants.class);
        orderService.addItemToOrder(order.getId(), pants);
        orderService.addItemToOrder(order.getId(), pants2);
        assertEquals(2, order.getItems().size(), "Order should have two items");
    }

    @Test
    void AddItemToOrderShouldNotFindOrder() {
        Pants pants = Mockito.mock(Pants.class);
        orderService.addItemToOrder(1, pants);
        assertEquals(0, orderService.getOrders().size(), "No order should exist for item");
    }

    @Test
    void AddPropertyChangeListenerToOrder() {
        Order mockOrder = Mockito.mock(Order.class);
        orderService.addPropertyChangeListenerToOrder(mockOrder, listener);
        verify(mockOrder, times(1)).addPropertyChangeListener(listener);
    }

    @Test
    void RemovePropertyChangeListenerFromOrder_OrderExists() {
        Order mockOrder = Mockito.mock(Order.class);
        when(mockOrder.getId()).thenReturn(1);
        orderService.getOrders().add(mockOrder);
        orderService.removePropertyChangeListenerFromOrder(mockOrder.getId(), listener);
        verify(mockOrder, times(1)).removePropertyChangeListener(listener);
    }

    @Test
    void RemovePropertyChangeListenerFromOrder_OrderDoesNotExist() {
        orderService.removePropertyChangeListenerFromOrder(123, listener);
        assertEquals(0, orderService.getOrders().size(), "No order should exist");
    }
}