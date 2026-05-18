package hometask.utils;

import hometask.enums.Color;
import hometask.enums.FigureType;
import hometask.figures.Circle;
import hometask.figures.Figure;
import hometask.figures.Rectangle;
import hometask.figures.Square;
import hometask.figures.RightTriangle;
import hometask.figures.IsoscelesTrapezoid;

import java.util.Random;

public class FigureSupplier {
    private final Random random = new Random();
    private final ColorSupplier colorSupplier = new ColorSupplier();
    private static final int FIGURE_COUNT = FigureType.values().length;

    private static final int MAX_SIDE = 20;
    private static final int MAX_RADIUS = 15;
    private static final int MAX_TOP_BASE = 10;
    private static final int MAX_HEIGHT = 15;

    private static final Color DEFAULT_COLOR = Color.WHITE;
    private static final int DEFAULT_RADIUS = 10;

    public Figure getRandomFigure() {
        FigureType type = FigureType.values()[random.nextInt(FIGURE_COUNT)];
        Color color = colorSupplier.getRandomColor();

        switch (type) {
            case SQUARE:
                return new Square(color,random.nextInt(MAX_SIDE) + 1);

            case RECTANGLE:
                return new Rectangle(color,random.nextInt(MAX_SIDE) + 1,
                                           random.nextInt(MAX_SIDE) + 1
                );

            case CIRCLE:
                return new Circle(color,random.nextInt(MAX_RADIUS) + 1);

            case RIGHT_TRIANGLE:
                return new RightTriangle(color,random.nextInt(MAX_SIDE) + 1,
                                               random.nextInt(MAX_SIDE) + 1
                );

            case ISOSCELES_TRAPEZOID:
                return new IsoscelesTrapezoid(color,random.nextInt(MAX_TOP_BASE) + 1,
                                                    random.nextInt(MAX_SIDE) + 10,
                                                    random.nextInt(MAX_HEIGHT) + 1
                );

            default:
                throw new IllegalStateException("Unknown figure type: " + type);
        }
    }

    public Figure getDefaultFigure() {
        return new Circle(DEFAULT_COLOR, DEFAULT_RADIUS);
    }
}
