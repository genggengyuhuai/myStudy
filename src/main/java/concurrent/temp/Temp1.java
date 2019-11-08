package concurrent.temp;

/**
 * @author lihaoyu
 * @date 2019/11/6 11:23
 */

public class Temp1 implements Runnable{

    @Override
    public void run() {
        System.out.println("开始");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("被打断");
        }
    }


    public static void main(String[] args)  {
        Thread thread = new Thread(new Temp1());
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("被打断");
        }
        System.out.println(thread.getState());

    }


}
