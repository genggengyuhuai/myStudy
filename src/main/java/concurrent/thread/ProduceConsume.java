package concurrent.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lihaoyu
 * @date 2019/11/7 19:03
 */
public class ProduceConsume {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static class Producer implements Runnable {
        @Override
        public void run() {
            try {
                // queue的同步是内部是用 ReentrantLock 锁和 Condition 实现的
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 注意这里的打印没有控制同步锁，所以可能会乱序，所以后面用了sleep
            System.out.print("produce..");
        }
    }
    private static class Consumer implements Runnable {
        @Override
        public void run() {
            try {
                String product = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("consume..");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        ExecutorService executorService =
                new ThreadPoolExecutor(3,10,60L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(5));
        for (int i = 0; i < 2; i++) {
            executorService.submit(producer);Thread.sleep(500);
        }
        for (int i = 0; i < 3; i++) {
            executorService.submit(consumer);Thread.sleep(500);
        }
        for (int i = 0; i < 7; i++) {
            executorService.submit(producer);Thread.sleep(500);
        }
    }
}