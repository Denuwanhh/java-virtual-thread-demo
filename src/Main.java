import com.process.CompletableFutureAction;
import com.process.SequentialAction;
import com.process.ThreadAction;
import com.process.VirtualThreadAction;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int iterations = 1000;
        long sleepTime = 10;

        System.out.println("Sequential Action total elapsed time : " + new SequentialAction().runSequentialAction(iterations, sleepTime));
        System.out.println("Completable Future Action total elapsed time : " + new CompletableFutureAction().runCompletableFutureAction(iterations, sleepTime));
        System.out.println("Thread Action total elapsed time : " + new ThreadAction().runThreadAction(iterations, sleepTime));
        System.out.println("Virtual Thread Action elapsed time : " + new VirtualThreadAction().runVirtualThreadAction(iterations, sleepTime));
    }
}