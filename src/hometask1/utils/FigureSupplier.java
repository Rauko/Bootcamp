package hometask1.utils;

import hometask1.enums.Color;
import hometask1.figures.*;

import java.util.Random;

public class FigureSupplier {
    private final Random random = new Random();

    private final ColorSupplier colorSupplier =
            new ColorSupplier();

    public Figure getRandomFigure() {

        int type = random.nextInt(5);

        Color color =
                colorSupplier.getRandomColor();

        switch (type) {

            case 0:
                return new Square(
                        color,
                        random.nextInt(20) + 1
                );

            case 1:
                return new Rectangle(
                        color,
                        random.nextInt(20) + 1,
                        random.nextInt(20) + 1
                );

            case 2:
                return new Circle(
                        color,
                        random.nextInt(15) + 1
                );

            case 3:
                return new RightTriangle(
                        color,
                        random.nextInt(20) + 1,
                        random.nextInt(20) + 1
                );

            default:
                return new IsoscelesTrapezoid(
                        color,
                        random.nextInt(10) + 1,
                        random.nextInt(20) + 10,
                        random.nextInt(15) + 1
                );
        }
    }

    public Figure getDefaultFigure() {

        return new Circle(Color.WHITE, 10);
    }
}
