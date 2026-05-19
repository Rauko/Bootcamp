package hometask.figures;

import hometask.enums.Color;
import hometask.enums.FigureType;

import java.util.Objects;

public class IsoscelesTrapezoid extends Figure {
    private final int topBase;
    private final int bottomBase;
    private final int height;

    private static final FigureType FIGURE_TYPE =  FigureType.ISOSCELES_TRAPEZOID;

    public IsoscelesTrapezoid(Color color,
                              int topBase,
                              int bottomBase,
                              int height) {
        super(color);
        this.topBase = topBase;
        this.bottomBase = bottomBase;
        this.height = height;
    }

    @Override
    public double getArea() {
        return ((topBase + bottomBase) * height) / 2.0;
    }

    @Override
    public void draw() {
        drawMessage(FIGURE_TYPE,
                    ", topBase: " + topBase + " units" +
                    ", bottomBase: " + bottomBase + " units" +
                    ", height: " + height + " units");
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }

        IsoscelesTrapezoid that = (IsoscelesTrapezoid) o;
        return topBase == that.topBase
                && bottomBase == that.bottomBase
                && height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), topBase, bottomBase, height);
    }
}
