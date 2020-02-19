package concurrent.leetcode;

/**
 * @author lihaoyu
 * @date 2/18/2020 5:30 PM
 */
public class Main implements Runnable{

    int index = 0;

    public void run(){
        for(int i = 0; i < 3; i++){
            synchronized(this){
                if((index & 1) == 0){
                    System.out.println("hello");
                    index++;
                    notifyAll();
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("world");
                    index++;
                    notifyAll();
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }


    public static void main(String[] args){

        Main main = new Main();
        new Thread(main).start();
        new Thread(main).start();

    }

}