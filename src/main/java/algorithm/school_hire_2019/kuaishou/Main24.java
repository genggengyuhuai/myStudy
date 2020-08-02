package algorithm.school_hire_2019.kuaishou;

import java.util.Scanner;

/**
 * 二进制中有多少个1  两种方案
 * @author lihaoyu
 * @date 2019/12/24 14:03
 */
public class Main24 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
//        while(n != 0){
//            if((n&1) == 1) count++;
//            n >>= 1;
//        }
        while(n != 0){
            count++;
            n = n & (n-1);
        }
        System.out.println(count);

    }
}
