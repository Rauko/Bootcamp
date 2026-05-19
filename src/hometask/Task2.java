package hometask;

import hometask.exceptions.FigureNotFoundException;
import hometask.figures.Figure;
import hometask.storage.FigureStorage;
import hometask.utils.AnnotationScanner;
import hometask.utils.FigureSupplier;

public class Task2 {
    public static void run() {
        System.out.println("\n\nTask 2.\n");

        FigureSupplier supplier = new FigureSupplier();
        final int RANDOM_COUNT = 3;
        final int DEFAULT_COUNT = 3;

        FigureStorage<Figure> storage = new FigureStorage<>();

        for (int i = 0; i < RANDOM_COUNT; i++) {
            storage.add(supplier.getRandomFigure());
        }

        for (int i = 0; i < DEFAULT_COUNT; i++) {
            storage.add(supplier.getDefaultFigure());
        }
        System.out.println("FigureStorage<Figure> usage demonstration:");
        for (int i = 0; i < storage.size(); i++) {
            storage.getById(i).draw();
        }

        System.out.println("\nException demonstration:");

        try {
            storage.getById(42).draw();
        } catch (FigureNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nAnnotation demonstration:");
        AnnotationScanner scanner = new AnnotationScanner();
        scanner.printDefaultAreas();
    }
}