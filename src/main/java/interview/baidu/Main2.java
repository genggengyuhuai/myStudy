package interview.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一个数组n个数，每一次从中取一个最大的减去n，其他的数加上1
 * 一直重复到最大的 a[i] < n，执行次数为k
 * 问最少执行多少次操作使得n个数都小于n
 *  2 <= n <= 50
 *  a[i] 为 1 - 10的18次方
 * @author lihaoyu
 * @date 3/29/2020 7:43 PM
 */
public class Main2 {

    // 求最大和次大之间， max - k * n > secMax + k    符合条件最大的k, 最少要减 1 次
    private static long funK(long secMax, long max, int n){
        return Math.max((max - secMax) / (n + 1),1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        Arrays.sort(a);
        if(a[n-1] < n) {
            System.out.println(0);
            return;
        }
        long count = 0;
        long k;

        while(a[n-1] >= n){
            count++;
            k = funK(a[n-2],a[n-1],n);
            for (int i = 0; i < (n - 1); i++) {
                a[i] += k;
            }
            a[n-1] -= k * n;
            Arrays.sort(a);
        }
        System.out.println(count);
    }
}
