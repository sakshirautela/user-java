public class ThreadMethods extends Thread {
    public ThreadMethods(String s) {
        super(s);
    }

    @Override
    public void run() {
        System.out.println("Thread is running");
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
            // Thread.yield();
        }
    }

    public static void main(String[] args) {
        // ThreadMethods l = new ThreadMethods("low"); // Create a thread of your custom
        // class
        // ThreadMethods m = new ThreadMethods("medium");
        // ThreadMethods h = new ThreadMethods("high");
        // l.setPriority(MIN_PRIORITY);
        // m.setPriority(NORM_PRIORITY);
        // h.setPriority(MAX_PRIORITY);
        // l.start(); // Starts the thread, calls run() method internally
        // m.start();
        // h.start();
        // h.interrupt();
        // try {
        // l.join(); // Wait for the thread to finish
        // m.join();
        // h.join();
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        ThreadMethods thread = new ThreadMethods("Demon");
        thread.setDaemon(true);
        thread.start();
        /*
         * Important Notes about Daemon Threads in Java:
         * Daemon threads are background threads that do not prevent the JVM from
         * exiting.
         * 
         * The JVM exits as soon as all user (non-daemon) threads finish, even if daemon
         * threads are still running.
         * 
         * Since your main() method doesn't create any user threads (only the daemon
         * thread), the JVM might exit immediately after the main thread ends.
         * 
         * Therefore, in most runs, you may not see any output at all or only a single
         * "Thread is running" message — the daemon thread likely gets killed before it
         * can print much.
         * 
         */
    }
}
