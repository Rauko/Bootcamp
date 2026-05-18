package hometask;

import hometask.figures.Figure;
import hometask.utils.FigureSupplier;

public class Task1 {
    public static void run() {
        System.out.println("Task 1.");

        FigureSupplier supplier = new FigureSupplier();
        final int RANDOM_COUNT = 3;
        final int DEFAULT_COUNT = 3;
        final int TOTAL_COUNT = RANDOM_COUNT + DEFAULT_COUNT;

        Figure[] figures = new Figure[TOTAL_COUNT];

        for (int i = 0; i < RANDOM_COUNT; i++) {
            figures[i] = supplier.getRandomFigure();
        }

        for (int i = RANDOM_COUNT; i < figures.length; i++) {
            figures[i] = supplier.getDefaultFigure();
        }

        for (Figure figure : figures) {
            figure.draw();
        }
    }
}