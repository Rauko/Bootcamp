package hometask.figures;

import hometask.enums.Color;
import hometask.enums.FigureType;

import java.util.Objects;

public class Rectangle extends Figure {
    private final int width;
    private final int height;

    private static final FigureType FIGURE_TYPE = FigureType.RECTANGLE;

    public Rectangle(Color color,
                     int width,
                     int height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void draw() {
        drawMessage(FIGURE_TYPE,
                    ", width: " + width + " units" +
                    ", height: " + height + " units");
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }

        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width
                && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, height);
    }
}
