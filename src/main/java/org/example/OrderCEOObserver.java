package org.example;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OrderCEOObserver implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        OrderStatus newStatus = (OrderStatus) evt.getNewValue();
        OrderStatus oldStatus = (OrderStatus) evt.getOldValue();

        if (newStatus == OrderStatus.ORDER_PLACED && oldStatus != OrderStatus.ORDER_PLACED) {
            System.out.println("Order lagd. Plagg tillverkas!");
        } else if (newStatus == OrderStatus.READY_FOR_DELIVERY) {
            System.out.println("Plagg klart. Ordern är redo för leverans!");
        }
    }
}

