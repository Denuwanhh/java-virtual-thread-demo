public class ThreadAction {

    public void runThreadAction(int iterations, long sleepTime){
        Thread threads[] = new Thread[iterations];

        // Create and start multiple threads in a loop
        for (int i = 0; i < iterations; i++) {
            final int index = i;
            threads[i] = new Thread(() -> {
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
            threads[i].start(); // Start the thread
        }

        for (Thread thread : threads) {
            try {
                thread.join(); // Wait for thread to complete
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
