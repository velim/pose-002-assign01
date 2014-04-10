// Import the necessary Java synchronization and scheduling classes.
import java.util.concurrent.Semaphore;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/**
 * @class PingPongRight
 *
 * @brief This class implements a Java program that creates two
 *        instances of the PlayPingPongThread and start these thread
 *        instances to correctly alternate printing "Ping" and "Pong",
 *        respectively, on the console display.
 */
public class PingPongRight
{
    /**
     * @class SimpleSemaphore
     *
     * @brief This class provides a simple counting semaphore
     *        implementation using Java a ReentrantLock and a
     *        ConditionObject.
     */
    static public class SimpleSemaphore
    {
        /**
         * Constructor initialize the data members. 
         */
        public SimpleSemaphore (int maxPermits)
        { 
            // TODO - You fill in here.
        }

        /**
         * Acquire one permit from the semaphore.
         */
        public void acquire() throws InterruptedException
        {
            // TODO - You fill in here.
        }

        /**
         * Return one permit to the semaphore.
         */
        void release() throws InterruptedException
        {
            // TODO - You fill in here.
        }

        /**
         * Use a ReentrantLock to protect the critical section.
         */
        // TODO - You fill in here.

        /**
         * Use a ConditionObject to wait while the number of permits
         * is 0.
         */
        // TODO - You fill in here.

        /**
         * A count of the number of available permits.
         */
        // TODO - You fill in here.
    }

    /**
     * Number of iterations to run the test program.
     */
    public static int mMaxIterations = 10;
    
    /**
     * Latch that will be decremented each time a thread exits.
     */
    public static CountDownLatch latch = null; // TODO - You fill in here

    /**
     * @class PlayPingPongThread
     *
     * @brief This class implements the ping/pong processing algorithm
     *         using the SimpleSemaphore to alternate printing "ping"
     *         and "pong" to the console display.
     */
    public static class PlayPingPongThread extends Thread
    {
        private final String m_text;
        private final SimpleSemaphore m_semaphore;

        /**
         * Constructor initializes the data member.
         */
        public PlayPingPongThread (String text, SimpleSemaphore semaphore)
        {
            m_text = text;
            m_semaphore = semaphore;
        }

        /**String
         * Main event loop that runs in a separate thread of control
         * and performs the ping/pong algorithm using the
         * SimpleSemaphores.
         */
        public void run () 
        {
            try {
                m_semaphore.acquire();
                System.out.println(m_text);
                m_semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        /**
         * Number of iterations to run.
         */
        // TODO - You fill in here.
        int cnt = 10;
        
        /**
         * Number of iterations to run.
         */
        // TODO - You fill in here.

        /**
         * The two SimpleSemaphores use to alternate pings and pongs.
         */
        // TODO - You fill in here.
    }

    /**
     * The main() entry point method into PingPongRight program. 
     */
    public static void main(String[] args) {
        try {         
            // Create the ping and pong SimpleSemaphores that control
            // alternation between threads.

            // TODO - You fill in here.
            SimpleSemaphore pingSSemaphore = new SimpleSemaphore(1);
            SimpleSemaphore pongSSemaphore = new SimpleSemaphore(1);

            System.out.println("Ready...Set...Go!");

            // Create the ping and pong threads, passing in the string
            // to print and the appropriate SimpleSemaphores.
            PlayPingPongThread ping =
                new PlayPingPongThread("Ping!", pingSSemaphore);
            PlayPingPongThread pong =
                new PlayPingPongThread("Pong!", pongSSemaphore);
            
            // Initiate the ping and pong threads, which will call the
            // run() hook method.
            ping.start();
            pong.start();

            // Use barrier synchronization to wait for both threads to
            // finish.

            ping.join();
            pong.join();

            // TODO - replace this line:
            throw new java.lang.InterruptedException();
        } 
        catch (java.lang.InterruptedException e)
            {}

        System.out.println("Done!");
    }
}
