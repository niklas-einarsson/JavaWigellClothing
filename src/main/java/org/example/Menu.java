package org.example;

import org.example.Builder.PantsBuilder;
import org.example.Builder.SkirtBuilder;
import org.example.Builder.TShirtBuilder;
import org.example.BusinessObject.Order;
import org.example.BusinessObject.Receipt;
import org.example.Clothes.Pants;
import org.example.Clothes.Skirt;
import org.example.Clothes.TShirt;
import org.example.Command.*;

import java.util.Scanner;

public class Menu {

    private Order order;

    Scanner scanner = new Scanner(System.in);

    public Menu(){

    }

    public Menu(Order order) {
        this.order = order;
    }


    public void showMenu() {
        if(order == null){
            System.out.println("Order is null");
        }
        System.out.println("Current orderID: " + order.getId());
        order.setStatus(OrderStatus.PENDING);
        System.out.println("Vad vill du köpa? (ange siffra)");
        System.out.println("1. T-Shirt \n2. Byxor \n3. Kjol");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                designAndOrderClothes("T-Shirt");
                break;
            case 2:
                designAndOrderClothes("Pants");
                break;
            case 3:
                designAndOrderClothes("Skirt");
                break;
            default:
                System.out.println("Ogiltigt val!");
                break;
        }
    }

    public void designAndOrderClothes(String type) {

        String size = chooseSize();
        String material = chooseMaterial();
        String color = chooseColor();

        switch (type) {
            case "T-Shirt":
                // Builder
                TShirt tShirt = new TShirtBuilder().addSize(size).addMaterial(material).addColor(color).build();
                tShirt.setName("T-Shirt");
                System.out.println("T-shirt skapad: " + tShirt);
                order.setStatus(OrderStatus.ORDER_PLACED);
                // Command
                ClothingDetailPipeline tShirtPipeline = new ClothingDetailPipeline();
                tShirtPipeline.addCommand(new TShirtNeckCommand(chooseTShirtNeck()));
                tShirtPipeline.addCommand(new TShirtSleevesCommand(chooseTShirtSleeves()));
                tShirtPipeline.execute(tShirt);
                System.out.println("T-Shirt skapad med Command: " + tShirt);
                OrderService.getInstance().addItemToOrder(order.getId(),tShirt);
                order.setStatus(OrderStatus.READY_FOR_DELIVERY);
                break;
            case "Pants":
                //Builder
                Pants pants = new PantsBuilder().addSize(size).addMaterial(material).addColor(color).build();
                pants.setName("Byxor");
                System.out.println("Byxor skapade med Builder: " + pants);
                order.setStatus(OrderStatus.ORDER_PLACED);
                // Command
                ClothingDetailPipeline pantsPipeline = new ClothingDetailPipeline();
                pantsPipeline.addCommand(new PantsFitCommand(choosePantsFit()));
                pantsPipeline.addCommand(new PantsLengthCommand(choosePantsLength()));
                pantsPipeline.execute(pants);
                System.out.println("Byxor skapade med Command: " + pants);
                OrderService.getInstance().addItemToOrder(order.getId(),pants);
                order.setStatus(OrderStatus.READY_FOR_DELIVERY);
                break;
            case "Skirt":
                // Builder
                Skirt skirt = new SkirtBuilder().addSize(size).addMaterial(material).addColor(color).build();
                skirt.setName("Kjol");
                System.out.println("Kjol skapad: " + skirt);
                order.setStatus(OrderStatus.ORDER_PLACED);
                // Command
                ClothingDetailPipeline skirtPipeline = new ClothingDetailPipeline();
                skirtPipeline.addCommand(new SkirtPatternCommand(chooseSkirtPattern()));
                skirtPipeline.addCommand(new SkirtWaistlineCommand(chooseSkirtWaistline()));
                skirtPipeline.execute(skirt);
                System.out.println("Kjol skapad med Command: " + skirt);
                OrderService.getInstance().addItemToOrder(order.getId(),skirt);
                order.setStatus(OrderStatus.READY_FOR_DELIVERY);
                break;
        }

        while(true) {
            System.out.println("Vill du köpa något mer?");
            System.out.println(" 1. Ja, jag vill beställa ett till plagg \n 2. Nej, bekräfta beställning och visa kvitto");
            int choice = scanner.nextInt();
            if(choice == 1) {
                showMenu();
                break;
            }
            else if(choice == 2) {
                generateReceipt().printReceipt();
                System.out.println("Tack för att du handlar hos Wigell Clothing!");
                break;
            } else {
                System.out.println("Ogiltigt val. Försök igen");
            }
        }
    }

    private String chooseSize() {
        System.out.println("Välj en storlek: \n 1. Small \n 2. Medium \n 3. Large");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return "Small";
            case 2:
                return "Medium";
            case 3:
                return "Large";
            default:
                System.out.println("Ogiltigt val. Standardstorlek Small vald.");
                return "Small";
        }
    }

    private String chooseMaterial() {
        System.out.println("Välj material: \n 1. Bomull \n 2. Denim \n 3. Läder");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return "Bomull";
            case 2:
                return "Denim";
            case 3:
                return "Läder";
            default:
                System.out.println("Ogiltigt val. Standardmaterial Bomull vald.");
                return "Bomull";
        }
    }

    private String chooseColor() {
        System.out.println("Välj färg: \n 1. Svart \n 2. Vit \n 3. Blå");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return "Svart";
            case 2:
                return "Vit";
            case 3:
                return "Blå";
            default:
                System.out.println("Ogiltigt val. Standardfärg Svart vald.");
                return "Svart";
        }
    }

    public String choosePantsLength() {
        String length = "";
        System.out.println("Välj längd: ");
        System.out.println(" 1. Långa \n 2. Korta");
        int lengthChoice = scanner.nextInt();
        switch (lengthChoice) {
            case 1:
                length = "Långa";
                break;
            case 2:
                length = "Korta";
                break;
            default:
                System.out.println("Ogiltigt val");
        }
        return length;
    }

    public String choosePantsFit() {
        String fit = "";
        System.out.println("Välj passform: ");
        System.out.println(" 1. Regular \n 2. Loose");
        int fitChoice = scanner.nextInt();
        switch (fitChoice) {
            case 1:
                fit = "Regular";
                break;
                case 2:
                    fit = "Loose";
                    break;
                    default:
                        System.out.println("Ogiltigt val");
                        break;
        }
        return fit;
    }

    public String chooseSkirtPattern() {
        String pattern = "";
        System.out.println("Välj mönster: ");
        System.out.println(" 1. Rutigt \n 2. Randigt ");
        int patternChoice = scanner.nextInt();
        switch (patternChoice) {
            case 1:
                pattern = "Rutigt";
                break;
            case 2:
                pattern = "Randigt";
                break;
            default:
                System.out.println("Ogiltigt val");
                break;
        }
        return pattern;
    }

    public String chooseSkirtWaistline() {
        String waistline = "";
        System.out.println("Välj midja");
        System.out.println(" 1. Hög \n 2. Låg ");
        int waistlineChoice = scanner.nextInt();
        switch (waistlineChoice) {
            case 1:
                waistline = "Hög";
                break;
            case 2:
                waistline = "Låg";
                break;
            default:
                System.out.println("Ogiltigt val");
                break;
        }
        return waistline;
    }


    public String chooseTShirtNeck(){
        String neck = "";
        System.out.println("Välj hals: ");
        System.out.println(" 1. Rund \n 2. V-ringad ");
        int neckChoice = scanner.nextInt();
        switch (neckChoice) {
            case 1:
                neck = "Rund";
                break;
                case 2:
                    neck = "V-ringad";
                    break;
                    default:
                        System.out.println("Ogiltigt val");
                        break;
        }
        return neck;
    }


    public String chooseTShirtSleeves() {
        String sleeves = "";
        System.out.println("Välj ärmar: ");
        System.out.println(" 1. Långa \n 2. Korta");
        int sleeveChoice = scanner.nextInt();
        switch (sleeveChoice) {
            case 1:
                sleeves = "Långa";
                break;
                case 2:
                    sleeves = "Korta";
                    break;
                    default:
                        System.out.println("Ogiltigt val");
                        break;
        }
        return sleeves;
    }

    public Receipt generateReceipt() {
        return new Receipt(order);
    }
}
