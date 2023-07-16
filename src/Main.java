import java.time.Duration;
import java.time.Instant;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int iterations = 1000;
        long sleepTime = 100;

        Instant actionStart = Instant.now();

        CompletableFutureAction completableFutureAction  = new CompletableFutureAction();
        completableFutureAction.runCompletableFutureAction(iterations, sleepTime);

        System.out.println("Completable Future Action total elapsed time : " + Duration.between(actionStart, Instant.now()).toMillis());

        actionStart = Instant.now();

        ThreadAction threadAction = new ThreadAction();
        threadAction.runThreadAction(iterations, sleepTime);

        System.out.println("Thread Action total elapsed time : " + Duration.between(actionStart, Instant.now()).toMillis());

        actionStart = Instant.now();

        VirtualThreadAction virtualThreadAction = new VirtualThreadAction();
        virtualThreadAction.runVirtualThreadAction(iterations, sleepTime);

        System.out.println("Virtual Thread Action elapsed time : " + Duration.between(actionStart, Instant.now()).toMillis());
    }
}