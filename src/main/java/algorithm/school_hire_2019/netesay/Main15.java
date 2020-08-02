package algorithm.school_hire_2019.netesay;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/9 9:12
 */
public class Main15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.print( 0 + " ");
            if(n >= 2*k){
                System.out.println(Math.max(k - 1, 0));
            }
            else System.out.println(n-k);
        }
    }
}


