package org.example.BusinessObject;

import org.example.Clothes.Clothes;
import org.example.Clothes.Pants;
import org.example.Clothes.Skirt;
import org.example.Clothes.TShirt;

import java.util.List;

public class Receipt extends BusinessObject {

    private Order order;

    public Receipt(Order order) {
        super(order.getId(), "Receipt" + order.getId());
        this.order = order;
    }

   public Receipt() {

   }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


    public void printReceipt() {
        if (order == null) {
            System.out.println("Finns ingen order");
        } else {
            System.out.println("KVITTO FÖR BESTÄLLNING:");
            System.out.println("Order ID: " + order.getId());
            System.out.println("Kundens namn: " + order.getCustomer().getName());
            System.out.println("Kundens ID: " + order.getCustomer().getId());
            System.out.println("Kundens email: " + order.getCustomer().getEmail());
            System.out.println("Beställda plagg: " + order.getItems().size());
            List<Clothes> items = order.getItems();
            if (items.isEmpty()) {
                System.out.println("Inga plagg beställda");
            } else {

                for (Clothes item : items) {
                    System.out.println("-----------------------");
                    System.out.println("Typ: " + item.getClass().getSimpleName());
                    System.out.println("Pris: " + item.getPrice());
                    System.out.println("Storlek: " + item.getSize());
                    System.out.println("Material: " + item.getMaterial());
                    System.out.println("Färg: " + item.getColor());

                    if (item instanceof TShirt) {
                        TShirt tshirt = (TShirt) item;
                        System.out.println("Hals: " + tshirt.getNeck());
                        System.out.println("Ärmar: " + tshirt.getSleeves());
                    } else if (item instanceof Skirt) {
                        Skirt skirt = (Skirt) item;
                        System.out.println("Waistline: " + skirt.getWaistline());
                        System.out.println("Pattern: " + skirt.getPattern());
                    } else if (item instanceof Pants) {
                        Pants pants = (Pants) item;
                        System.out.println("Fit: " + pants.getFit());
                        System.out.println("Length: " + pants.getLength());
                    }
                }
            }
            System.out.println("-----------------------");
            System.out.println("SUMMA: " + order.getOrderPrice() + "SEK");
            System.out.println("Status: " + order.getStatus());
        }

    }


    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", order=" + order +
                "} " + super.toString();
    }
}
