package concurrent.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lihaoyu
 * @date 2019/11/6 22:51
 */

public class ReentrantLockTest implements Runnable {

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 5; j++) {
            lock.lock();
            i++;
            condition.signal();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            lock.unlock();
            System.out.println(Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest test = new ReentrantLockTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);
    }
}

