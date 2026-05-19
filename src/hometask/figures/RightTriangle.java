package hometask.figures;

import hometask.enums.Color;
import hometask.enums.FigureType;

import java.util.Objects;

public class RightTriangle extends Figure {
    private final int firstLeg;
    private final int secondLeg;

    private static final FigureType FIGURE_TYPE = FigureType.RIGHT_TRIANGLE;

    public RightTriangle(Color color,
                         int firstLeg,
                         int secondLeg) {
        super(color);
        this.firstLeg = firstLeg;
        this.secondLeg = secondLeg;
    }

    @Override
    public double getArea() {
        return (firstLeg * secondLeg) / 2.0;
    }

    @Override
    public void draw() {
        drawMessage(FIGURE_TYPE,
                    ", firstLeg: " + firstLeg + " units" +
                    ", secondLeg: " + secondLeg + " units");
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }

        RightTriangle that = (RightTriangle) o;
        return firstLeg == that.firstLeg
                && secondLeg == that.secondLeg;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstLeg, secondLeg);
    }
}
