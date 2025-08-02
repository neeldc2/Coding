package javatest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

    public static void main(String[] args) {
        // Create a ThreadPoolExecutor with 2 core threads, 4 max threads, and a 30-second keep-alive time
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                  // core pool size
                40,                  // maximum pool size
                30,                 // keep-alive time
                TimeUnit.SECONDS,    // time unit for keep-alive time
                new LinkedBlockingQueue<Runnable>(2)  // work queue
        );

        // Submit tasks to the executor
        for (int i = 0; i < 15; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing a task");
                try {
                    Thread.sleep(1000); // Simulate task processing
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Shutdown the executor after tasks are completed
        executor.shutdown();

        ExecutorService executor2 = Executors.newSingleThreadExecutor();

        // First task (will execute first)
        executor2.submit(() -> {
            try {
                System.out.println("First task started");
                Thread.sleep(3000);  // Simulate a task that takes 3 seconds
                System.out.println("First task completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Second task (will execute after the first task)
        executor2.submit(() -> {
            System.out.println("Second task completed");
        });

        executor.shutdown();

    }

}
