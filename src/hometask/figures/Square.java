package hometask.figures;

import hometask.enums.Color;
import hometask.enums.FigureType;

import java.util.Objects;

public class Square extends Figure {
    private final int side;

    private static final FigureType FIGURE_TYPE = FigureType.SQUARE;

    public Square(Color color, int side) {
        super(color);
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public void draw() {
        drawMessage(FIGURE_TYPE,
                    ", side: " + side + " units");
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }

        Square square = (Square) o;
        return side == square.side;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), side);
    }
}