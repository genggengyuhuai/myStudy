package algorithm.leetcode;

/**
 * 给定不同面额的硬币和一个总金额。
 * 写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *  dp[i][j] 表示前 i 个硬币可以组成 j 金额的组合数
 * @author lihaoyu
 * @date 2019/12/5 11:41
 */
public class Main518{

    private static void fun(int[] coins,int amount){
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j <= amount; j++){
                dp[j] = dp[j] + dp[j-coins[i]];
            }
        }
        System.out.println(dp[amount]);

    }

    public static void main(String[] args) {

        System.out.println();
        fun(new int[]{3,2,5},10);
    }
}
