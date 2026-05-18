package hometask.figures;

import hometask.annotations.DefaultArea;
import hometask.enums.Color;
import hometask.enums.FigureType;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }

        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }
}
