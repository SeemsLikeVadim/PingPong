import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static final ReentrantLock locker = new ReentrantLock();
    public static void main(String[] args) {
        PingPonger pingPonger = new PingPonger();
        new Thread(new Pinger(pingPonger,locker)).start();
        new Thread(new Ponger(pingPonger,locker)).start();
    }
}
