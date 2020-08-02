package concurrent.leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  1114. 按序打印  三个线程。 三种方法，原始 sync  atomicInteger    countDownLatch
 * @author lihaoyu
 * @date 2020/2/14 22:56
 */
class Foo {

    int flag = 0;

    private AtomicInteger index = new AtomicInteger(0);

    private CountDownLatch latch1 = new CountDownLatch(1);
    private CountDownLatch latch2 = new CountDownLatch(1);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

//        synchronized (this){
//            while(flag != 0){
//                this.wait();
//            }
//            printFirst.run();
//            flag++;
//            this.notifyAll();
//        }

//        while(index.get() != 0);
//        printFirst.run();
//        index.incrementAndGet();

        printFirst.run();
        latch1.countDown();

    }

    public void second(Runnable printSecond) throws InterruptedException {
//        synchronized (this){
//            while(flag != 1){
//                this.wait();
//            }
//            printSecond.run();
//            flag++;
//            this.notifyAll();
//        }
        while(index.get() != 1);
        printSecond.run();
        index.incrementAndGet();

        latch1.await();
        printSecond.run();
        latch2.countDown();

    }

    public void third(Runnable printThird) throws InterruptedException {
//        synchronized (this){
//            while(flag != 2){
//                this.wait();
//            }
//            printThird.run();
//            flag++;
//            this.notifyAll();
//        }
        while(index.get() != 2);
        printThird.run();
        index.incrementAndGet();

    }
}


public class Main1114 {



    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        Thread t1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.println(1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.println(2));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.println(3));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.start();
        t2.start();
        t1.start();
    }
}
