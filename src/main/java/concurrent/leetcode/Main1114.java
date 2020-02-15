package concurrent.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lihaoyu
 * @date 2020/2/14 22:56
 */
class Foo {

    volatile int flag = 0;

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (this){
            while(flag != 0){
                this.wait();
            }
            printFirst.run();
            flag++;
            this.notifyAll();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this){
            while(flag != 1){
                this.wait();
            }
            printSecond.run();
            flag++;
            this.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this){
            while(flag != 2){
                this.wait();
            }
            printThird.run();
            flag++;
            this.notifyAll();
        }
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
