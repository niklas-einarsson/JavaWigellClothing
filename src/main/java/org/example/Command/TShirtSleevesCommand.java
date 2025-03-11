package org.example.Command;

import org.example.Clothes.Clothes;
import org.example.Clothes.TShirt;

public class TShirtSleevesCommand implements ClothingDetailCommand {

    private String sleeves;

    public TShirtSleevesCommand(String sleeve) {
        this.sleeves = sleeve;
    }

    @Override
    public void process(Clothes clothes) {
        TShirt tshirt = (TShirt) clothes;
        tshirt.setSleeves(sleeves);
        System.out.println("Sleeves lades till med TShirtSleevesCommand: " + sleeves);
    }
}
