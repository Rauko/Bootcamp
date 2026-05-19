package hometask.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SimpleThreadPool {
    private final Queue<Runnable> tasks = new LinkedList<>();
    private final List<Thread> workers = new ArrayList<>();
    private boolean isShutdown;

    public SimpleThreadPool(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            Thread worker = new Thread(this::runWorker, "task4-worker-" + (i + 1));
            workers.add(worker);
            worker.start();
        }
    }

    public void execute(Runnable task) {
        synchronized (tasks) {
            if (isShutdown) {
                throw new IllegalStateException("Thread pool is already shut down");
            }

            tasks.add(task);
            tasks.notify();
        }
    }

    public void shutdown() {
        synchronized (tasks) {
            isShutdown = true;
            tasks.notifyAll();
        }
    }

    public void awaitTermination() throws InterruptedException {
        for (Thread worker : workers) {
            worker.join();
        }
    }

    private void runWorker() {
        while (true) {
            Runnable task;

            synchronized (tasks) {
                while (tasks.isEmpty() && !isShutdown) {
                    try {
                        tasks.wait();
                    } catch (InterruptedException exception) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                if (tasks.isEmpty()) {
                    return;
                }

                task = tasks.poll();
            }

            try {
                task.run();
            } catch (RuntimeException exception) {
                System.out.println(Thread.currentThread().getName() +  " failed: " + exception.getMessage());
            }
        }
    }

    public int getThreadCount() {
        return workers.size();
    }
}