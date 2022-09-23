import java.util.concurrent.locks.ReentrantLock;

public class Ponger implements Runnable {
    PingPonger pingPonger;
    ReentrantLock locker;

    public Ponger(PingPonger pingPonger, ReentrantLock lock) {
        this.pingPonger = pingPonger;
        locker = lock;
    }

    @Override
    public void run() {
        while (true) {
            locker.lock();
            try {
                pingPonger.pong();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } finally {
                locker.unlock();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
