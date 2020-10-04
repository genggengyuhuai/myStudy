package algorithm.leetcode;

import java.util.Arrays;

/**
 * 凑零钱问题
 *
 * @author lihaoyu
 * @date 2019/11/30 18:47
 */
public class Main322 {

    // coins = [1, 2, 5], amount = 11
    // F(n) = min( F(n-1), F(n-2), F(n-5) ) + 1  需要的最少硬币数
    public static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++)
            for (int j = 0; j < coins.length; j++)
                if (i - coins[j] >= 0) dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }


    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }

        // 题解都是给的先从 amount 开始遍历    但这里就用完全背包来做
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] == 0) {
                    continue;
                }
                if (dp[j] == 0) {
                    dp[j] = dp[j - coins[i]] + 1;
                } else {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        System.out.println(coinChange2(new int[]{2}, 3));
    }
}
