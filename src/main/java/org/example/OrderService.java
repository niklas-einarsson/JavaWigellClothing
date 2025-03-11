    package org.example;

    import org.example.BusinessObject.Customer;
    import org.example.BusinessObject.Order;
    import org.example.Clothes.Clothes;

    import java.beans.PropertyChangeListener;
    import java.util.ArrayList;
    import java.util.List;

    public class OrderService {

        private static OrderService instance;
        private List<Order> orders = new ArrayList<>();

        private OrderService() {

        }

        public static synchronized OrderService getInstance() {
            if (instance == null) {
                instance = new OrderService();
            }
            return instance;
        }

        public void createNewOrder(Customer customer, PropertyChangeListener listener) {
            Order order = new Order(customer);
            orders.add(order);
            order.addPropertyChangeListener(listener);
        }


        public Order getOrder(int id) {
            return orders.stream().filter(order -> order.getId() == id).findFirst().orElse(null);
        }


        public void addPropertyChangeListenerToOrder(Order order, PropertyChangeListener listener) {
            order.addPropertyChangeListener(listener);
        }

        public void removePropertyChangeListenerFromOrder(int orderId, PropertyChangeListener listener) {
            Order order = getOrder(orderId);
            if (order != null) {
                order.removePropertyChangeListener(listener);
            }
        }

       public void addItemToOrder(int orderId, Clothes item){
            Order order = getOrder(orderId);
            if(order != null){
                order.addItem(item);
            } else {
                System.out.println("Order not found, could not add item");
            }
       }

       public List<Order> getOrders() {
            return orders;
       }

    }
