import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
public class CompletableFutureAction {

    public void runCompletableFutureAction(int iterations, long sleepTime){
        // Create an array of CompletableFuture
        CompletableFuture<String>[] completableFutures = new CompletableFuture[iterations];

        // Execute tasks asynchronously in a loop
        for (int i = 0; i < iterations; i++) {
            final int index = i;
            completableFutures[i] = CompletableFuture.supplyAsync(() -> {
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        return "Task " + index;
                    });
        }

        // Wait for all CompletableFuture to complete and collect the results
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFutures);

        // Perform other tasks in the main thread

        // Get the results from all CompletableFuture
        try {
            allFutures.get(); // Wait for all tasks to complete
            for (CompletableFuture<String> future : completableFutures) {
                future.get();
                //System.out.println(future.get()); // Retrieve and print the result
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
