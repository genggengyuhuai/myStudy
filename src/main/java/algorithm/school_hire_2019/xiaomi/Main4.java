package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 *  标准 0-1 背包
 * @author lihaoyu
 * @date 2019/11/5 19:38
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int C = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);
        String[] ws = split[2].split(" ");
        String[] vs = split[3].split(" ");
        int[] w = new int[N];
        int[] v = new int[N];
        for(int i = 0; i < N; i++){
            w[i] = Integer.parseInt(ws[i]);
            v[i] = Integer.parseInt(vs[i]);
        }
        int[] dp = new int[C+1];
   /** 第i个物品，背包容量j, 所能得到的最大价值
    *  dp[i][j] = max(dp[i-1][j], v[i] + dp[i-1][j-w[i]])
    *  简化为 dp[j] 一维，从后往前迭代。若为完全背包，则从前往后     */
        for(int i = 0; i < N; i++){
            for(int j = C; j >= w[i]; j--){
                dp[j] = Math.max(dp[j],v[i]+dp[j-w[i]]);
            }
        }
        System.out.println(dp[C]);

    }
}
