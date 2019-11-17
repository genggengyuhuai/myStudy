package concurrent.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lihaoyu
 * @date 2019/11/17 14:35
 */
public class HelloAndWorldUseAQS {
    /***
     *  多线程打印 Hello World 使用lock 搭配 Condition
     *
     */
    private static volatile int count = 0;
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args){

        new Thread(()->{
            while(true){
                lock.lock();
                if((count & 1) == 0){
                    condition.awaitUninterruptibly();
                }
                count++;
                System.out.println("hello");
                condition.signal();
                lock.unlock();
            }
        }).start();

        new Thread(()->{
            while(true){
                lock.lock();
                if((count & 1) == 1){
                    condition.awaitUninterruptibly();
                }
                count++;
                System.out.println("world");
                condition.signal();
                lock.unlock();
            }
        }).start();
    }
}
