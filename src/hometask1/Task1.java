package hometask1;

import hometask1.figures.Figure;
import hometask1.utils.FigureSupplier;

public class Task1 {
    public static void run() {

        System.out.println("Task 1.");

        FigureSupplier supplier =
                new FigureSupplier();

        Figure[] figures = new Figure[6];

        for (int i = 0; i < 3; i++) {

            figures[i] =
                    supplier.getRandomFigure();
        }

        for (int i = 3; i < figures.length; i++) {

            figures[i] =
                    supplier.getDefaultFigure();
        }

        for (Figure figure : figures) {

            figure.draw();
        }
    }
}