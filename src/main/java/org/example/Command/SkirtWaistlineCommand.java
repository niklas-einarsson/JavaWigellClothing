package org.example.Command;

import org.example.Clothes.Clothes;
import org.example.Clothes.Skirt;

public class SkirtWaistlineCommand implements ClothingDetailCommand {

    private String waistline;

    public SkirtWaistlineCommand(String waistline) {
        this.waistline = waistline;
    }

    @Override
    public void process(Clothes clothes) {
        Skirt skirt = (Skirt) clothes;
        skirt.setWaistline(waistline);
        System.out.println("Waistline lades till med SkirtWaistlineCommand: " + waistline);
    }
}
