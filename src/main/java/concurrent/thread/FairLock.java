package concurrent.thread;

/**
 * @author lihaoyu
 * @date 2019/11/5 15:30
 */
import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {

    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args){
        Thread.currentThread().setPriority(10);
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1, "one");
        Thread t2 = new Thread(r1, "two");
        Thread t3 = new Thread(r1, "three");
        t1.start();
        t2.start();
        t3.start();
        return;
    }
}
