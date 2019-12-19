package concurrent.thread;


import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author lihaoyu
 * @date 2019/12/2 16:10
 */

public class BlockingQueueTest {

    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5,false);
    public static void main(String[] args) {
        queue.add("asd");

    }
}
