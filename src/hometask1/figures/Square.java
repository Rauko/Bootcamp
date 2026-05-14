package hometask1.figures;

import hometask1.enums.Color;


public class Square extends Figure {

    private final double side;

    public Square(Color color, double side) {
        super(color);
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public void draw() {

        System.out.println(
                        "Figure: Square" +
                        ", area: " + getArea() +
                        ", side: " + side +
                        ", color: " + getColor()
        );

    }

}