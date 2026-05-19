package hometask;

import hometask.figures.Figure;
import hometask.utils.SimpleThreadPool;

import java.util.List;

import static hometask.Task3p2.generateFigures;

public class Task4 {
    private static final int FIGURES_COUNT = 20;
    private static final int WORKER_THREAD_COUNT = 4;

    public static void run() throws InterruptedException {
        System.out.println("\n\nTask 4.\n");

        List<Figure> figures = generateFigures(FIGURES_COUNT);

        System.out.println("Generated figures:");
        figures.forEach(Figure::draw);

        SimpleThreadPool threadPool = new SimpleThreadPool(WORKER_THREAD_COUNT);

        System.out.println("\nCreated threads count: " + threadPool.getThreadCount());

        threadPool.execute(() -> Task3p1.uniqueByColor(figures));
        threadPool.execute(() -> Task3p1.topThree(figures));
        threadPool.execute(() -> Task3p1.averageAreaByColor(figures));

        threadPool.execute(() -> Task3p2.predicateCount(figures));
        threadPool.execute(() -> Task3p2.descriptions(figures));
        threadPool.execute(() -> Task3p2.groupingByType(figures));
        threadPool.execute(() -> Task3p2.firstCircle(figures));

        threadPool.shutdown();
        threadPool.awaitTermination();
    }
}
