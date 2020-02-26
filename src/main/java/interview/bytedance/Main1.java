package interview.bytedance;

/**
 * @author lihaoyu
 * @date 2/25/2020 3:58 PM
 */
public class Main1 {

    private static volatile Integer anInt = 0;

    static class A implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                anInt++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new A());
        Thread t2 = new Thread(new A());
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(anInt);
    }


}
