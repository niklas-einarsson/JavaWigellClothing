package org.example.Command;

import org.example.Clothes.Clothes;
import org.example.Clothes.TShirt;

public class TShirtNeckCommand implements ClothingDetailCommand {

    private String neck;

    public TShirtNeckCommand(String neck) {
        this.neck = neck;
    }

    @Override
    public void process(Clothes clothes) {
        TShirt tshirt = (TShirt) clothes;
        tshirt.setNeck(neck);
        System.out.println("Neck lades till med TShirtNeckCommand: " + neck);


    }

    
}
