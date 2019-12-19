package concurrent.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  模拟死锁，两个线程争夺两个资源
 * @author lihaoyu
 * @date 2019/12/19 10:04
 */
public class DeathLock implements Runnable{

    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();
    int number;

    public DeathLock(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            // 第一个线程
            if (number == 1) {
              lock1.lock();
                Thread.sleep(400);
                lock2.lock();
            }
            // 第二个线程
            else{
                lock2.lock();
                Thread.sleep(400);
                lock1.lock();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeathLock test1 = new DeathLock(1);
        DeathLock test2 = new DeathLock(2);
        Thread t1 = new Thread(test1);
        Thread t2 = new Thread(test2);
        t1.start();t2.start();
//        t1.join();t2.join();
        Thread.sleep(1000);
//        t1.interrupt();
        System.out.println("所有线程运行完毕");
    }


}
