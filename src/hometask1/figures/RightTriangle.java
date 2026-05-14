package hometask1.figures;

import hometask1.enums.Color;

public class RightTriangle extends Figure {

    private final double firstLeg;
    private final double secondLeg;

    public RightTriangle(Color color,
                         double firstLeg,
                         double secondLeg) {

        super(color);

        this.firstLeg = firstLeg;
        this.secondLeg = secondLeg;
    }

    @Override
    public double getArea() {
        return (double) (firstLeg * secondLeg) / 2;
    }

    @Override
    public void draw() {

        System.out.println(
                "Figure: Right Triangle" +
                        ", area: " + getArea() +
                        " sq. units" +
                        ", firstLeg: " + firstLeg +
                        " units" +
                        ", secondLeg: " + secondLeg +
                        " units" +
                        ", color: " + getColor()
        );
    }
}
