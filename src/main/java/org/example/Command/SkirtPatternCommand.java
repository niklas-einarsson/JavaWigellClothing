package org.example.Command;

import org.example.Clothes.Clothes;
import org.example.Clothes.Skirt;

public class SkirtPatternCommand implements ClothingDetailCommand {

    private String pattern;

    public SkirtPatternCommand(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void process(Clothes clothes) {
        Skirt skirt = (Skirt) clothes;
        skirt.setPattern(pattern);
        System.out.println("Pattern lades till med SkirtPatternCommand: " + pattern);
    }
}
