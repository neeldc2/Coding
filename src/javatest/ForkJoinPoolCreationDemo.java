package javatest;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolCreationDemo {
    public static void main(String[] args) {
        System.out.println("Program started");
        // At this point, the common pool hasn't been created yet
        System.out.println("Common pool parallelism before access: " +
                System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism"));
        // This will trigger the creation of the common pool
        int parallelism = ForkJoinPool.getCommonPoolParallelism();
        System.out.println("Common pool parallelism: " + parallelism);
        // Now the common pool exists and we can get more information about it
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        System.out.println("Common pool size: " + commonPool.getPoolSize());
        System.out.println("Common pool running thread count: " + commonPool.getRunningThreadCount());
        // Creating a custom ForkJoinPool
        ForkJoinPool customPool = new ForkJoinPool(2);
        System.out.println("Custom pool parallelism: " + customPool.getParallelism());
        customPool.shutdown(); // Remember to shut down custom pools when done
    }
}
