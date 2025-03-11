package org.example.Command;

import org.example.Clothes.Clothes;
import org.example.Clothes.Pants;

public class PantsLengthCommand implements ClothingDetailCommand {

    private String length;

    public PantsLengthCommand(String length) {
        this.length = length;
    }


    @Override
    public void process(Clothes clothes) {
        Pants pants = (Pants) clothes;
        pants.setLength(length);
        System.out.println("Length lades till med PantsLengtCommand: " + length);




    }
}
