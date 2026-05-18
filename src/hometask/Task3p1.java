package hometask;

import hometask.enums.Color;
import hometask.figures.Circle;
import hometask.figures.Figure;
import hometask.figures.Square;
import hometask.utils.FigureSupplier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task3p1 {
    private static final int FIGURES_COUNT = 20;
    private static final Color DUPLICATE_FIGURE_COLOR = Color.RED;
    private static final int DUPLICATE_SQUARE_SIDE = 10;
    private static final Color DEFAULT_COLOR = Color.WHITE;
    private static final int DEFAULT_RADIUS = 10;

    public static void run() {
        System.out.println("\n\nTask 3 part 1.\n");

        FigureSupplier figureSupplier = new FigureSupplier();
        List<Figure> figures = new ArrayList<>();

        for(int i = 0; i < FIGURES_COUNT; i++) {
            figures.add(figureSupplier.getRandomFigure());
        }

        System.out.println("Generated figures:");
        for(Figure figure : figures) {
            figure.draw();
        }

        System.out.println("\n- Grouping by type:");
        Map<String, List<Figure>> figuresByType = new HashMap<>();

        for(Figure figure : figures) {
            String type = figure.getClass().getSimpleName();
            figuresByType.computeIfAbsent(type, k -> new ArrayList<>()).add(figure);
        }

        for(Map.Entry<String, List<Figure>> entry : figuresByType.entrySet()) {
           double totalArea = 0;
           for(Figure figure : entry.getValue()) {
               totalArea += figure.getArea();
           }

            System.out.println(entry.getKey() +
                               ": count=" + entry.getValue().size() +
                               ", total area=" + totalArea);
        }

        System.out.println("\n- Unique figures by color:");
        Map<String, Set<Figure>> figuresByColor = new HashMap<>();

        for(Figure figure : figures) {
            String color = figure.getColor().toString();
            figuresByColor.computeIfAbsent(color, k -> new HashSet<>()).add(figure);
        }

        //2 identical figures by task
        Figure firstSquare = new Square(DUPLICATE_FIGURE_COLOR, DUPLICATE_SQUARE_SIDE);
        Figure secondSquare = new Square(DUPLICATE_FIGURE_COLOR, DUPLICATE_SQUARE_SIDE);

        figuresByColor.computeIfAbsent(firstSquare.getColor().toString(), key -> new HashSet<>())
                      .add(firstSquare);
        figuresByColor.computeIfAbsent(secondSquare.getColor().toString(), key -> new HashSet<>())
                      .add(secondSquare);

        for(Map.Entry<String, Set<Figure>> entry : figuresByColor.entrySet()) {
            System.out.println(entry.getKey() + ": unique count=" + entry.getValue().size());
        }

        System.out.println("\n- Top 3 biggest figures:");
        List<Figure> sortedByArea = new ArrayList<>(figures);
        sortedByArea.sort(Comparator.comparing(Figure::getArea).reversed());

        for (int i = 0; i < 3 && i < sortedByArea.size(); i++) {
            Figure figure = sortedByArea.get(i);

            System.out.println(figure.getClass().getSimpleName() +
                               " [" + figure.getColor() + "]" +
                               " area=" + figure.getArea());
        }

        System.out.println("\n- Average area by color:");
        Map<String, double[]> areaByColor = new HashMap<>();

        for (Figure figure : figures) {
            String color = figure.getColor().toString();

            areaByColor.merge(color,
                              new double[]{figure.getArea(), 1},
                              (oldValue, newValue) -> {
                                    oldValue[0] += newValue[0];
                                    oldValue[1] += newValue[1];
                                    return oldValue;
                              }
            );
        }

        for (Map.Entry<String, double[]> entry : areaByColor.entrySet()) {
            double average = entry.getValue()[0] / entry.getValue()[1];
            System.out.println(entry.getKey() + " : " + average);
        }

        System.out.println("\n5) Unmodifiable catalog:");
        Map<String, List<Figure>> unmodifiableFiguresByType = Collections.unmodifiableMap(figuresByType);

        tryToModifyUnmodifiableMap(unmodifiableFiguresByType);

        //this will add +1 to counter as a proof that Collections.unmodifiableMap(...)
        //does not create a copy but creates an unmodifiable wrapper over the original map.
        figuresByType.computeIfAbsent("Circle", key -> new ArrayList<>())
                     .add(new Circle(DEFAULT_COLOR, DEFAULT_RADIUS));

        System.out.println("Circle count through wrapper: " +
                           unmodifiableFiguresByType.get("Circle").size());
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
}
