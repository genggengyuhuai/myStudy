package algorithm.school_hire_2019.hanwuji;

import java.util.Scanner;

/**
 * 计数器
 * @author lihaoyu
 * @date 2019/12/30 13:01
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long start = 1;
        long len = 3;
        while (!(start <= n && n < start + len)) {
            start += len;
            len <<= 1;
        }
        System.out.println(start+len-n);
    }
}
