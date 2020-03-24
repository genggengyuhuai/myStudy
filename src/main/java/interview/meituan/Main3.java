package interview.meituan;


import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 3/12/2020 8:36 PM
 */
public class Main3 {

    private static int L;
    private static int R;
    private static int n;
    private static int k;

    private static long count = 0;
    private static void fun(int height, int cur){
        if(height == n){
            if(cur % k == 0) count++;
            if(count == 1e9+7) count = 0;
            return;
        }
        for (int i = L; i <= R; i++) {
            fun(height+1, cur+i);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        L = scanner.nextInt();
        R = scanner.nextInt();
        fun(0,0);
        System.out.println(count);
    }
}
