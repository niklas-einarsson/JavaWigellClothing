package org.example;

import org.example.Clothes.Clothes;
import org.example.Command.ClothingDetailCommand;

import java.util.ArrayList;

public class ClothingDetailPipeline {

    private ArrayList<ClothingDetailCommand> pipeline =  new ArrayList<>();

    public void addCommand(ClothingDetailCommand command) {
        pipeline.add(command);
    }

    public Clothes execute(Clothes clothes) {
        for (ClothingDetailCommand command : pipeline) {
        command.process(clothes);
        }
        return clothes;

    }
}
