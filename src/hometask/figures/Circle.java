package hometask.figures;

import hometask.annotations.DefaultArea;
import hometask.enums.Color;
import hometask.enums.FigureType;

public class Circle extends Figure {
    private final int radius;

    private final FigureType figureType = FigureType.CIRCLE;

    public Circle(Color color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    @DefaultArea
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw() {
        drawMessage(figureType,
                    ", radius: " + radius + " units");
    }
}
