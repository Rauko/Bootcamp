package hometask;

import hometask.exceptions.FigureNotFoundException;
import hometask.figures.Figure;
import hometask.storage.FigureStorage;
import hometask.utils.AnnotationScanner;
import hometask.utils.FigureSupplier;

public class Task2 {
    public static void run() {
        System.out.println("Task 2.");

        FigureSupplier supplier = new FigureSupplier();
        final int RANDOM_COUNT = 3;
        final int DEFAULT_COUNT = 3;
        final int TOTAL_COUNT = RANDOM_COUNT + DEFAULT_COUNT;

        Figure[] figures = new Figure[TOTAL_COUNT];

        FigureStorage<Figure> storage = new FigureStorage<>();

        for (Figure figure : figures) {
            storage.add(figure);
        }

        try {
            storage.getById(42).draw();
        } catch (FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(
                "Program still works"
        );

        AnnotationScanner scanner = new AnnotationScanner();

        scanner.printDefaultAreas();
    }
}