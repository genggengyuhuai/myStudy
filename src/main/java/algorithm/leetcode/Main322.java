package algorithm.leetcode;

/**
 * @author lihaoyu
 * @date 2019/11/30 18:47
 */
public class Main322 {

    public static int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0 || amount < 0) return -1;
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }
        // 题解都是给的先从 amount 开始遍历    但这里就用完全背包来做
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                if(dp[j-coins[i]] == 0){
                    continue;
                }
                if(dp[j] == 0) {
                   dp[j] = dp[j-coins[i]] + 1;
                }else{
                    dp[j] = Math.min(dp[j - coins[i]] + 1,dp[j]);
                }
            }
        }
        for (int i : dp) {
            System.out.print(i+" ");
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{3,5,7},30));
    }
}
