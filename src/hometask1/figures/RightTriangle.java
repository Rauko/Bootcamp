package hometask1.figures;

import hometask1.enums.Color;
import hometask1.enums.FigureType;

public class RightTriangle extends Figure {
    private final int firstLeg;
    private final int secondLeg;

    private final FigureType figureType = FigureType.RIGHT_TRIANGLE;

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
        drawMessage(figureType,
                    ", firstLeg: " + firstLeg + " units" +
                            ", secondLeg: " + secondLeg + " units");
    }
}
