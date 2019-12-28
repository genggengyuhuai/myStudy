package algorithm.school_hire_2019.pinduoduo;

import java.util.Scanner;

/**
 * 牛牛和妞妞去海边捡了一大袋美丽的贝壳，千辛万苦地运回家后，牛牛和妞妞打算分掉这些贝壳。
 * 牛牛提出，他和妞妞轮流从还没有分配的贝壳中取一定数量的贝壳，直到贝壳分完为止。分配规则是牛牛每次取剩余贝壳的1/10（向下取整），妞妞每次固定取m个贝壳，妞妞先取。
 * 妞妞想要得到不少于一半的贝壳，又不想太过分，那么她一次最少取多少个贝壳才能得到不少于一半的贝壳呢？
 * @author lihaoyu
 * @date 2019/12/28 13:37
 */
public class Main5 {

    private static long fun(long n, long x){
        long sum = 0;
        while(n > 0){
            if(n >= x){
                sum += x;
                n -= x;
            }else{
                sum += n;
                break;
            }
            n -= n/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long left = 1, right = n / 10, mid = 0;
        while(left < right){
            mid = (left + right) >> 1;
            if(fun(n,mid) >= n/2){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
