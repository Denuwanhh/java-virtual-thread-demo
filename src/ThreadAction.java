import java.time.Duration;
import java.time.Instant;

public class ThreadAction {

    public Long runThreadAction(int iterations, long sleepTime){
        Thread threads[] = new Thread[iterations];

        Instant actionStart = Instant.now();

        // Create and start multiple threads in a loop
        for (int i = 0; i < iterations; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
                // Perform the task within the thread
                // Simulate some work
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            threads[i].start(); // Start the thread
        }

        for (Thread thread : threads) {
            try {
                thread.join(); // Wait for thread to complete
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Duration.between(actionStart, Instant.now()).toNanos();
    }
}
