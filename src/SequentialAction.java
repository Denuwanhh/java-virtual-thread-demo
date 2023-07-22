import java.time.Duration;
import java.time.Instant;

public class SequentialAction {
    public Long runSequentialAction(int iterations, long sleepTime) {
        Instant actionStart = Instant.now();

        // Create and start multiple threads in a loop
        for (int i = 0; i < iterations; i++) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Duration.between(actionStart, Instant.now()).toNanos();
    }
}
