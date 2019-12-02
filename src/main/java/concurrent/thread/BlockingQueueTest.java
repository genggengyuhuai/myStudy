package concurrent.thread;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author lihaoyu
 * @date 2019/12/2 16:10
 */
public class BlockingQueueTest {

    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5,false);

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            for(int i = 0; i < 5;i++)
            try {
                queue.put(" "+i+" ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

            new Thread(()->{
                try {
                    queue.put(" "+11+" ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        new Thread(()->{
            try {
                queue.put(" "+22+" ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                queue.put(" "+33+" ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(500);
        new Thread(()->{
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(500);
        System.out.println(queue);
    }
}
