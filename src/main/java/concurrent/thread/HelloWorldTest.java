package concurrent.thread;

/**
 * @author lihaoyu
 * @date 2019/11/6 9:51
 */
class Flag{
}

class Hello implements Runnable{
    Flag flag;

    public Hello(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (flag){
                System.out.println("hello");
                flag.notify();
                try {
                    if(i!=4)
                    flag.wait();
                } catch (InterruptedException e) {
                }

            }
        }

    }
}

class World implements Runnable{
    Flag flag;

    public World(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (flag){
                System.out.println("world");
                flag.notify();

                try {
                    if(i!=4)
                    flag.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }
}

public class HelloWorldTest {
    public static void main(String[] args) throws InterruptedException {
        Flag flag = new Flag();
        Thread t1 = new Thread(new Hello(flag));
        Thread t2 = new Thread(new World(flag));
        t1.start();t2.start();
        t1.join();t2.join();
    }

}
