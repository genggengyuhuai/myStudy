package concurrent.temp;

/**
 * @author lihaoyu
 * @date 2019/12/19 9:45
 */
public class BadLock implements Runnable{
    // 不可变量 不能做为 sync 锁住的对象
    public static volatile Integer i = 0;

    @Override
    public void run() {
        for(int j = 0; j < 100000; j++){
            synchronized (i){
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BadLock instance = new BadLock();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();t2.start();
        t1.join();t2.join();
        System.out.println(i);

    }

}
