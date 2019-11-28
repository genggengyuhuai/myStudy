package algorithm.contest.fifth;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/28 9:15
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int C = scanner.nextInt();
            int[] values = new int[N];
            int[] dp = new int[C+1];
            for (int i = 0; i < values.length; i++) {
                values[i] = scanner.nextInt();
            }
            int temp = 0;
            for(int i = 0; i < N; i++){
                for(int j = values[i]; j <= C; j++){
                    temp = dp[j-values[i]];
                    if(temp == 0 && (j-values[i] != 0)){
                        continue;
                    }
                    if(dp[j] == 0){
                        dp[j] = temp + 1;
                    }else{
                        dp[j] = Math.min(temp + 1,dp[j]);
                    }
                }
            }
            System.out.println(dp[C] == 0 ? -1 : dp[C]);
        }
    }
}
