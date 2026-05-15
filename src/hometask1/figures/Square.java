package hometask1.figures;

import hometask1.enums.Color;
import hometask1.enums.FigureType;

public class Square extends Figure {
    private final int side;

    private final FigureType figureType = FigureType.SQUARE;

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
        drawMessage(figureType,
                    ", side: " + side + " units");
    }
}