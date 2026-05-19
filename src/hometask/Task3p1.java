package hometask;

import hometask.enums.Color;
import hometask.figures.Circle;
import hometask.figures.Figure;
import hometask.figures.Square;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static hometask.Task3p2.describe;
import static hometask.Task3p2.generateFigures;

public class Task3p1 {
    private static final int FIGURES_COUNT = 20;
    private static final Color DUPLICATE_FIGURE_COLOR = Color.RED;
    private static final int DUPLICATE_SQUARE_SIDE = 10;
    private static final Color DEFAULT_COLOR = Color.WHITE;
    private static final int DEFAULT_RADIUS = 10;

    public static void run() {
        System.out.println("\n\nTask 3 part 1.\n");

        List<Figure> figures = generateFigures(FIGURES_COUNT);

        System.out.println("Generated figures:");
        figures.forEach(Figure::draw);

        Map<String, List<Figure>> figuresByType = new HashMap<>();
        groupByType(figures,figuresByType);
        uniqueByColor(figures);
        topThree(figures);
        averageAreaByColor(figures);
        unmodifiableCatalog(figures,figuresByType);
    }

    //was moved out from run() to prevent WARNING
    private static void tryToModifyUnmodifiableMap(Map<String, List<Figure>> map) {
        try {
            map.put("Circle", new ArrayList<>());
        } catch (UnsupportedOperationException exception) {
            // Direct changes through this wrapper are forbidden,
            // so put(...) throws UnsupportedOperationException.
            // try/catch does not return the wrapper, but demonstrates
            // the prohibition of changes through it.
            System.out.println("Cannot put into unmodifiable map: " +
                               exception.getClass().getSimpleName());
        }
    }

    static void groupByType(List<Figure> figures, Map<String, List<Figure>> figuresByType) {
        for (Figure figure : figures) {
            String type = figure.getClass().getSimpleName();
            figuresByType.computeIfAbsent(type, key -> new ArrayList<>()).add(figure);
        }

        StringBuilder result = new StringBuilder("\n- Grouping by type:\n");

        for (Map.Entry<String, List<Figure>> entry : figuresByType.entrySet()) {
            double totalArea = 0;

            for (Figure figure : entry.getValue()) {
                totalArea += figure.getArea();
            }

            result.append(entry.getKey())
                    .append(": count=")
                    .append(entry.getValue().size())
                    .append(", total area=")
                    .append(totalArea)
                    .append("\n");
        }

        print(result.toString());
    }

    static void uniqueByColor(List<Figure> figures) {
        Map<String, Set<Figure>> figuresByColor = new HashMap<>();

        for (Figure figure : figures) {
            String color = figure.getColor().toString();
            figuresByColor.computeIfAbsent(color, key -> new HashSet<>()).add(figure);
        }

        Figure firstSquare = new Square(DUPLICATE_FIGURE_COLOR, DUPLICATE_SQUARE_SIDE);
        Figure secondSquare = new Square(DUPLICATE_FIGURE_COLOR, DUPLICATE_SQUARE_SIDE);

        figuresByColor
                .computeIfAbsent(firstSquare.getColor().toString(), key -> new HashSet<>())
                .add(firstSquare);

        figuresByColor
                .computeIfAbsent(secondSquare.getColor().toString(), key -> new HashSet<>())
                .add(secondSquare);

        StringBuilder result = new StringBuilder("\n- Unique figures by color:\n");

        for (Map.Entry<String, Set<Figure>> entry : figuresByColor.entrySet()) {
            result.append(entry.getKey())
                    .append(": unique count=")
                    .append(entry.getValue().size())
                    .append("\n");
        }

        print(result.toString());
    }

    static void topThree(List<Figure> figures) {
        List<Figure> sortedByArea = new ArrayList<>(figures);
        sortedByArea.sort(Comparator.comparing(Figure::getArea).reversed());

        StringBuilder result = new StringBuilder("\n- Top 3 biggest figures:\n");

        for (int i = 0; i < 3 && i < sortedByArea.size(); i++) {
            result.append(describe(sortedByArea.get(i))).append("\n");
        }

        print(result.toString());
    }

    static void averageAreaByColor(List<Figure> figures) {
        Map<String, double[]> areaByColor = new HashMap<>();

        for (Figure figure : figures) {
            String color = figure.getColor().toString();

            areaByColor.merge(
                    color,
                    new double[]{figure.getArea(), 1},
                    (oldValue, newValue) -> {
                        oldValue[0] += newValue[0];
                        oldValue[1] += newValue[1];
                        return oldValue;
                    }
            );
        }

        StringBuilder result = new StringBuilder("\n- Average area by color:\n");

        for (Map.Entry<String, double[]> entry : areaByColor.entrySet()) {
            double average = entry.getValue()[0] / entry.getValue()[1];
            result.append(entry.getKey()).append(" : ").append(average).append("\n");
        }

        print(result.toString());
    }

    static void unmodifiableCatalog(List<Figure> figures, Map<String, List<Figure>> figuresByType) {
        for (Figure figure : figures) {
            String type = figure.getClass().getSimpleName();
            figuresByType.computeIfAbsent(type, key -> new ArrayList<>()).add(figure);
        }

        Map<String, List<Figure>> unmodifiableFiguresByType = Collections.unmodifiableMap(figuresByType);

        StringBuilder result = new StringBuilder("\n- Unmodifiable catalog:\n");

        tryToModifyUnmodifiableMap(unmodifiableFiguresByType);

        figuresByType
                .computeIfAbsent("Circle", key -> new ArrayList<>())
                .add(new Circle(DEFAULT_COLOR, DEFAULT_RADIUS));

        result.append("Circle count through wrapper: ")
                .append(unmodifiableFiguresByType.get("Circle").size())
                .append("\n");

        print(result.toString());
    }

    static synchronized void print(String text) {
        System.out.print(text);
    }
}
