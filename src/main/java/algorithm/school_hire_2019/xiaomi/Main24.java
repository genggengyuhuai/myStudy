package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 * 小米大礼包
 * 99 199 1999 10000 39 1499
 * 10238
 * 一个数组 ，一个target数，数组中的数的和能不能组成target数
 *
 * @author lihaoyu
 * @date 2019/11/13 14:12
 */
public class Main24 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] value = new int[N];
        int[] weight = new int[N];
        for(int i = 0; i < N; i++){
            value[i] = scanner.nextInt();
            weight[i] = value[i];
        }
        int C = scanner.nextInt();
        int[] dp = new int[C+1];
        for(int i = 0; i < N; i++){
            for(int j = C; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(dp[C] == C ? 1 : 0);
    }
}
