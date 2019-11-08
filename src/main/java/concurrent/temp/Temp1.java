package concurrent.temp;

import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.crypto.interfaces.PBEKey;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2019/11/6 11:23
 */

class Test{
    List<Integer> list = new ArrayList<>();

    public synchronized int getSize(){
        System.out.println("getSize");
        return list.size();
    }

    public synchronized void add(int x){
        System.out.println("add");
        list.add(x);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Add implements Runnable{
Test test;

    public Add(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        test.add(12);

    }
}

class Get implements Runnable{
Test test;

    public Get(Test test) {
        this.test = test;
    }

    @Override
    public void run() {
        test.getSize();
    }
}

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
        Test test = new Test();
        Thread thread = new Thread(new Add(test));
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("被打断");
        }
        new Thread(new Get(test)).start();

    }


}
