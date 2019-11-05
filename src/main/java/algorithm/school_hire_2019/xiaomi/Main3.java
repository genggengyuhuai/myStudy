package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 * 给出一个数字N（0<N<1000000）,将N写成立方数和的形式，求出需要的最少立方数个数。
 * 例如N=17，1+8+8 = 17，最少需要3个立方数，则输出3。
 * N= 28,1+1+1+1+8+8+8=28, 需要7个立方数，1+27=28,需要2个立方数，所以最少立方数为2，则输出2。
 * @author lihaoyu
 * @date 2019/11/5 17:21
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] dp = new int[N+1];
        for(int i = 1; i <= N; i++){
            dp[i] = i;
        }
        for(int i = 1; i*i*i <= N; i++){
            for(int j = i*i*i; j <= N; j++){
                dp[j] = Math.min(dp[j],dp[j-i*i*i]+1);
            }
        }
        System.out.println(dp[N]);
    }
}
