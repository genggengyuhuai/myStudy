package algorithm.main.kuaishou;

import java.util.Scanner;

/**
 *  快手	获得最多的奖金	20.34%
 * @author lihaoyu
 * @date 2019/10/15 10:36
 */
public class Main1 {

    private static long res = 0;

    private static long fun(int[] a){
        int start = 0, end = a.length - 1;
        long sum_start = 0, sum_end = 0;
        while(start < end){
            if(sum_start + a[start] == sum_end + a[end]){
                sum_start += a[start++];
                sum_end += a[end--];
                res = sum_end;
                continue;
            }
            if(sum_start + a[start] > sum_end + a[end]){
                sum_end += a[end--];
                continue;
            }
            if(sum_start + a[start] < sum_end + a[end]){
                sum_start += a[start++];
                continue;
            }
        }
        return res;
    }


    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        System.out.println(fun(a));
    }
}
