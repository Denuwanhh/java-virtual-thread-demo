package com.process;

import com.task.CPUIntensiveTask;
import com.task.IOIntensiveTask;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureAction {

    public Long runCompletableFutureAction(int iterations, long sleepTime) {
        // Create an array of CompletableFuture
        CompletableFuture<String>[] completableFutures = new CompletableFuture[iterations];

        Instant actionStart = Instant.now();

        // Execute tasks asynchronously in a loop
        for (int i = 0; i < iterations; i++) {
            final int index = i;
            completableFutures[i] = CompletableFuture.supplyAsync(() -> {

//                        try {
//                            //Thread.sleep(sleepTime);
//
//
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }

//                IOIntensiveTask ioInt = new IOIntensiveTask();
//                ioInt.runIOIntensiveTask("D:\\Projects\\java-virtual-thread-demo\\resources\\File.txt");

                CPUIntensiveTask cpuInt = new CPUIntensiveTask();
                cpuInt.runCPUIntensiveTask();

                return "Task " + index;
            });
        }

        // Wait for all CompletableFuture to complete and collect the results
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFutures);

        // Get the results from all CompletableFuture
        try {
            allFutures.get(); // Wait for all tasks to complete
            for (CompletableFuture<String> future : completableFutures) {
                future.get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return Duration.between(actionStart, Instant.now()).toMillis();
    }

}
