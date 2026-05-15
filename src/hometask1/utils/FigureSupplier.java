package hometask1.utils;

import hometask1.enums.Color;
import hometask1.enums.FigureType;
import hometask1.figures.Circle;
import hometask1.figures.Figure;
import hometask1.figures.Rectangle;
import hometask1.figures.Square;
import hometask1.figures.RightTriangle;
import hometask1.figures.IsoscelesTrapezoid;

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
        int type = random.nextInt(FIGURE_COUNT);
        Color color = colorSupplier.getRandomColor();

        switch (type) {
            case 0:
                return new Square(color,
                                random.nextInt(MAX_SIDE) + 1
                );

            case 1:
                return new Rectangle(color,
                                random.nextInt(MAX_SIDE) + 1,
                                random.nextInt(MAX_SIDE) + 1
                );

            case 2:
                return new Circle(color,
                                random.nextInt(MAX_RADIUS) + 1
                );

            case 3:
                return new RightTriangle(color,
                                random.nextInt(MAX_SIDE) + 1,
                                random.nextInt(MAX_SIDE) + 1
                );

            case 4:
                return new IsoscelesTrapezoid(color,
                                random.nextInt(MAX_TOP_BASE) + 1,
                                random.nextInt(MAX_SIDE) + 10,
                                random.nextInt(MAX_HEIGHT) + 1
                );

            default:
                throw new IllegalStateException();
        }
    }

    public Figure getDefaultFigure() {
        return new Circle(DEFAULT_COLOR, DEFAULT_RADIUS);
    }
}
