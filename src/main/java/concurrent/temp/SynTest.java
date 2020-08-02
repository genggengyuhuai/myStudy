package concurrent.temp;

/**
 * @author lihaoyu
 * @date 2020/1/12 12:10
 */
public class SynTest{

    public synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public synchronized void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }


    public static void main(String[] args) {
        final SynTest test = new SynTest();
        new Thread(() -> test.method1()).start();
        new Thread(() -> test.method2()).start();
    }

}
