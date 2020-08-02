package concurrent.leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author lihaoyu
 * @date 2020/2/16 12:47
 */

class FizzBuzz {
    private int n;

    private AtomicInteger index;

    public FizzBuzz(int n) {
        this.n = n;
        this.index = new AtomicInteger(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(index.get() <= n && index.get() % 3 != 0){
        }


    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {

    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {

    }
}






public class Main1195 {
}
