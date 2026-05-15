package hometask1.figures;

import hometask1.enums.Color;
import hometask1.enums.FigureType;

public class Rectangle extends Figure {

    private final int width;
    private final int height;

    private final FigureType figureType = FigureType.RECTANGLE;

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
        drawMessage( figureType,
                    ", width: " + width + " units" +
                            ", height: " + height + " units");
    }
}
