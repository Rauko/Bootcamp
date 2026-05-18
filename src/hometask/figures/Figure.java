package hometask.figures;

import hometask.enums.Color;
import hometask.enums.FigureType;

import java.util.Objects;

public abstract class Figure {
    private final Color color;

    public Figure(Color color) {
        this.color = color;
    }

    public abstract double getArea();
    public abstract void draw();

    protected void drawMessage(FigureType figureType, String figureParameters) {
        System.out.println("Figure: " + figureType +
                            ", area: " + getArea() + " sq. units" +
                            figureParameters +
                            ", color: " + getColor());
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Figure figure = (Figure) o;
        return color == figure.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}