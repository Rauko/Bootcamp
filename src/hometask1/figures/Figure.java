package hometask1.figures;

import hometask1.enums.Color;

public abstract class Figure {

    private Color color;

    public Figure(Color color) {
        this.color = color;
    }

    public abstract double getArea();

    public abstract void draw();

    //Getters and setters

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}