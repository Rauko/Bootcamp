package hometask;

import hometask.enums.Color;
import hometask.figures.Circle;
import hometask.figures.Figure;
import hometask.utils.FigureSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task3p2 {
    private static final int FIGURES_COUNT = 15;
    private static final double LARGE_AREA_LIMIT = 50.0;

    public static void run() {
        System.out.println("\n\nTask 3 part 2.\n");

        List<Figure> figures = generateFigures();

        System.out.println("Generated figures:");
        figures.forEach(Figure::draw);

        System.out.println("\n- Lambda + filter + count:");
        Predicate<Figure> isLarge = figure -> figure.getArea() > LARGE_AREA_LIMIT;
        Predicate<Figure> isRed = figure -> figure.getColor().equals(Color.RED);

        long largeCount = figures.stream()
                                 .filter(isLarge)
                                 .count();

        long largeAndRedCount = figures.stream()
                                       .filter(isLarge.and(isRed))
                                       .count();

        System.out.println("Large figures count: " + largeCount);
        System.out.println("Large and red figures count: " + largeAndRedCount);

        System.out.println("\n- Map + collect - descriptions:");
        List<String> descriptions = figures.stream()
                                        .map(Task3p2::describe)
                                        .collect(Collectors.toList());

        descriptions.forEach(System.out::println);

        System.out.println("\n- GroupingBy - count by type:");
        Map<String, Long> countByType = figures.stream()
                                            .collect(Collectors.groupingBy(
                                                figure -> figure.getClass().getSimpleName(),
                                                Collectors.counting()
                                            ));

        System.out.println(countByType);

        System.out.println("\n- Optional task - first circle:");
        Optional<Figure> firstCircle = figures.stream()
                                            .filter(figure -> figure instanceof Circle)
                                            .findFirst();

        String firstCircleDescription = firstCircle
                                            .map(Task3p2::describe)
                                            .orElse("no circle in the list");

        System.out.println(firstCircleDescription);

        System.out.println("\n- Optional task - list without circles:");
        List<Figure> figuresWithoutCircles = new ArrayList<>(figures);
        figuresWithoutCircles.removeIf(figure -> figure instanceof Circle);

        String firstCircleInFilteredList = figuresWithoutCircles.stream()
                                                .filter(figure -> figure instanceof Circle)
                                                .findFirst()
                                                .map(Task3p2::describe)
                                                .orElse("no circle in the list");

        System.out.println(firstCircleInFilteredList);
    }

    private static String describe(Figure figure) {
        return figure.getClass().getSimpleName() +
                            "[" + figure.getColor() + "]" +
                            " area=" + figure.getArea();
    }

    private static List<Figure> generateFigures() {
        FigureSupplier figureSupplier = new FigureSupplier();
        List<Figure> figures = new ArrayList<>();

        for (int i = 0; i < Task3p2.FIGURES_COUNT; i++) {
            figures.add(figureSupplier.getRandomFigure());
        }

        return figures;
    }
}
