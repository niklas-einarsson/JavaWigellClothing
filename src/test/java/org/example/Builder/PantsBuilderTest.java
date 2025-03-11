package org.example.Builder;

import org.example.Clothes.Pants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PantsBuilderTest {

    private PantsBuilder pantsBuilder;

    @BeforeEach
    void setUp() {
        pantsBuilder = new PantsBuilder();
    }


    @Test
    void SizeShouldEqualSmall() {
        Pants pants = pantsBuilder.addSize("Small").addColor("Black").addMaterial("Denim").build();
        assertEquals("Small", pants.getSize());
    }

    @Test
    void SizeShouldThrowExceptionWhenNull() {
        PantsBuilder builder = new PantsBuilder().addColor("Black").addMaterial("Denim");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, builder::build);
        assertEquals("Size for pants is null", exception.getMessage());
    }


    @Test
    void ColorShouldEqualBlack() {
        Pants pants = new PantsBuilder().addSize("Medium").addColor("Black").addMaterial("Leather").build();
        assertEquals("Black", pants.getColor());
    }

    @Test
    void ColorShouldThrowExceptionWhenNull() {
        PantsBuilder builder = new PantsBuilder().addSize("Large").addMaterial("Denim");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, builder::build);
        assertEquals("Color for pants is null", exception.getMessage());
    }

    @Test
    void MaterialShouldEqualDenim() {
        Pants pants = new PantsBuilder().addSize("Medium").addColor("Black").addMaterial("Denim").build();
        assertEquals("Denim", pants.getMaterial());
    }

    @Test
    void MaterialShouldThrowExceptionWhenNull() {
        PantsBuilder builder = new PantsBuilder().addSize("Medium").addColor("Black").addMaterial(null);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, builder::build);
        assertEquals("Material for pants is null", exception.getMessage());
    }

    @Test
    void build() {
    }
}