package org.example.Command;

import org.example.Clothes.Clothes;
import org.example.Clothes.Pants;

public class PantsFitCommand implements ClothingDetailCommand {

    private String fit;

    public PantsFitCommand(String fit) {
        this.fit = fit;
    }

    @Override
    public void process(Clothes clothes) {
        Pants pants = (Pants) clothes;
        pants.setFit(fit);
        System.out.println("Fit lades till med PantsFitCommand: " + pants.getFit());
    }


}
