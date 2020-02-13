package algorithm.leetcode;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）
 * 使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * @author lihaoyu
 * @date 2020/2/13 20:13
 */
public class Main279
{
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        int[] stack = new int[n];
        int top = 0;
        for(int i = 1; i * i <= n; i++){
            stack[top++] = i*i;
        }
        for(int i = 1; i <= n;i++){
            for(int j = 0; j < top && stack[j] <= i; j++){
               dp[i] = Math.min(dp[i],1+dp[i-stack[j]]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(14));
    }
}
