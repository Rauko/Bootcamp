package hometask.figures;

import hometask.enums.Color;
import hometask.enums.FigureType;

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
}
