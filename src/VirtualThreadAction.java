import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreadAction {

    public void runVirtualThreadAction(int iterations, long sleepTime) {
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        Future<?>[] virtualThreads = new Future[iterations];

        // Create and start multiple threads in a loop
        for (int i = 0; i < iterations; i++) {
            final int index = i;
            virtualThreads[i] = executor.submit(() -> {
                // Perform the task within the thread
                //System.out.println("Thread " + index + " started");
                // Simulate some work
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println("Thread " + index + " completed");
            });
        }

        for (Future thread : virtualThreads) {
            try {
                thread.get(); // Wait for thread to complete
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
