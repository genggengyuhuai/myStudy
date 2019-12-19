package concurrent.temp;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用 Lock 和 Condition 配合 轮流打印 Hello 和 World
 * @author lihaoyu
 * @date 2019/11/9 11:34
 */
public class HelloWorld{

    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    private static class Hello implements Runnable{
        @Override
        public void run() {
            int i = 10;
            while(i-- != 0){
                lock.lock();
                System.out.println("Hello");
                condition.signal();
                try {
                    if(i!=0)
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }

    private static class World implements Runnable{
        @Override
        public void run() {
            int i = 10;
            while(i-- != 0){
                lock.lock();
                System.out.println("World");
                condition.signal();
                try {
                    if(i!=0)
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }

public static void main(String[] args) {
    new Thread(new Hello()).start();
    new Thread(new World()).start();


}


}
