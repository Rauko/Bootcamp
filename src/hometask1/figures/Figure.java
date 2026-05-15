package hometask1.figures;

import hometask1.enums.Color;
import hometask1.enums.FigureType;

public abstract class Figure {
    private final Color color;
    private FigureType figureType;

    public Figure(Color color) {
        this.color = color;
    }

    public abstract double getArea();
    public abstract void draw();

    protected void drawMessage(FigureType figureType, String figureParameters){
        System.out.println("Figure: " + figureType +
                            ", area: " + getArea() + " sq. units" +
                            figureParameters +
                            ", color: " + getColor()
        );
    }

    public Color getColor() {
        return color;
    }
}