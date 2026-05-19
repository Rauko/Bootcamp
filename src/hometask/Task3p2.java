package hometask;

import hometask.enums.Color;
import hometask.figures.Circle;
import hometask.figures.Figure;
import hometask.utils.FigureSupplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static hometask.Task3p1.print;

public class Task3p2 {
    private static final int FIGURES_COUNT = 15;
    private static final double LARGE_AREA_LIMIT = 50.0;

    public static void run() {
        System.out.println("\n\nTask 3 part 2.\n");

        List<Figure> figures = generateFigures(FIGURES_COUNT);

        System.out.println("Generated figures:");
        figures.forEach(Figure::draw);

        predicateCount(figures);
        descriptions(figures);
        groupingByType(figures);
        firstCircle(figures);
    }

    static String describe(Figure figure) {
        return figure.getClass().getSimpleName() +
                            "[" + figure.getColor() + "]" +
                            " area=" + figure.getArea();
    }

    static List<Figure> generateFigures(int figuresCount) {
        FigureSupplier figureSupplier = new FigureSupplier();
        List<Figure> figures = new ArrayList<>();

        for (int i = 0; i < figuresCount; i++) {
            figures.add(figureSupplier.getRandomFigure());
        }

        return figures;
    }

    static void predicateCount(List<Figure> figures) {
        Predicate<Figure> isLarge = figure -> figure.getArea() > LARGE_AREA_LIMIT;
        Predicate<Figure> isRed = figure -> figure.getColor() == Color.RED;

        long largeCount = figures.stream()
                .filter(isLarge)
                .count();

        long largeAndRedCount = figures.stream()
                .filter(isLarge.and(isRed))
                .count();

        print("\n- Lambda + filter + count:\n" +
                "Large figures count: " + largeCount + "\n" +
                "Large and red figures count: " + largeAndRedCount + "\n");
    }

    static void descriptions(List<Figure> figures) {
        List<String> descriptions = figures.stream()
                .map(Task3p2::describe)
                .collect(Collectors.toList());

        print("\n- Map + collect - descriptions:\n" + String.join("\n", descriptions) + "\n");
    }

    static void groupingByType(List<Figure> figures) {
        Map<String, Long> countByType = figures.stream()
                .collect(Collectors.groupingBy(
                        figure -> figure.getClass().getSimpleName(),
                        Collectors.counting()
                ));

        print("\n- GroupingBy - count by type:\n"
                + countByType
                + "\n");
    }

    static void firstCircle(List<Figure> figures) {
        StringBuilder result = new StringBuilder("\n- Optional - first circle:\n");

        result.append(firstCircleDescription(figures)).append("\n");

        List<Figure> figuresWithoutCircles = new ArrayList<>(figures);
        figuresWithoutCircles.removeIf(figure -> figure instanceof Circle);

        result.append("Without circles: ")
                .append(firstCircleDescription(figuresWithoutCircles))
                .append("\n");

        print(result.toString());
    }

    private static String firstCircleDescription(List<Figure> figures) {
        return figures.stream()
                .filter(figure -> figure instanceof Circle)
                .findFirst()
                .map(Task3p2::describe)
                .orElse("no circle in the list");
    }
}
