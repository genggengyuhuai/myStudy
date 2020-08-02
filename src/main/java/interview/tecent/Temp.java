package interview.tecent;

import java.util.Random;

/**
 * @author lihaoyu
 * @date 3/13/2020 11:25 PM
 */
public class Temp {

    private static Integer i;

    private static class Test implements Runnable{

        @Override
        public void run() {
            synchronized (i){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextDouble());
    }
}
