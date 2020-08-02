package algorithm.school_hire_2019.kuaishou;

import java.util.Scanner;

/**
 *  快手	数字序列第n位的值	1360	41.40%
 * 太简单 忽略
 * @author lihaoyu
 * @date 2019/10/26 19:35
 */
public class Main21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = 1;
        while(n>0){
            n -= (k++);
        }
        System.out.println(k-1);
    }


}
