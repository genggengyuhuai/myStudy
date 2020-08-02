package temp;

/**
 * @author lihaoyu
 * @date 3/24/2020 11:00 AM
 */
public class Temp1 {

    public static void test(){
        int i = 8;
        while((i -= 3) > 0);
        System.out.println("i = " + i);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50000; i++) {
            Temp1.test();
        }
    }
}
