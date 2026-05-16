package hometask.enums;

public enum FigureType {
    CIRCLE("Circle"),
    SQUARE("Square"),
    RECTANGLE("Rectangle"),
    RIGHT_TRIANGLE("Right Triangle"),
    ISOSCELES_TRAPEZOID("Isosceles Trapezoid");

    private final String figureType;

    FigureType(String figureType) {
        this.figureType = figureType;
    }

    @Override
    public String toString() {
        return figureType;
    }
}
