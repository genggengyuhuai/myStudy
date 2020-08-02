package concurrent.thread;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lihaoyu
 * @date 2019/11/7 15:19
 */
public class ThreadPoolTest implements Runnable{

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() +"  "+Thread.currentThread().getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadPoolTest task = new ThreadPoolTest();
        ExecutorService es = new ThreadPoolExecutor(5, 10, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(20));
        for (int i = 0; i < 30; i++) {
            es.submit(task);
        }
    }


}
