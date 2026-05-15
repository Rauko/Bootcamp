package hometask1.utils;

import hometask1.enums.Color;

import java.util.Random;

public class ColorSupplier {

    private final Random random = new Random();

    public Color getRandomColor() {
        Color[] colors = Color.values();
        int index = random.nextInt(colors.length);

        return colors[index];
    }
}
