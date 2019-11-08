package concurrent.thread;

/**
 * @author lihaoyu
 * @date 2019/11/5 15:15
 */
import java.util.ArrayList;

/*
 * 生产者消费者多线程 模型
 */
class Apple {
    int id;
    public Apple(int id) {
        // TODO Auto-generated constructor stub
        this.id = id;
    }
}

class Consumer implements Runnable {
    public ArrayList<Apple> list;

    public Consumer(ArrayList<Apple> list) {
        this.list = list;
    }

    public  void consume() {
        for (int i = 0; i < 10; i++) {
            synchronized (list) {
                while(list.isEmpty()) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                Apple temp = list.get(list.size() - 1);
                System.out.println("消费" + temp.id);
                list.remove(list.size()-1);
                list.notify();
                //当i是9的时候就不要wait了，让程序结束吧
                if(i!=9)
                {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        consume();
    }
}

class Producer implements Runnable {
    public ArrayList<Apple> list;

    public Producer(ArrayList<Apple> list) {
        this.list = list;
    }

    public void produce() {
        for (int i = 0; i < 10; i++) {
            synchronized (list) {
                while(list.size()>=10) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                Apple temp = new Apple(i);
                System.out.println("生产"+temp.id);
                list.add(temp);
                list.notify();
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        produce();
    }
}
public class ProduceAndConsumeTest {
    public static void main(String[] args) {
        ArrayList<Apple> list = new ArrayList<>();
        Runnable consumer = new Consumer(list);
        Runnable producer = new Producer(list);
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);
        t1.start();
        t2.start();

    }

}
