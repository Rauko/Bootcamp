package hometask1.figures;

import hometask1.enums.Color;
import hometask1.enums.FigureType;

public class Circle extends Figure {
    private final int radius;

    private final FigureType figureType = FigureType.CIRCLE;

    public Circle(Color color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        drawMessage(figureType,
                    ", radius: " + radius + " units");
    }
}
