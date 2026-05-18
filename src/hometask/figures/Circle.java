package hometask.figures;

import hometask.annotations.DefaultArea;
import hometask.enums.Color;
import hometask.enums.FigureType;

public class Circle extends Figure {
    private final int radius;

    private static final FigureType FIGURE_TYPE = FigureType.CIRCLE;

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
        drawMessage(FIGURE_TYPE,
                    ", radius: " + radius + " units");
    }
}
