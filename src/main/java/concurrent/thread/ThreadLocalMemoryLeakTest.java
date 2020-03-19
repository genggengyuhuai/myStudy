package concurrent.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 3/18/2020 11:42 AM
 */
public class ThreadLocalMemoryLeakTest {

    public ThreadLocal<List<Object>> threadId = ThreadLocal.withInitial(() -> {
        // 定义初始化方法
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    });
    // Returns the current thread's unique ID, assigning it if necessary
    public List<Object> get() {
        return threadId.get();
    }
    // remove currentid
    public void remove() {
        threadId.remove();
    }

    private static void incrementSameThreadId(ThreadLocalMemoryLeakTest thread){
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread()+"_"+ i + "_"+thread.get());
        }
    }



    public static void main(String[] args) {
        ThreadLocalMemoryLeakTest test = new ThreadLocalMemoryLeakTest();
        incrementSameThreadId(test);
        // 模拟线程一直运行
        while (true) {
        }
    }
}
